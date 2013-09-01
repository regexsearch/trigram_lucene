package net.abrandl.lucene.regex.query.bool;

import static net.abrandl.lucene.regex.query.bool.Expression.and;
import static net.abrandl.lucene.regex.query.bool.Expression.or;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NestedExpressionSimplifierTest {

	@Test
	public void simplifiesNestedAnds() {

		Expression e = And.create(and("foo", "bar"), new Literal("bar"), and("bar", "blub"));
		Expression simplified = e.accept(new NestedExpressionSimplifier());

		assertThat(simplified.toString(), equalTo("AND(blub,foo,bar)"));
	}

	@Test
	public void simplifiesNestedOrs() {

		Expression e = Or.create(or("foo", "bar"), new Literal("bar"), or("bar", "blub"));
		Expression simplified = e.accept(new NestedExpressionSimplifier());

		assertThat(simplified.toString(), equalTo("OR(blub,foo,bar)"));
	}

	@Test
	public void simplifiesButStaysCorrect() {

		Expression e = Or.create(or("foo", "bar"), and("bar", "foo", "yeah"), or("bar", "blub"));
		Expression simplified = e.accept(new NestedExpressionSimplifier());

		assertThat(simplified.toString(), equalTo("OR(AND(yeah,foo,bar),blub,foo,bar)"));
	}

}
