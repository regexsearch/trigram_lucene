package net.abrandl.lucene.regex.grammar;

import java.util.Collection;

import net.abrandl.lucene.regex.grammar.tree.*;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RegexTreeTransfomerTest {

	private final boolean debug = true;

	@Test
	public void literals() throws RegexParsingException {
		assertIdenticalTransform("foo");
		assertIdenticalTransform("a");
	}

	@Test
	public void emptyString() throws RegexParsingException {
		assertIdenticalTransform("");
	}

	@Test
	public void emptyString2() throws RegexParsingException {
		RegexNode tree = parse("");
		assertThat(tree, instanceOf(Empty.class));
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
		RegexNode tree = parse(regex);
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

	@Test
	public void ignoreSubjectBoundaries() throws RegexParsingException {
		assertTransform("^foo", "foo");
		assertTransform("foo$", "foo");
		assertTransform("^foo$", "foo");
		assertTransform("^(bla?|foo+)*$", "(bla?|foo+)*");
	}

	@Test
	public void allowEscapedSpecialChars() throws RegexParsingException {
		assertTransform("\\^foobla", "^foobla");
		assertTransform("foo\\.bla", "foo.bla");
	}

	@Test
	public void escapedCharactersShouldHaveNoSpecialMeaning() throws RegexParsingException {
		regexTreeShouldNotInclude(DotAny.class, "foo\\.bla");
	}

	@Test
	public void escapedStarShouldHaveNoSpecialMeaning() throws RegexParsingException {
		regexTreeShouldNotInclude(ZeroOrMore.class, "foo\\*bla");
	}

	@Test
	public void escapedPlusShouldHaveNoSpecialMeaning() throws RegexParsingException {
		regexTreeShouldNotInclude(OneOrMore.class, "(foobla)\\+");
	}

	@Test
	public void escapedParensShouldHaveNoSpecialMeaning() throws RegexParsingException {
		regexTreeShouldNotInclude(MatchGroup.class, "\\(foobla\\)");
	}

	@Test
	public void escapedBackslashesShouldBeALiteral() throws RegexParsingException {
		String regex = "foo\\\\*bla";
		RegexNode tree = parse(regex);
		assertThat(tree, new IncludesRegexNodeType(ZeroOrMore.class));
	}

	@Test
	public void shouldIgnoreSubjectStartBoundary() throws RegexParsingException {
		assertTransform("^subject", "subject");
	}

	@Test
	public void shouldTreatWhitespacesAsLiterals() throws RegexParsingException {
		assertIdenticalTransform("foo bar");
	}

	@Test
	public void shouldTreatTabsAsLiterals() throws RegexParsingException {
		assertIdenticalTransform("foo\tbar");
	}

	@Test
	public void shouldTreatNewlinesAsLiterals() throws RegexParsingException {
		assertIdenticalTransform("foo\nbar");
	}

	@Test
	public void shouldTreatCarriageReturnAsLiterals() throws RegexParsingException {
		assertIdenticalTransform("foo\rbar");
	}

	private void regexTreeShouldNotInclude(Class<? extends RegexNode> type, String regex) throws RegexParsingException {
		RegexNode tree = parse(regex);
		assertThat(tree, not(new IncludesRegexNodeType(type)));
	}

	private RegexNode parse(String regex) throws RegexParsingException {
		RegexTreeTransformer parser = RegexTreeTransformer.parse(regex);
		RegexNode tree = parser.getRegexTree();

		debug(regex, parser, tree);
		return tree;
	}

	private static class IncludesRegexNodeType extends BaseMatcher<RegexNode> {

		private final Class<? extends RegexNode> nodeType;

		public IncludesRegexNodeType(Class<? extends RegexNode> nodeType) {
			super();
			this.nodeType = nodeType;
		}

		@Override
		public boolean matches(Object arg0) {
			RegexNode tree = (RegexNode) arg0;
			Collection<Class<? extends RegexNode>> types = tree.accept(new RegexNodeVisitorTypeCollector());
			return types.contains(nodeType);
		}

		@Override
		public void describeTo(Description arg0) {
			arg0.appendText("tree should include a node of type").appendValue(nodeType);
		}

	}

	private void assertTransform(String regex, String expectedTransformation) throws RegexParsingException {
		RegexNode tree = parse(regex);
		String transformed = tree.accept(new RegexNodeVisitorToString());
		assertEquals(expectedTransformation, transformed);
	}

	private void assertIdenticalTransform(String regex) throws RegexParsingException {
		assertTransform(regex, regex);
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
