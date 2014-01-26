package de.abrandl.regex.lucene;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;

import de.abrandl.regex.RegexSearchEngine;
import de.abrandl.regex.SearchFailedException;
import de.abrandl.regex.UnsupportedRegexException;
import de.abrandl.regex.document.FileDocument;
import de.abrandl.regex.document.SimpleDocument;
import de.abrandl.regex.grammar.RegexParsingException;
import de.abrandl.regex.helpers.DetailsCollector;
import de.abrandl.regex.helpers.Timer;

public class LuceneRegexpEngine implements RegexSearchEngine {

	private final Version luceneVersion;

	private final Directory directory;

	private final Timer timer = new Timer();

	public LuceneRegexpEngine(Version luceneVersion, Directory directory) {
		this.luceneVersion = luceneVersion;
		this.directory = directory;
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
				return performSearch(regex);
			} catch (RegexParsingException | IOException e) {
				throw new SearchFailedException(e);
			}
		}

		private Collection<SimpleDocument> performSearch(String regex) throws RegexParsingException, IOException,
				UnsupportedRegexException {
			IndexSearcher isearcher = new IndexSearcher(index);
			timer.reset();
			timer.start();
			Query query = constructQueryFromRegex(regex);
			DetailsCollector.instance.put("query_transformation_time", timer.stop());
			timer.reset();

			final Collection<SimpleDocument> matches = new HashSet<SimpleDocument>();

			// perform search
			timer.start();
			ScoreDoc[] scoreDocs = isearcher.search(query, Integer.MAX_VALUE).scoreDocs;

			for (ScoreDoc scoreDoc : scoreDocs) {
				Document hitDoc = isearcher.doc(scoreDoc.doc);
				matches.add(fromDocument(hitDoc));
			}

			DetailsCollector.instance.put("search_time", timer.stop());
			timer.reset();

			return matches;
		}

		private SimpleDocument fromDocument(Document doc) {
			String identifier = doc.get("identifier");
			return new FileDocument(identifier);
		}

	}

	private Query constructQueryFromRegex(String regex) throws RegexParsingException, UnsupportedRegexException {
		check(!regex.startsWith("^"), "regex must not start with anchor ^");
		check(!regex.startsWith("$"), "regex must not end with anchor $");

		if (!regex.startsWith(".*")) {
			regex = "@" + regex;
		}
		if (!regex.endsWith(".*") && !regex.endsWith("@")) {
			regex = regex + "@";
		}

		if (regex.equals(".*") || regex.equals("@")) {
			return new MatchAllDocsQuery();
		} else {
			DetailsCollector.instance.put("regexp", regex);
			return new RegexpQuery(new Term("content", regex));
		}
	}

	private void check(boolean b, String string) throws UnsupportedRegexException {
		if (!b) {
			throw new UnsupportedRegexException(string);
		}
	}

	private class Writer implements RegexSearchEngine.Writer {

		private volatile IndexWriter writer = null;

		private final int poolSize = 7;

		private Writer() {

		}

		@Override
		public void close() throws IOException {
			if (writer != null) {
				writer.forceMerge(1);
				writer.commit();
				writer.close();
				writer = null;
			}
		}

		@Override
		public void open() throws IOException {
			if (writer == null) {
				IndexWriterConfig config = new IndexWriterConfig(luceneVersion, new KeywordAnalyzer());
				config.setRAMBufferSizeMB(512.0d);
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

			final ExecutorService pool = Executors.newFixedThreadPool(poolSize);
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

			while (!pool.isTerminated()) {
				pool.shutdown();
				try {
					pool.awaitTermination(10, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
				}
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

			writer.commit();

		}

		private void add(SimpleDocument document) throws IOException {
			String content = document.getContent();

			Document ldoc = new org.apache.lucene.document.Document();
			ldoc.add(new StringField("identifier", document.getIdentifier(), Store.YES));
			ldoc.add(new StringField("content", content, Store.YES));

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
	public String explain(String query) throws UnsupportedRegexException {
		try {
			return constructQueryFromRegex(query).toString();
		} catch (RegexParsingException e) {
			return "unparseable query: " + e.getMessage();
		}
	}

}
