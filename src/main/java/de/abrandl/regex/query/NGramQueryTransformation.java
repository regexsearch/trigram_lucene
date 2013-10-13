package de.abrandl.regex.query;

import java.util.Arrays;

import de.abrandl.regex.NGramTokenizer;
import de.abrandl.regex.grammar.tree.RegexNode;
import de.abrandl.regex.query.bool.Expression;
import de.abrandl.regex.query.transformations.*;


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
		NGramTokenizer tokenizer = new NGramTokenizer(gramSize);
		NGramExtractor extractor = new NGramExtractor(tokenizer);
		RegexInfoTransformation prefixToMatch = new PrefixToMatchTransformation(extractor);
		RegexInfoTransformation suffixToMatch = new SuffixToMatchTransformation(extractor);
		RegexInfoTransformation exactToMatch = new ExactToMatchTransformation(extractor);
		RegexInfoTransformation simplifier = new QuerySimplifierTransformation();
		RegexInfoTransformation transformations = new CompositeRegexInfoTransformation(Arrays.asList(exactToMatch,
				prefixToMatch, suffixToMatch, simplifier));
		RegexAnalyzer analyzer = new RegexAnalyzer(transformations);
		return analyzer;
	}

}
