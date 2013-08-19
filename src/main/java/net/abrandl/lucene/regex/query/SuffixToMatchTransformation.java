package net.abrandl.lucene.regex.query;

import net.abrandl.lucene.regex.query.bool.Expression;

public class SuffixToMatchTransformation implements QueryTransformation {

	private final NGramExtractor extractor;

	public SuffixToMatchTransformation(NGramExtractor extractor) {
		this.extractor = extractor;
	}

	@Override
	public RegexInfo transform(RegexInfo result) {

		Expression ngrams = extractor.ngrams(result.getSuffix());
		Expression newMatch = result.getMatch().and(ngrams);
		return newRegexInfo(result, newMatch);
	}

	private RegexInfo newRegexInfo(RegexInfo result, Expression newMatch) {
		boolean emptyable = result.isEmptyable();
		StringSet exact = result.getExact();
		StringSet prefix = result.getPrefix();
		StringSet suffix = result.getSuffix();
		return new RegexInfo(emptyable, exact, prefix, suffix, newMatch);
	}

}
