package de.abrandl.regex.query.transformations;

import de.abrandl.regex.query.NGramExtractor;
import de.abrandl.regex.query.RegexInfo;
import de.abrandl.regex.query.StringSet;

public class ExactToMatchTransformation extends InformationSavingTransformation {

	public ExactToMatchTransformation(NGramExtractor extractor) {
		super(extractor);
	}

	@Override
	protected StringSet getStringSet(RegexInfo input) {
		return input.getExact();
	}

}
