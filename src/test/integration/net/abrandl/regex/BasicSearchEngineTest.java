package net.abrandl.regex;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import net.abrandl.lucene.regex.*;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public abstract class BasicSearchEngineTest {

	private final RegexSearchEngine exhaustiveSearch = new ExhaustiveSearchEngine();
	private final RegexSearchEngine ngramSearch = new NGramRegexSearchEngine(3);

	private final TestDatasets dataset;

	public BasicSearchEngineTest(TestDatasets dataset) {
		this.dataset = dataset;
	}

	@Before
	public void indexDocuments() throws IOException {
		dataset.createIndex(exhaustiveSearch);
		dataset.createIndex(ngramSearch);
	}

	@Test
	public void testQueries() throws SearchFailedException, IOException {
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

		System.out.printf("expected   [%03d]:   %s\n", expected.size(), expected);

		Collection<Document> result = ngramSearch.search(regex);

		System.out.printf("result     [%03d]:   %s\n", result.size(), result);

		assertThat(result, equalTo(expected));
	}

}
