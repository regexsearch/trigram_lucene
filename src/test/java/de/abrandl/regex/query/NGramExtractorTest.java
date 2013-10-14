package de.abrandl.regex.query;

import java.util.Collections;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import de.abrandl.regex.NGramTokenizer;
import de.abrandl.regex.query.bool.Expression;
import de.abrandl.regex.query.bool.Or;
import de.abrandl.test.Helpers;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class NGramExtractorTest {

	private NGramExtractor extractor;

	@Mock
	private NGramTokenizer tokenizer;

	@Before
	public void setup() {
		extractor = new NGramExtractor(tokenizer);
	}

	@Test
	public void extractsTrigramsForString() {
		String input = "foo bar";
		String[] trigrams = new String[] { "foo", "oo ", "o b", " ba", "bar" };

		when(tokenizer.tokenize(input)).thenReturn(Helpers.asSet(trigrams));

		assertExpression(input, Expression.and(trigrams));
	}

	@Test
	public void emptyStringEqualsANY() {
		when(tokenizer.tokenize("")).thenReturn(Collections.<String> emptySet());
		assertExpression("", Expression.any());
	}

	@Test
	public void tooShortStringEqualsANY() {
		when(tokenizer.tokenize("a")).thenReturn(Collections.<String> emptySet());
		assertExpression("a", Expression.any());
	}

	@Test
	public void tooShortStringEqualsANY2() {
		when(tokenizer.tokenize("ab")).thenReturn(Collections.<String> emptySet());
		assertExpression("ab", Expression.any());
	}

	@Test
	public void supportsStringSets() {
		String[] set1 = new String[] { "first" };
		String[] set2 = new String[] { "second" };

		when(tokenizer.tokenize("foo boo")).thenReturn(Helpers.asSet(set1));
		when(tokenizer.tokenize("fooooob")).thenReturn(Helpers.asSet(set2));

		StringSet set = new StringSet("foo boo", "fooooob");
		Expression result = extractor.ngrams(set);

		Expression expected = Or.create(Expression.and(set1), Expression.and(set2));
		assertThat(result, equalTo(expected));
	}

	@Test
	public void withShortStringsTheExpressionShouldBeANY() {
		String[] set2 = new String[] { "foo", "ooo", "oob" };

		when(tokenizer.tokenize("fo")).thenReturn(Collections.<String> emptySet());
		when(tokenizer.tokenize("fooooob")).thenReturn(Helpers.asSet(set2));

		StringSet set = new StringSet("fo", "fooooob");
		Expression result = extractor.ngrams(set);
		Expression expected = Or.create(Expression.any(), Expression.and(set2));
		assertThat(result, equalTo(expected));
	}

	private void assertExpression(String string, Expression expected) {
		Expression result = extractor.ngrams(string);
		assertThat(result, equalTo(expected));
	}

}
