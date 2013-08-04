package net.abrandl.lucene.regex.grammar;

import static org.junit.Assert.assertEquals;
import net.abrandl.lucene.regex.grammar.tree.DotAny;
import net.abrandl.lucene.regex.grammar.tree.RegexNode;
import net.abrandl.lucene.regex.grammar.tree.RegexNodeVisitorToString;

import org.junit.Test;

public class RegexTreeTransfomerTest {

	private boolean debug = true;

	@Test
	public void literals() throws RegexParsingException {
		assertIdenticalTransform("foo");
		assertIdenticalTransform("a");
	}

	@Test
	public void emptyString() throws RegexParsingException {
		assertIdenticalTransform("", true);
	}

	@Test
	public void alternative() throws RegexParsingException {
		assertIdenticalTransform("foo|bar|bla");
		assertIdenticalTransform("(foo|bar)bla");
	}

	@Test
	public void oneOrMore() throws RegexParsingException {
		assertIdenticalTransform("a+");
		assertIdenticalTransform("(foo)+");
	}

	@Test
	public void testZeroOrMore() throws RegexParsingException {
		assertIdenticalTransform("a*");
		assertIdenticalTransform("(foo)*");
	}

	@Test
	public void testOptional() throws RegexParsingException {
		assertIdenticalTransform("a?");
		assertIdenticalTransform("(foo)?");
	}

	@Test
	public void testNestedGroups() throws RegexParsingException {
		assertIdenticalTransform("(foo|bar)+bla");
		assertIdenticalTransform("(foo|bar)+bla*");
		assertIdenticalTransform("((foo|bar)+(bla)*)+");
	}

	@Test
	public void dotAny() throws RegexParsingException {
		String regex = ".";
		RegexTreeTransformer parser = RegexTreeTransformer.parse(regex);
		RegexNode tree = parser.getRegexTree();
		debug(regex, parser, tree);
		assertEquals(DotAny.class, tree.getChildren().get(0).getClass());
	}

	@Test(expected = RegexParsingException.class)
	public void invalidInput() throws RegexParsingException {
		RegexTreeTransformer.parse(")I'm(invalid+input*");
	}

	@Test
	public void characterClass() throws RegexParsingException {
		assertIdenticalTransform("[a-z]");
		assertIdenticalTransform("[a-b0-9e-z]");
		assertIdenticalTransform("[a-z]");
	}

	private void assertIdenticalTransform(String regex)
			throws RegexParsingException {
		assertIdenticalTransform(regex, true);
	}

	private void assertIdenticalTransform(String regex, boolean debug)
			throws RegexParsingException {
		RegexTreeTransformer parser = RegexTreeTransformer.parse(regex);
		RegexNode tree = parser.getRegexTree();

		String transformed = tree.accept(new RegexNodeVisitorToString());

		debug(regex, parser, tree);

		assertEquals(regex, transformed);
	}

	private void debug(String regex, RegexTreeTransformer parser, RegexNode tree) {
		String transformed = tree.accept(new RegexNodeVisitorToString());
		if (debug) {
			System.out.println(regex);
			System.out
					.println("---------------------------------------------------------------------------------------------------");
			System.out.println(parser);
			System.out
					.println("---------------------------------------------------------------------------------------------------");
			System.out.println(transformed);
			System.out
					.println("***************************************************************************************************");
		}
	}

}
