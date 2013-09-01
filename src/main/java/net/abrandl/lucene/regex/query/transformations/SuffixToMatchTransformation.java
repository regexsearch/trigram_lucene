package net.abrandl.lucene.regex.query.transformations;

import net.abrandl.lucene.regex.query.NGramExtractor;
import net.abrandl.lucene.regex.query.RegexInfo;
import net.abrandl.lucene.regex.query.StringSet;

public class SuffixToMatchTransformation extends InformationSavingTransformation {

	public SuffixToMatchTransformation(NGramExtractor extractor) {
		super(extractor);
	}

	@Override
	protected StringSet getStringSet(RegexInfo input) {
		return input.getSuffix();
	}

}
