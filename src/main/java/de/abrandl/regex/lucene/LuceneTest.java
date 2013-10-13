package de.abrandl.regex.lucene;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


import org.apache.commons.io.FileUtils;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import de.abrandl.regex.Document;
import de.abrandl.regex.RegexSearchEngine;

public class LuceneTest {

	private static final Version LUCENE44 = Version.LUCENE_44;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		File path = new File("/tmp/index");

		if (path.isDirectory()) {
			FileUtils.deleteDirectory(path);
		}

		try (Directory directory = FSDirectory.open(path)) {

			RegexSearchEngine engine = new LuceneRegexSearchEngine(LUCENE44, directory);

			List<String> strings = Arrays.asList("text to be indexed", "the the text to be indexed");

			for (int index = 0; index < strings.size(); index++) {
				engine.addDocument(new Document(String.format("doc %d", index), strings.get(index)));
			}

			String query = "(the |another )*text";
			System.out.println(query);
			Collection<Document> result = engine.search(query);

			for (Document doc : result) {
				System.out.println(String.format("%s -- %s", doc.getIdentifier(), doc.getContent()));
			}
		}

		// // Now search the index:
		// DirectoryReader ireader = DirectoryReader.open(directory);
		// IndexSearcher isearcher = new IndexSearcher(ireader);
		// // Parse a simple query that searches for "text":
		// QueryParser parser = new QueryParser(LUCENE44, "trigrams", analyzer);
		// Query query = parser.parse("text");
		// System.out.println(query);
		// ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
		// assertEquals(1, hits.length);
		// System.out.println(String.format("Got %d hits", hits.length));
		// // Iterate through the results:
		// for (int i = 0; i < hits.length; i++) {
		// Document hitDoc = isearcher.doc(hits[i].doc);
		// assertEquals("this is the text to be indexed",
		// hitDoc.get("content"));
		// }
		// ireader.close();
		// directory.close();
	}

	private static <T> void assertEquals(T expected, T actual) {
		if (!expected.equals(actual)) {
			throw new RuntimeException(String.format("expected: %s, got: %s", expected, actual));
		}
	}

}
