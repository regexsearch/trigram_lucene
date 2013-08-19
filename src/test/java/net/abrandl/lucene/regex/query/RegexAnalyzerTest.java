package net.abrandl.lucene.regex.query;

import net.abrandl.lucene.regex.grammar.RegexParser;
import net.abrandl.lucene.regex.grammar.RegexParsingException;
import net.abrandl.lucene.regex.grammar.tree.RegexNode;
import net.abrandl.lucene.regex.grammar.tree.RegexNodeVisitorToString;
import static net.abrandl.lucene.regex.query.bool.Expression.any;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RegexAnalyzerTest {

	private final StringSet empty = StringSet.emptyStringOnly();

	@Test
	public void literalsOnly() throws RegexParsingException {
		StringSet set = new StringSet("foobar");
		RegexInfo expected = new RegexInfo(false, set, set, set, any());

		assertResult("foobar", expected);
	}

	@Test
	public void emptyString() throws RegexParsingException {
		RegexInfo expected = new RegexInfo(true, empty, empty, empty, any());

		assertResult("", expected);
	}

	@Test
	public void optional() throws RegexParsingException {
		StringSet exact = new StringSet("abc", "");
		RegexInfo expected = new RegexInfo(true, exact, empty, empty, any());

		assertResult("(abc)?", expected);
	}

	@Test
	public void zeroOrMore() throws RegexParsingException {
		RegexInfo expected = new RegexInfo(true, StringSet.unknownSet(), empty, empty, any());

		assertResult("(abc)*", expected);
	}

	@Test
	public void oneOrMore() throws RegexParsingException {
		StringSet set = new StringSet("abc");
		RegexInfo expected = new RegexInfo(false, StringSet.unknownSet(), set, set, any());

		assertResult("(abc)+", expected);
	}

	@Test
	public void oneOrMoreWithEmptyable() throws RegexParsingException {
		RegexInfo expected = new RegexInfo(true, StringSet.unknownSet(), empty, empty, any());

		assertResult("(a?)+", expected);
	}

	@Test
	public void alternation() throws RegexParsingException {
		StringSet set = new StringSet("abc", "foo", "bar");
		RegexInfo expected = new RegexInfo(false, set, set, set, any());

		assertResult("abc|foo|bar", expected);
	}

	@Test
	public void alternation2() throws RegexParsingException {
		StringSet set = new StringSet("abc", "foo", "bar");
		RegexInfo expected = new RegexInfo(false, set, set, set, any());

		assertResult("(abc|foo)|bar", expected);
	}

	@Test
	public void alternationWithEmptyable() throws RegexParsingException {
		StringSet exact = new StringSet("bcd");
		StringSet suffixAndPrefix = new StringSet("", "bcd");
		RegexInfo expected = new RegexInfo(true, exact, suffixAndPrefix, suffixAndPrefix, any());

		assertResult("(abc)*|bcd", expected);
	}

	@Test
	public void concatenation() throws RegexParsingException {
		RegexInfo expected = new RegexInfo(false, StringSet.unknownSet(), new StringSet("abc"), new StringSet("abc",
				"abccde"), any());

		assertResult("(abc)+(cde)?", expected);
	}

	@Test
	public void concatenation2() throws RegexParsingException {
		RegexInfo expected = new RegexInfo(false, StringSet.unknownSet(), new StringSet("abc"),
				new StringSet("abccde"), any());

		assertResult("(abc)+cde", expected);
	}

	private void assertResult(String regex, RegexInfo expected) throws RegexParsingException {
		RegexNode tree = RegexParser.parse(regex);
		RegexAnalyzer extractor = new RegexAnalyzer();
		System.out.println(tree.accept(new RegexNodeVisitorToString()));
		RegexInfo result = tree.accept(extractor);
		System.out.println(result);
		assertThat(result, equalTo(expected));

	}

}
