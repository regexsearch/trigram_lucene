package de.abrandl.regex.query;

import java.util.Arrays;
import java.util.Collections;

import de.abrandl.regex.NGramTokenizer;
import de.abrandl.regex.query.transformations.*;

class RegexInfoTransformationFactory {

	public static RegexInfoTransformation informationSavingTransformations(int gramSize) {
		NGramTokenizer tokenizer = new NGramTokenizer(gramSize);
		return informationSavingTransformations(tokenizer);
	}

	public static RegexInfoTransformation informationSavingTransformations() {
		NGramTokenizer tokenizer = new NGramTokenizer();
		return informationSavingTransformations(tokenizer);
	}

	public static RegexInfoTransformation informationDiscardingTransformations() {
		return identical(); // TODO: info discarding transformations
	}

	public static RegexInfoTransformation booleanSimplifier() {
		return new QuerySimplifierTransformation();
	}

	public static RegexInfoTransformation identical() {
		return new CompositeRegexInfoTransformation(Collections.<RegexInfoTransformation> emptyList());
	}

	private static RegexInfoTransformation informationSavingTransformations(NGramTokenizer tokenizer) {
		NGramExtractor extractor = new NGramExtractor(tokenizer);
		RegexInfoTransformation prefixToMatch = new PrefixToMatchTransformation(extractor);
		RegexInfoTransformation suffixToMatch = new SuffixToMatchTransformation(extractor);
		RegexInfoTransformation exactToMatch = new ExactToMatchTransformation(extractor);
		RegexInfoTransformation simplifier = booleanSimplifier();
		return new CompositeRegexInfoTransformation(Arrays.asList(exactToMatch, prefixToMatch, suffixToMatch,
				simplifier));
	}

}
