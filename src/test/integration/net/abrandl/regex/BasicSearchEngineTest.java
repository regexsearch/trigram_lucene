package net.abrandl.regex;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import net.abrandl.lucene.regex.*;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BasicSearchEngineTest {

	private final RegexSearchEngine exhaustiveSearch = new ExhaustiveSearchEngine();
	private final RegexSearchEngine ngramSearch = new NGramRegexSearchEngine(3);

	private final TestDatasets dataset = TestDatasets.KEYWORDS;

	@Before
	public void indexDocuments() throws IOException {
		dataset.createIndex(exhaustiveSearch);
		dataset.createIndex(ngramSearch);
	}

	@Test
	public void runAllQueries() throws SearchFailedException, IOException {
		Iterator<String> queries = dataset.queries();

		while (queries.hasNext()) {
			String regex = queries.next();
			searchDocuments(regex);
		}
	}

	private void searchDocuments(String regex) throws SearchFailedException {
		System.out.println("********************************************************");
		System.out.printf("Query: /%s/\n", regex);

		Collection<Document> expected = exhaustiveSearch.search(regex);

		System.out.println("expected:");
		System.out.println(expected);

		Collection<Document> result = ngramSearch.search(regex);

		System.out.println("result:");
		System.out.println(result);

		assertThat(result, equalTo(expected));
	}

}
