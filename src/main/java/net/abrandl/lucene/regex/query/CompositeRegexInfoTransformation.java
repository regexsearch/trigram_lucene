package net.abrandl.lucene.regex.query;

import java.util.List;

public class CompositeRegexInfoTransformation implements RegexInfoTransformation {

	private final List<RegexInfoTransformation> transformations;

	public CompositeRegexInfoTransformation(List<RegexInfoTransformation> transformations) {
		super();
		this.transformations = transformations;
	}

	@Override
	public RegexInfo transform(RegexInfo result) {
		for (RegexInfoTransformation transformation : transformations) {
			result = transformation.transform(result);
		}
		return result;
	}

}
