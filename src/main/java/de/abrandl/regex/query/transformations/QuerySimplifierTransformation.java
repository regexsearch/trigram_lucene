package de.abrandl.regex.query.transformations;

import java.util.Arrays;
import java.util.List;

import de.abrandl.regex.query.RegexInfo;
import de.abrandl.regex.query.RegexInfoTransformation;
import de.abrandl.regex.query.bool.*;

public class QuerySimplifierTransformation implements RegexInfoTransformation {

	private final static int MAX_PASSES = 10;

	private final List<ExpressionVisitor<Expression>> rules;

	public QuerySimplifierTransformation() {
		rules = Arrays.asList(new ExpressionSimplifier(), new ExpressionFlattener(), new AbsorptionSimplifier());
	}

	@Override
	public RegexInfo transform(RegexInfo result) {
		Expression simplified = simplify(result.getMatch());
		return replaceMatch(result, simplified);
	}

	private Expression simplify(Expression input) {

		Expression current = input;
		Expression before = null;

		int pass = 0;

		while (!(current.equals(before)) && pass < MAX_PASSES) {
			before = current;
			for (ExpressionVisitor<Expression> rule : rules) {
				current = current.accept(rule);
			}
			pass++;
		}

		return current;
	}

	private RegexInfo replaceMatch(RegexInfo result, Expression match) {
		return new RegexInfo(result.isEmptyable(), result.getExact(), result.getPrefix(), result.getSuffix(), match);
	}

}
