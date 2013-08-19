package net.abrandl.lucene.regex.query;

import net.abrandl.lucene.regex.NGramTokenizer;
import net.abrandl.lucene.regex.query.bool.Expression;
import net.abrandl.lucene.regex.query.bool.Or;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class NGramExtractorTest {

	private NGramExtractor extractor;

	@Before
	public void setup() {
		// TODO: stub the tokenizer?
		extractor = new NGramExtractor(new NGramTokenizer());
	}

	@Test
	public void extractsTrigramsForString() {
		assertExpression("foo bar", Expression.and("foo", "oo ", "o b", " ba", "bar"));
	}

	@Test
	public void emptyStringEqualsANY() {
		assertExpression("", Expression.any());
	}

	@Test
	public void tooShortStringEqualsANY() {
		assertExpression("a", Expression.any());
	}

	@Test
	public void tooShortStringEqualsANY2() {
		assertExpression("ab", Expression.any());
	}

	@Test
	public void supportsStringSets() {
		StringSet set = new StringSet("foo boo", "fooooob");
		Expression result = extractor.ngrams(set);
		Expression expected = new Or(Expression.and("foo", "oo ", "o b", " bo", "boo"), Expression.and("foo", "ooo",
				"oob"));
		assertThat(result, equalTo(expected));
	}

	@Test
	public void withShortStringsTheExpressionShouldBeANY() {
		StringSet set = new StringSet("fo", "fooooob");
		Expression result = extractor.ngrams(set);
		Expression expected = new Or(Expression.any(), Expression.and("foo", "ooo", "oob"));
		assertThat(result, equalTo(expected));
	}

	private void assertExpression(String string, Expression expected) {
		Expression result = extractor.ngrams(string);
		assertThat(result, equalTo(expected));
	}

}
