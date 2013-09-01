package net.abrandl.lucene.regex.query.transformations;

import net.abrandl.lucene.regex.query.RegexInfo;
import net.abrandl.lucene.regex.query.RegexInfoTransformation;

public class NullQueryTransformation implements RegexInfoTransformation {

	@Override
	public RegexInfo transform(RegexInfo result) {
		return result;
	}

}
