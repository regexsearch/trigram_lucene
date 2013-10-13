package de.abrandl.regex.query.transformations;

import de.abrandl.regex.query.RegexInfo;
import de.abrandl.regex.query.RegexInfoTransformation;

public class NullQueryTransformation implements RegexInfoTransformation {

	@Override
	public RegexInfo transform(RegexInfo result) {
		return result;
	}

}
