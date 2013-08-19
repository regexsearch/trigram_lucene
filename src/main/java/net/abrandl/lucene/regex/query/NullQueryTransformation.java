package net.abrandl.lucene.regex.query;

public class NullQueryTransformation implements QueryTransformation {

	@Override
	public RegexInfo transform(RegexInfo result) {
		return result;
	}

}
