package net.abrandl.lucene.regex.grammar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import net.abrandl.lucene.regex.grammar.tree.DotAny;
import net.abrandl.lucene.regex.grammar.tree.RegexNode;
import net.abrandl.lucene.regex.grammar.tree.RegexNodeVisitorToString;
import static org.hamcrest.Matchers.*;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class RegexTreeTransfomerTest {
	
	private boolean debug = true;

	@Test
	public void literals() throws RecognitionException {
		assertIdenticalTransform("foo");
		assertIdenticalTransform("a");
	}

	@Test
	public void emptyString() throws RecognitionException {
		assertIdenticalTransform("", true);
	}

	@Test
	public void alternative() throws RecognitionException {
		assertIdenticalTransform("foo|bar|bla");
		assertIdenticalTransform("(foo|bar)bla");
	}

	@Test
	public void oneOrMore() throws RecognitionException {
		assertIdenticalTransform("a+");
		assertIdenticalTransform("(foo)+");
	}

	@Test
	public void testZeroOrMore() throws RecognitionException {
		assertIdenticalTransform("a*");
		assertIdenticalTransform("(foo)*");
	}
	
	@Test
	public void testOptional() throws RecognitionException {
		assertIdenticalTransform("a?");
		assertIdenticalTransform("(foo)?");
	}	

	@Test
	public void testNestedGroups() throws RecognitionException {
		assertIdenticalTransform("(foo|bar)+bla");
		assertIdenticalTransform("(foo|bar)+bla*");
		assertIdenticalTransform("((foo|bar)+(bla)*)+");
	}

	@Test
	public void dotAny() throws RecognitionException {
		String regex = ".";
		RegexTreeTransformer parser = RegexTreeTransformer.parse(regex);
		RegexNode tree = parser.getRegexTree();
		debug(regex, parser, tree);
		assertEquals(DotAny.class, tree.getChildren().get(0).getClass());
	}

	private void assertIdenticalTransform(String regex)
			throws RecognitionException {
		assertIdenticalTransform(regex, true);
	}

	private void assertIdenticalTransform(String regex, boolean debug)
			throws RecognitionException {
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
