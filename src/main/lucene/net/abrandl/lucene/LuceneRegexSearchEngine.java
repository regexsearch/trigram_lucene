package net.abrandl.lucene;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Pattern;

import net.abrandl.lucene.regex.Document;
import net.abrandl.lucene.regex.RegexSearchEngine;
import net.abrandl.lucene.regex.SearchFailedException;
import net.abrandl.lucene.regex.grammar.RegexParser;
import net.abrandl.lucene.regex.grammar.RegexParsingException;
import net.abrandl.lucene.regex.grammar.tree.RegexNode;
import net.abrandl.lucene.regex.query.NGramQueryTransformation;
import net.abrandl.lucene.regex.query.bool.Expression;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;

public class LuceneRegexSearchEngine implements RegexSearchEngine {

	private final Version luceneVersion;
	private final Directory directory;
	private final NGramAnalyzer analyzer;
	private final NGramQueryTransformation queryTransformation;

	public LuceneRegexSearchEngine(Version luceneVersion, Directory directory) {
		this.luceneVersion = luceneVersion;
		this.directory = directory;

		analyzer = new NGramAnalyzer(luceneVersion);
		queryTransformation = new NGramQueryTransformation();
	}

	@Override
	public void addDocument(Document document) throws IOException {
		IndexWriterConfig config = new IndexWriterConfig(luceneVersion, analyzer);

		// TODO: open/close index to reduce overhead
		try (IndexWriter iwriter = new IndexWriter(directory, config)) {
			org.apache.lucene.document.Document ldoc = new org.apache.lucene.document.Document();
			ldoc.add(new Field("identifier", document.getIdentifier(), Store.YES, Index.NOT_ANALYZED));
			ldoc.add(new Field("content", document.getContent(), Store.YES, Index.NOT_ANALYZED));
			ldoc.add(new Field("trigrams", document.getContent(), TextField.TYPE_STORED));
			iwriter.addDocument(ldoc);
		}
	}

	@Override
	public Collection<Document> search(String regex) throws SearchFailedException {
		try (DirectoryReader ireader = DirectoryReader.open(directory)) {
			IndexSearcher isearcher = new IndexSearcher(ireader);

			RegexNode parsedRegex = RegexParser.parse(regex);
			Expression expression = queryTransformation.expressionFor(parsedRegex);

			System.out.println(expression);

			Query query = expression.accept(new LuceneExpressionQuery("trigrams"));

			System.out.println(query);

			ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
			System.out.println(String.format("Got %d hits", hits.length));

			Collection<Document> resultSet = new HashSet<Document>(hits.length);

			Pattern pattern = Pattern.compile(regex);

			for (int i = 0; i < hits.length; i++) {
				org.apache.lucene.document.Document doc = isearcher.doc(hits[i].doc);
				Document d = new Document(doc.get("identifier"), doc.get("content"));
				if (pattern.matcher(d.getContent()).find()) {
					resultSet.add(d);
				}
			}

			return resultSet;

		} catch (IOException e) {
			throw new SearchFailedException(e);
		} catch (RegexParsingException e) {
			throw new SearchFailedException(e);
		}
	}

}
