package de.abrandl.regex.query.bool;

import static de.abrandl.regex.query.bool.Expression.and;
import static de.abrandl.regex.query.bool.Expression.or;
import static org.hamcrest.CoreMatchers.equalTo;
import de.abrandl.regex.query.bool.*;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ExpressionFlattenerTest {

	@Test
	public void simplifiesNestedAnds() {

		Expression e = And.create(and("foo", "bar"), new Literal("bar"), and("bar", "blub"));
		Expression simplified = e.accept(new ExpressionFlattener());

		assertThat(simplified.toString(), equalTo("AND(blub,foo,bar)"));
	}

	@Test
	public void simplifiesNestedOrs() {

		Expression e = Or.create(or("foo", "bar"), new Literal("bar"), or("bar", "blub"));
		Expression simplified = e.accept(new ExpressionFlattener());

		assertThat(simplified.toString(), equalTo("OR(blub,foo,bar)"));
	}

	@Test
	public void simplifiesButStaysCorrect() {

		Expression e = Or.create(or("foo", "bar"), and("bar", "foo", "yeah"), or("bar", "blub"));
		Expression simplified = e.accept(new ExpressionFlattener());

		assertThat(simplified.toString(), equalTo("OR(AND(yeah,foo,bar),blub,foo,bar)"));
	}

}
