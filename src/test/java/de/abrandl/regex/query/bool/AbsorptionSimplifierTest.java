package de.abrandl.regex.query.bool;

import static de.abrandl.regex.query.bool.Expression.and;
import static de.abrandl.regex.query.bool.Expression.or;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AbsorptionSimplifierTest {

	private Expression apply(Expression e) {
		return e.accept(new AbsorptionSimplifier());
	}

	@Test
	public void rule1() {
		Expression input = And.create(or("foo", "bar"), or("foo", "bar", "bla"));
		Expression expected = or("foo", "bar");
		Expression result = apply(input);

		assertThat(result, equalTo(expected));
	}

	@Test
	public void rule2() {
		Expression input = Or.create(and("foo", "bar"), and("foo", "bar", "bla"));
		Expression expected = and("foo", "bar");
		Expression result = apply(input);

		assertThat(result, equalTo(expected));
	}

}
