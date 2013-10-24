package de.abrandl.regex.query.bool;

import static de.abrandl.regex.query.bool.Expression.and;
import static de.abrandl.regex.query.bool.Expression.literal;
import static de.abrandl.regex.query.bool.Expression.or;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OrTest {

	@Test
	public void ANYeatsOtherClauses() {
		Expression or = Or.create(new Literal("foo"), new Literal("bar"));
		Expression result = or.or(Expression.any());

		assertThat(result, equalTo(Expression.any()));
	}

	@Test
	public void testRequiresRelationForOr() {
		Expression or = or("foo", "bar");
		Literal literal = literal("foo");

		assertThat(or.requires(literal), is(false));
	}

	@Test
	public void testRequiresRelationForOr2() {
		Expression and = and("bar", "foo");
		Expression or = Or.create(literal("foo"), and);
		Literal literal = literal("foo");

		assertThat(or.requires(literal), is(true));
	}

	@Test
	public void returnsSingleExpressionWhenOnlyOneGiven() {
		Expression actual = Or.create(literal("foo"));
		Expression expected = literal("foo");
		assertThat(actual, equalTo(expected));
	}

}
