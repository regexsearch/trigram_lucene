package de.abrandl.regex.query.bool;

import static de.abrandl.regex.query.bool.Expression.literal;
import static de.abrandl.regex.query.bool.Expression.or;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ExpressionTest {

	@Test
	public void basicTest() {
		Expression e = And.create(new Literal("foo"), new Literal("bar")).or(new Literal("blafuu"));
		assertStringEquals(e, "OR(AND(foo,bar),blafuu)");
	}

	@Test
	public void simplifiesUnnecessaryHierarchiesWhenUsingOr() {
		Expression e = And.create(new Literal("foo"), new Literal("bar")).or(new Literal("blafuu"));
		e = e.or(new Literal("should-be-on-the-same-level"));
		assertStringEquals(e, "OR(AND(foo,bar),should-be-on-the-same-level,blafuu)");
	}

	@Test
	public void simplifiesUnnecessaryHierarchiesWhenUsingAnd() {
		Expression e = And.create(new Literal("foo"), new Literal("bar")).and(new Literal("blafuu"));
		assertStringEquals(e, "AND(foo,bar,blafuu)");
	}

	@Test
	public void recognizesAny() {
		Expression e = And.create(Expression.any(), new Literal("bar")).and(new Literal("blafuu"));
		assertStringEquals(e, "AND(bar,blafuu)");
	}

	@Test
	public void andIgnoresAny() {
		Expression literal = new Literal("foo");
		Expression e = literal.and(Expression.any());
		assertThat(e, equalTo(literal));
	}

	@Test
	public void sizeCountsTheNumberOfNodes() {
		Expression e = And
				.create(And.create(literal("foo"), or("bla", "buh", "abc"), literal("wuh"), or("tes", "est")));

		assertThat(e.size(), equalTo(7));
	}

	@Test
	public void sizeCountsASingleLiteralAsOne() {
		assertThat(literal("foo").size(), equalTo(1));
	}

	private void assertStringEquals(Expression e, String expectedString) {
		String result = e.toString();
		assertThat(result, equalTo(expectedString));
	}

}
