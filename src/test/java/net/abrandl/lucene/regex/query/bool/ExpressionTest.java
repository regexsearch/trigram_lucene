package net.abrandl.lucene.regex.query.bool;

import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ExpressionTest {

	@Test
	public void basicTest() {
		Expression e = new And(new Literal("foo"), new Literal("bar")).or(new Literal("blafuu"));
		assertStringEquals(e, "OR(AND(foo,bar),blafuu)");
	}

	@Test
	public void simplifiesUnnecessaryHierarchiesWhenUsingOr() {
		Expression e = new And(new Literal("foo"), new Literal("bar")).or(new Literal("blafuu"));
		e = e.or(new Literal("should-be-on-the-same-level"));
		assertStringEquals(e, "OR(AND(foo,bar),should-be-on-the-same-level,blafuu)");
	}

	@Test
	public void simplifiesUnnecessaryHierarchiesWhenUsingAnd() {
		Expression e = new And(new Literal("foo"), new Literal("bar")).and(new Literal("blafuu"));
		assertStringEquals(e, "AND(foo,bar,blafuu)");
	}

	@Test
	public void recognizesAny() {
		Expression e = new And(Expression.any(), new Literal("bar")).and(new Literal("blafuu"));
		assertStringEquals(e, "AND(ANY,bar,blafuu)");
	}

	private void assertStringEquals(Expression e, String expectedString) {
		String result = e.toString();
		assertThat(result, equalTo(expectedString));
	}

}
