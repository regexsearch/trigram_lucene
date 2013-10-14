package de.abrandl.regex.query;

import de.abrandl.regex.grammar.RegexParser;
import de.abrandl.regex.grammar.RegexParsingException;
import de.abrandl.regex.grammar.tree.RegexNode;
import de.abrandl.regex.grammar.tree.RegexNodeVisitorToStringTree;
import de.abrandl.regex.query.bool.Expression;
import static de.abrandl.regex.query.StringSet.unknownSet;
import static de.abrandl.regex.query.bool.Expression.any;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Ignore;
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

	@Test
	@Ignore("pending")
	public void dotShouldNotResultInANY() throws RegexParsingException {
		RegexNode tree = RegexParser.parse("foo.bar");
		RegexAnalyzer extractor = new RegexAnalyzer();
		RegexInfo result = tree.accept(extractor);

		assertThat(result.getMatch(), not(equalTo(Expression.any())));
	}

	@Test
	public void characterClass() throws RegexParsingException {
		StringSet stringSet = new StringSet("abc2de", "abc3de", "abcade", "abcbde");
		RegexInfo expected = new RegexInfo(false, stringSet, stringSet, stringSet, any());

		assertResult("abc[a-b2-3]de", expected);
	}

	@Test
	public void suffixUnionWhenExactUnknown() throws RegexParsingException {
		RegexInfo expected = new RegexInfo(false, unknownSet(), new StringSet("foo"), new StringSet("foo", ""), any());

		assertResult("foo(ba)*", expected);
	}

	@Test
	public void experiment() throws RegexParsingException {
		// String regex = "f(optional)?o";
		String regex = "foo(bla)*";
		System.out.println(regex);

		RegexNode tree = RegexParser.parse(regex);
		System.out.println(tree.accept(new RegexNodeVisitorToStringTree()));

		RegexAnalyzer extractor = new RegexAnalyzer();
		RegexInfo result = tree.accept(extractor);

		System.out.println(result);
	}

	private void assertResult(String regex, RegexInfo expected) throws RegexParsingException {
		System.out.println(regex);
		RegexNode tree = RegexParser.parse(regex);
		System.out.println(tree.accept(new RegexNodeVisitorToStringTree()));

		RegexAnalyzer extractor = new RegexAnalyzer();
		RegexInfo result = tree.accept(extractor);

		System.out.println(result);

		assertThat(result, equalTo(expected));

	}

}
