package de.abrandl.regex.query.transformations;

import de.abrandl.regex.query.RegexInfo;
import de.abrandl.regex.query.RegexInfoTransformation;
import de.abrandl.regex.query.bool.Expression;
import de.abrandl.regex.query.bool.ExpressionFlattener;
import de.abrandl.regex.query.bool.ExpressionSimplifier;

public class QuerySimplifierTransformation implements RegexInfoTransformation {

	@Override
	public RegexInfo transform(RegexInfo result) {
		Expression match = result.getMatch();
		match = match.accept(new ExpressionSimplifier());
		match = match.accept(new ExpressionFlattener());
		return replaceMatch(result, match);
	}

	private RegexInfo replaceMatch(RegexInfo result, Expression match) {
		return new RegexInfo(result.isEmptyable(), result.getExact(), result.getPrefix(), result.getSuffix(), match);
	}

}
