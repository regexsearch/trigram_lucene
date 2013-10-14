package de.abrandl.regex.query.bool;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AnyTest {

	@Test
	public void orIgnoresOtherExpressions() {
		Expression any = Any.instance();
		Expression result = any.or(new Literal("foo"), new Literal("bar"));

		assertThat(result, equalTo(any));
	}

	@Test
	public void andRemovesTheAny() {
		Expression any = Any.instance();
		Expression literal = new Literal("foo");
		Expression result = any.and(literal);

		Expression expected = And.create(literal);
		assertThat(result, equalTo(expected));
	}
}
