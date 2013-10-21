package de.abrandl.regex.query;

import java.util.Arrays;

import de.abrandl.regex.NGramTokenizer;
import de.abrandl.regex.query.transformations.*;

class RegexInfoTransformationFactory {

	public static RegexInfoTransformation allTransformations(int gramSize) {
		NGramTokenizer tokenizer = new NGramTokenizer(gramSize);
		return allTransformationsWithTokenizer(tokenizer);
	}

	public static RegexInfoTransformation allTransformations() {
		NGramTokenizer tokenizer = new NGramTokenizer();
		return allTransformationsWithTokenizer(tokenizer);
	}

	private static RegexInfoTransformation allTransformationsWithTokenizer(NGramTokenizer tokenizer) {
		NGramExtractor extractor = new NGramExtractor(tokenizer);
		RegexInfoTransformation prefixToMatch = new PrefixToMatchTransformation(extractor);
		RegexInfoTransformation suffixToMatch = new SuffixToMatchTransformation(extractor);
		RegexInfoTransformation exactToMatch = new ExactToMatchTransformation(extractor);
		RegexInfoTransformation simplifier = new QuerySimplifierTransformation();
		return new CompositeRegexInfoTransformation(Arrays.asList(exactToMatch, prefixToMatch, suffixToMatch,
				simplifier));
	}

}
