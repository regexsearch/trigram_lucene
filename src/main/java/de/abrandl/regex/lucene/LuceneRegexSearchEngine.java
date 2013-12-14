package de.abrandl.regex.lucene;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import org.apache.lucene.document.*;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;

import de.abrandl.regex.RegexSearchEngine;
import de.abrandl.regex.SearchFailedException;
import de.abrandl.regex.document.FileDocument;
import de.abrandl.regex.document.SimpleDocument;
import de.abrandl.regex.grammar.RegexParser;
import de.abrandl.regex.grammar.RegexParsingException;
import de.abrandl.regex.grammar.tree.RegexNode;
import de.abrandl.regex.helpers.DetailsCollector;
import de.abrandl.regex.helpers.Timer;
import de.abrandl.regex.query.NGramQueryTransformation;
import de.abrandl.regex.query.bool.Expression;

public class LuceneRegexSearchEngine implements RegexSearchEngine {

	private final Version luceneVersion;

	private final Directory directory;
	private final NGramAnalyzer analyzer;
	private final NGramQueryTransformation queryTransformation;

	private final Timer timer = new Timer();

	public LuceneRegexSearchEngine(Version luceneVersion, Directory directory) {
		this.luceneVersion = luceneVersion;
		this.directory = directory;

		analyzer = new NGramAnalyzer(luceneVersion);
		queryTransformation = new NGramQueryTransformation();
	}

	private class Reader implements RegexSearchEngine.Reader {

		private DirectoryReader index;

		@Override
		public void close() throws IOException {
			if (index != null) {
				index.close();
				index = null;
			}
		}

		@Override
		public void open() throws IOException {
			if (index == null) {
				index = DirectoryReader.open(directory);
			}
		}

		@Override
		public Collection<SimpleDocument> search(String regex) throws SearchFailedException {

			try {
				open();
				Collection<Document> hits = performSearch(regex);

				return convertToSimpleDocument(hits);
			} catch (RegexParsingException | IOException e) {
				throw new SearchFailedException(e);
			}
		}

		private Collection<Document> performSearch(String regex) throws RegexParsingException, IOException {
			IndexSearcher isearcher = new IndexSearcher(index);
			timer.start();
			Query query = constructQueryFromRegex(regex);
			DetailsCollector.instance.put("query_transformation_time", timer.stop());
			timer.reset();

			PostFilterCollector collector = new PostFilterCollector("content", Pattern.compile(regex));

			// perform search
			timer.start();
			isearcher.search(query, collector);
			DetailsCollector.instance.put("search_time", timer.stop());
			timer.reset();

			return collector.getMatches();
		}

		private Collection<SimpleDocument> convertToSimpleDocument(final Collection<Document> hits) {
			final Collection<SimpleDocument> resultSet = new HashSet<SimpleDocument>(hits.size());

			for (Document doc : hits) {
				String identifier = doc.get("identifier");

				resultSet.add(new FileDocument(identifier));
			}
			return resultSet;
		}

	}

	private Query constructQueryFromRegex(String regex) throws RegexParsingException {
		RegexNode parsedRegex = RegexParser.parse(regex);
		Expression expression = queryTransformation.expressionFor(parsedRegex);

		DetailsCollector.instance.put("ngram_boolean_query", expression.toString());

		return expression.accept(new LuceneExpressionQuery("trigrams"));
	}

	private class Writer implements RegexSearchEngine.Writer {

		private volatile IndexWriter writer = null;

		private final int poolSize = 7;
		private final ExecutorService pool;

		private Writer() {
			pool = Executors.newFixedThreadPool(poolSize);
		}

		@Override
		public void close() throws IOException {
			if (writer != null) {
				writer.close();
				writer = null;
			}
		}

		@Override
		public void open() throws IOException {
			if (writer == null) {
				IndexWriterConfig config = new IndexWriterConfig(luceneVersion, analyzer);
				writer = new IndexWriter(directory, config);
			}
		}

		private volatile IOException lastException;

		private synchronized void setIOException(IOException e) {
			lastException = e;
		}

		/**
		 * Add a bunch of documents to the index. Note that the Iterator needs
		 * to be thread-safe.
		 */
		@Override
		public void add(final Iterator<SimpleDocument> docs) throws IOException {
			open();

			final CountDownLatch latch = new CountDownLatch(poolSize);

			for (int i = 0; i < poolSize; i++) {
				pool.execute(new Runnable() {

					@Override
					public void run() {
						while (docs.hasNext() && lastException == null) {
							try {
								add(docs.next());
							} catch (IOException e) {
								setIOException(e);
							}
						}
						latch.countDown();
					}
				});
			}

			try {
				latch.await();
			} catch (InterruptedException e) {
			}

			if (lastException != null) {
				IOException e = lastException;
				lastException = null;
				throw e;
			}

		}

		private void add(SimpleDocument document) throws IOException {
			String content = document.getContent();

			Document ldoc = new org.apache.lucene.document.Document();
			ldoc.add(new StringField("identifier", document.getIdentifier(), Store.YES));
			ldoc.add(new StringField("content", content, Store.YES));
			ldoc.add(new Field("trigrams", content, TextField.TYPE_STORED));

			writer.addDocument(ldoc);
		}

	}

	@Override
	public de.abrandl.regex.RegexSearchEngine.Writer getWriter() {
		return new Writer();
	}

	@Override
	public de.abrandl.regex.RegexSearchEngine.Reader getReader() {
		return new Reader();
	}

	@Override
	public Collection<SimpleDocument> search(String regex) throws SearchFailedException, IOException {
		try (RegexSearchEngine.Reader reader = getReader()) {
			return reader.search(regex);
		}
	}

	@Override
	public String explain(String query) {
		try {
			return constructQueryFromRegex(query).toString();
		} catch (RegexParsingException e) {
			return "unparseable query: " + e.getMessage();
		}
	}

}
