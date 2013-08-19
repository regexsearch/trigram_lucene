package net.abrandl.lucene.regex.query;

class NullQueryTransformation implements RegexInfoTransformation {

	@Override
	public RegexInfo transform(RegexInfo result) {
		return result;
	}

}
