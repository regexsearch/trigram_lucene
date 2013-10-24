package de.abrandl.regex.query.bool;

import java.util.Collections;

import static de.abrandl.regex.query.bool.Expression.and;
import static de.abrandl.regex.query.bool.Expression.literal;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AndTest {

	@Test
	public void andIgnoresANY() {
		Expression and = And.create(new Literal("foo"), new Literal("bar"));
		Expression result = and.and(Expression.any());

		assertThat(result, equalTo(and));
	}

	@Test
	public void createsANYwhenEmpty() {
		Expression result = And.create(Collections.<Expression> emptySet());
		assertThat(result, equalTo(Expression.any()));
	}

	@Test
	public void createsFirstExpressionWhenOnlyOneGiven() {
		Expression literal = new Literal("foo");
		Expression result = And.create(literal);
		assertThat(result, equalTo(literal));
	}

	@Test
	public void usesAllExpressionsExceptANY() {
		Expression result = And.create(new Literal("foo"), Expression.any(), new Literal("bar"));
		assertThat(result, equalTo(Expression.and("foo", "bar")));

	}

	@Test
	public void testRequiresRelationForAnd() {
		Expression and = and("foo", "bar");
		Literal literal = literal("foo");

		assertThat(and.requires(literal), is(true));
	}

	@Test
	public void testRequiresRelationForAnd2() {
		Expression and = and("foo", "bar");
		Literal literal = literal("bla");

		assertThat(and.requires(literal), is(false));
	}

}
