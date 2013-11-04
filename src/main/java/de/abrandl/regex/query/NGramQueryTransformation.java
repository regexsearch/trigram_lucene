package de.abrandl.regex.query;

import de.abrandl.regex.grammar.tree.RegexNode;
import de.abrandl.regex.query.bool.Expression;
import static de.abrandl.regex.query.RegexInfoTransformationFactory.identical;
import static de.abrandl.regex.query.RegexInfoTransformationFactory.informationDiscardingTransformations;
import static de.abrandl.regex.query.RegexInfoTransformationFactory.informationSavingTransformations;
import static de.abrandl.regex.query.bool.Expression.any;

public class NGramQueryTransformation implements QueryTransformation {

	private final static int MAX_PASSES = 100;

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
		final RegexInfo info = regex.accept(analyzer);

		RegexInfoTransformation infoSaving = informationSavingTransformations(gramSize);
		RegexInfoTransformation infoDiscarding = informationDiscardingTransformations();

		RegexInfo result = infoSaving.transform(info);
		int pass = 0;
		/*
		 * this is a no-op, as tooBig is not implemented yet. Need to decide: -
		 * is an Expression 'too big'? - when to discard information, i.e. paper
		 * says it does this during analysis
		 */
		while (tooBig(result) && pass < MAX_PASSES) {
			result = result.cloneWithNewMatch(any()); // reset match query
			result = infoDiscarding.transform(result);
			result = infoSaving.transform(result);
			pass++;
		}

		return result.getMatch();
	}

	private boolean tooBig(RegexInfo result) {
		return false; // TODO: decide when an Expression is too big to handle
	}

	private RegexAnalyzer createAnalyzer() {
		// move the transformation part after having analyzed the regex.
		return new RegexAnalyzer(identical());
	}

}
