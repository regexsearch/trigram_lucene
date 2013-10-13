package de.abrandl.regex.query.transformations;

import de.abrandl.regex.query.NGramExtractor;
import de.abrandl.regex.query.RegexInfo;
import de.abrandl.regex.query.RegexInfoTransformation;
import de.abrandl.regex.query.StringSet;
import de.abrandl.regex.query.bool.Expression;
import static com.google.common.base.Preconditions.checkNotNull;

abstract class InformationSavingTransformation implements RegexInfoTransformation {

	private final NGramExtractor extractor;

	public InformationSavingTransformation(NGramExtractor extractor) {
		this.extractor = extractor;
	}

	@Override
	public final RegexInfo transform(RegexInfo input) {
		checkNotNull(input);

		RegexInfo result = input;
		StringSet stringSet = getStringSet(input);

		if (stringSet.isKnown()) {
			Expression ngrams = extractor.ngrams(stringSet);
			Expression newMatch = result.getMatch().and(ngrams);

			result = newRegexInfo(result, newMatch);
		}

		return result;
	}

	protected abstract StringSet getStringSet(RegexInfo input);

	private RegexInfo newRegexInfo(RegexInfo result, Expression newMatch) {
		boolean emptyable = result.isEmptyable();
		StringSet exact = result.getExact();
		StringSet prefix = result.getPrefix();
		StringSet suffix = result.getSuffix();
		return new RegexInfo(emptyable, exact, prefix, suffix, newMatch);
	}

}