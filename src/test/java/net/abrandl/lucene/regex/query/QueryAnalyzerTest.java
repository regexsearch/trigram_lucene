package net.abrandl.lucene.regex.query;

import net.abrandl.lucene.regex.grammar.RegexParser;
import net.abrandl.lucene.regex.grammar.RegexParsingException;
import net.abrandl.lucene.regex.grammar.tree.RegexNode;
import net.abrandl.lucene.regex.grammar.tree.RegexNodeVisitorToString;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QueryAnalyzerTest {

	private final StringSet empty = StringSet.emptyStringOnly();

	@Test
	public void literalsOnly() throws RegexParsingException {
		StringSet set = new StringSet("foobar");
		ExtractionResult expected = new ExtractionResult(false, set, set, set);

		assertResult("foobar", expected);
	}

	@Test
	public void emptyString() throws RegexParsingException {
		ExtractionResult expected = new ExtractionResult(true, empty, empty, empty);

		assertResult("", expected);
	}

	@Test
	public void optional() throws RegexParsingException {
		StringSet exact = new StringSet("abc", "");
		ExtractionResult expected = new ExtractionResult(true, exact, empty, empty);

		assertResult("(abc)?", expected);
	}

	@Test
	public void zeroOrMore() throws RegexParsingException {
		ExtractionResult expected = new ExtractionResult(true, StringSet.unknownSet(), empty, empty);

		assertResult("(abc)*", expected);
	}

	@Test
	public void oneOrMore() throws RegexParsingException {
		StringSet set = new StringSet("abc");
		ExtractionResult expected = new ExtractionResult(false, StringSet.unknownSet(), set, set);

		assertResult("(abc)+", expected);
	}

	@Test
	public void oneOrMoreWithEmptyable() throws RegexParsingException {
		ExtractionResult expected = new ExtractionResult(true, StringSet.unknownSet(), empty, empty);

		assertResult("(a?)+", expected);
	}

	@Test
	public void alternation() throws RegexParsingException {
		StringSet set = new StringSet("abc", "foo", "bar");
		ExtractionResult expected = new ExtractionResult(false, set, set, set);

		assertResult("abc|foo|bar", expected);
	}

	@Test
	public void alternation2() throws RegexParsingException {
		StringSet set = new StringSet("abc", "foo", "bar");
		ExtractionResult expected = new ExtractionResult(false, set, set, set);

		assertResult("(abc|foo)|bar", expected);
	}

	@Test
	public void alternationWithEmptyable() throws RegexParsingException {
		StringSet exact = new StringSet("bcd");
		StringSet suffixAndPrefix = new StringSet("", "bcd");
		ExtractionResult expected = new ExtractionResult(true, exact, suffixAndPrefix, suffixAndPrefix);

		assertResult("(abc)*|bcd", expected);
	}

	@Test
	public void concatenation() throws RegexParsingException {
		ExtractionResult expected = new ExtractionResult(false, StringSet.unknownSet(), new StringSet("abc"),
				new StringSet("abc", "abccde"));

		assertResult("(abc)+(cde)?", expected);
	}

	@Test
	public void concatenation2() throws RegexParsingException {
		ExtractionResult expected = new ExtractionResult(false, StringSet.unknownSet(), new StringSet("abc"),
				new StringSet("abccde"));

		assertResult("(abc)+cde", expected);
	}

	private void assertResult(String regex, ExtractionResult expected) throws RegexParsingException {
		RegexNode tree = RegexParser.parse(regex);
		QueryAnalyzer extractor = new QueryAnalyzer();
		System.out.println(tree.accept(new RegexNodeVisitorToString()));
		ExtractionResult result = tree.accept(extractor);
		System.out.println(result);
		assertThat(result, equalTo(expected));

	}

}
