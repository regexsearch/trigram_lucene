package net.abrandl.lucene.regex.query;

class SuffixToMatchTransformation extends InformationSavingTransformation {

	public SuffixToMatchTransformation(NGramExtractor extractor) {
		super(extractor);
	}

	@Override
	protected StringSet getStringSet(RegexInfo input) {
		return input.getSuffix();
	}

}
