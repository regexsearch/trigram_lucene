package net.abrandl.lucene.regex.query;

class ExactToMatchTransformation extends InformationSavingTransformation {

	public ExactToMatchTransformation(NGramExtractor extractor) {
		super(extractor);
	}

	@Override
	protected StringSet getStringSet(RegexInfo input) {
		return input.getExact();
	}

}
