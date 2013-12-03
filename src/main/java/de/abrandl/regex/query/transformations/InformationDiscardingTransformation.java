package de.abrandl.regex.query.transformations;

import de.abrandl.regex.query.RegexInfo;
import de.abrandl.regex.query.RegexInfoTransformation;
import de.abrandl.regex.query.bool.Expression;
import static com.google.common.base.Preconditions.checkArgument;

/**
 * TODO: info discarding transformations: Implement subclasses that discard
 * information from a {@see RegexInfo} instance.
 * 
 * @author abrandl
 * @deprecated currently unused
 */
@Deprecated
public abstract class InformationDiscardingTransformation implements RegexInfoTransformation {

	private final int maxClauses;

	public InformationDiscardingTransformation(int maxClauses) {
		checkArgument(maxClauses > 0);
		this.maxClauses = maxClauses;
	}

	public InformationDiscardingTransformation() {
		this(512);
	}

	public int getMaxClauses() {
		return maxClauses;
	}

	@Override
	public RegexInfo transform(RegexInfo input) {

		RegexInfo result = input;

		if (input != null && isNecessary(input.getMatch())) {
			result = discardInformation(input);
		}

		return result;
	}

	abstract RegexInfo discardInformation(RegexInfo result);

	private boolean isNecessary(Expression match) {
		return match.size() > getMaxClauses();
	}

}
