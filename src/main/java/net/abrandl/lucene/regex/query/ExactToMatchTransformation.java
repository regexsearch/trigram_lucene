package net.abrandl.lucene.regex.query;

import net.abrandl.lucene.regex.query.bool.Expression;
import static com.google.common.base.Preconditions.checkNotNull;

// TODO: generalize when possible
class ExactToMatchTransformation implements RegexInfoTransformation {

	private final NGramExtractor extractor;

	public ExactToMatchTransformation(NGramExtractor extractor) {
		this.extractor = extractor;
	}

	@Override
	public RegexInfo transform(RegexInfo input) {
		checkNotNull(input);

		RegexInfo result = input;

		if (result.getExact().isKnown()) {
			Expression ngrams = extractor.ngrams(result.getExact());
			Expression newMatch = result.getMatch().and(ngrams);

			result = newRegexInfo(result, newMatch);
		}

		return result;
	}

	private RegexInfo newRegexInfo(RegexInfo result, Expression newMatch) {
		boolean emptyable = result.isEmptyable();
		StringSet exact = result.getExact();
		StringSet prefix = result.getPrefix();
		StringSet suffix = result.getSuffix();
		return new RegexInfo(emptyable, exact, prefix, suffix, newMatch);
	}

}
