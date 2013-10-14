package de.abrandl.regex.grammar.tree;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RegexNodeVisitorToStringTest {

	@Test
	public void simpleTraversal() {

		RegexNode tree = new Concatenation(
				new Optional(new Alternative(new Concatenation(new Literal("fo"), new ZeroOrMore(new Literal("o"))), new Literal("bar"))),
				new Alternative(new Literal("bla"), new Literal("fu")));

		RegexNodeVisitor<String> visitor = new RegexNodeVisitorToString();

		String result = tree.accept(visitor);
		
		assertEquals("foo*|bar?bla|fu", result);

	}
}
