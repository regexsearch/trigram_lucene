package net.abrandl.lucene.regex.query;

import java.util.Collections;
import java.util.Set;

import static net.abrandl.test.Helpers.asSet;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NGramTokenizerTest {

	@Test
	public void usesTrigramPerDefault() {
		Set<String> expected = asSet("foo", "oo ", "o b", " ba", "bar");
		assertTrigramResult("foo bar", expected);
	}

	@Test
	public void emptyStringEqualsEmptySet() {
		assertTrigramResult("", Collections.<String> emptySet());
	}

	@Test
	public void shortWordsEqualsEmptySet() {
		assertTrigramResult("a", Collections.<String> emptySet());
	}

	@Test
	public void shortWordsEqualsEmptySet2() {
		assertTrigramResult("ab", Collections.<String> emptySet());
	}

	@Test
	public void singleTrigram() {
		assertTrigramResult("abc", asSet("abc"));
	}

	@Test
	public void tokenizesBigrams() {
		assertResult("abcd", asSet("ab", "bc", "cd"), 2);
	}

	@Test
	public void tokenizesSinglegrams() {
		assertResult("abcd", asSet("a", "b", "c", "d"), 1);
	}

	@Test
	public void tokenizesg4grams() {
		assertResult("abcde", asSet("abcd", "bcde"), 4);
	}

	@Test
	public void ignoresDuplicates() {
		assertTrigramResult("aaaaaaaaaaaaaabbbbbbbbb", asSet("aaa", "aab", "abb", "bbb"));
	}

	private void assertTrigramResult(String input, Set<String> expectation) {
		assertResult(input, expectation, 3);
	}

	private void assertResult(String input, Set<String> expectation, int gramSize) {
		NGramTokenizer tokenizer = new NGramTokenizer(gramSize);
		Set<String> result = tokenizer.tokenize(input);
		assertThat(result, equalTo(expectation));
	}

}
