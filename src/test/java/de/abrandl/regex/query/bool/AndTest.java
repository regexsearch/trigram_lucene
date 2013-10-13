package de.abrandl.regex.query.bool;

import java.util.Collections;

import de.abrandl.regex.query.bool.And;
import de.abrandl.regex.query.bool.Expression;
import de.abrandl.regex.query.bool.Literal;

import static org.hamcrest.CoreMatchers.equalTo;

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

}
