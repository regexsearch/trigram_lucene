package net.abrandl.lucene.regex.query.transformations;

import net.abrandl.lucene.regex.query.RegexInfo;
import net.abrandl.lucene.regex.query.RegexInfoTransformation;
import net.abrandl.lucene.regex.query.bool.Expression;
import net.abrandl.lucene.regex.query.bool.ExpressionFlattener;
import net.abrandl.lucene.regex.query.bool.ExpressionSimplifier;

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
