package integration;

import java.util.Arrays;
import java.util.Collection;

import net.abrandl.lucene.regex.*;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BasicSearchEngineTest {

	private final RegexSearchEngine exhaustiveSearch = new ExhaustiveSearchEngine();
	private final RegexSearchEngine ngramSearch = new NGramRegexSearchEngine(3);

	@Before
	public void indexDocuments() {
		for (String content : Arrays.asList("blublablub bla foo test", "bla3455345test")) {
			Document document = new Document(content, content);
			exhaustiveSearch.addDocument(document);
			ngramSearch.addDocument(document);
		}
	}

	@Test
	public void searchDocuments() throws SearchFailedException {
		String regex = "(bla)+";
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
