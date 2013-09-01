package net.abrandl.lucene.regex.query;

class PrefixToMatchTransformation extends InformationSavingTransformation {

	public PrefixToMatchTransformation(NGramExtractor extractor) {
		super(extractor);
	}

	@Override
	protected StringSet getStringSet(RegexInfo input) {
		return input.getPrefix();
	}

}
