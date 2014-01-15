package de.abrandl.regex;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import de.abrandl.regex.document.SimpleDocument;
import de.abrandl.regex.helpers.DetailsCollector;
import de.abrandl.regex.lucene.LuceneRegexSearchEngine;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public abstract class BasicSearchEngineTest {

	private RegexSearchEngine exhaustiveSearch;
	private RegexSearchEngine luceneSearch;
	private RegexSearchEngine inmemorySearch;
	private RegexSearchEngine targrep;

	private final TestDatasets dataset;

	public BasicSearchEngineTest(TestDatasets dataset) {
		this.dataset = dataset;
	}

	private void indexDocuments() throws IOException {

		exhaustiveSearch = new ExhaustiveSearchEngine();
		luceneSearch = new LuceneRegexSearchEngine(Version.LUCENE_46, new RAMDirectory());
		inmemorySearch = new InMemorySearchEngine();
		targrep = new TarSearchEngine();

		dataset.createIndex(exhaustiveSearch);
		dataset.createIndex(luceneSearch);
		dataset.createIndex(inmemorySearch);
		dataset.createIndex(targrep);
	}

	@Test
	public void testQueries() throws SearchFailedException, IOException {

		indexDocuments();

		Iterator<String> queries = dataset.queries();

		while (queries.hasNext()) {
			String regex = queries.next();
			searchDocuments(regex);
		}
	}

	@Before
	public void before() {
		DetailsCollector.instance.flush(System.out);
	}

	private void searchDocuments(String regex) throws SearchFailedException, IOException {
		System.out.println("********************************************************");
		System.out.printf("Query: /%s/\n", regex);

		Collection<SimpleDocument> expected;

		try (RegexSearchEngine.Reader reader = exhaustiveSearch.getReader()) {
			expected = reader.search(regex);
		}

		System.out.printf("expected   [%03d]:   %s\n", expected.size(), expected);

		try (RegexSearchEngine.Reader reader = luceneSearch.getReader()) {
			Collection<SimpleDocument> result = reader.search(regex);
			System.out.printf("lucene     [%03d]:   %s\n", result.size(), result);
			assertThat(result, equalTo(expected));
			DetailsCollector.instance.flush(System.out);
		}

		try (RegexSearchEngine.Reader reader = inmemorySearch.getReader()) {
			Collection<SimpleDocument> result = reader.search(regex);
			System.out.printf("inmemory     [%03d]:   %s\n", result.size(), result);
			assertThat(result, equalTo(expected));
			DetailsCollector.instance.flush(System.out);
		}

		try (RegexSearchEngine.Reader reader = targrep.getReader()) {
			Collection<SimpleDocument> result = reader.search(regex);
			System.out.printf("targrep     [%03d]:   %s\n", result.size(), result);
			assertThat(result, equalTo(expected));
			DetailsCollector.instance.flush(System.out);
		}
	}

}
