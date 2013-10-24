package de.abrandl.regex.query.bool;

import static de.abrandl.regex.query.bool.Expression.and;
import static de.abrandl.regex.query.bool.Expression.literal;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ExpressionRedundancyRemoverTest {

	private ExpressionRedundancyRemover visitor;

	@Before
	public void setUp() throws Exception {
		visitor = new ExpressionRedundancyRemover();
	}

	@Test
	public void removesRedundantOrExpression() {
		Expression e = Or.create(and("foo", "bar"), literal("foo"));
		Expression expected = literal("foo");

		assertThat(e.accept(visitor), equalTo(expected));
	}

	@Test
	public void correctlyTreatsNonRedundantExpressions() {
		Expression e = Or.create(and("foo", "bar"), literal("bla"));
		Expression expected = e;

		assertThat(e.accept(visitor), equalTo(expected));
	}

}
