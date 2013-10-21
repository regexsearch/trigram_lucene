package de.abrandl.regex.query;

import de.abrandl.regex.grammar.tree.RegexNode;
import de.abrandl.regex.query.bool.Expression;

public class NGramQueryTransformation implements QueryTransformation {

	private final int gramSize;

	public NGramQueryTransformation(int gramSize) {
		this.gramSize = gramSize;
	}

	public NGramQueryTransformation() {
		this(3);
	}

	@Override
	public Expression expressionFor(RegexNode regex) {
		RegexAnalyzer analyzer = createAnalyzer();

		// analyze regex
		RegexInfo result = regex.accept(analyzer);

		// and extract ngram match query
		return result.getMatch();
	}

	private RegexAnalyzer createAnalyzer() {
		RegexAnalyzer analyzer = new RegexAnalyzer(RegexInfoTransformationFactory.allTransformations(gramSize));
		return analyzer;
	}

}
