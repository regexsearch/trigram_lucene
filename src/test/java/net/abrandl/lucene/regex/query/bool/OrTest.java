package net.abrandl.lucene.regex.query.bool;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OrTest {

	@Test
	public void ANYeatsOtherClauses() {
		Expression or = Or.create(new Literal("foo"), new Literal("bar"));
		Expression result = or.or(Expression.any());

		assertThat(result, equalTo(Expression.any()));
	}

}
