package de.abrandl.regex.query;

import de.abrandl.regex.query.bool.Expression;

/**
 * immutable class
 * 
 * @author abrandl
 * 
 */
final public class RegexInfo {

	private final boolean emptyable;
	private final StringSet exact;
	private final StringSet prefix;
	private final StringSet suffix;
	private final Expression match;

	public RegexInfo(boolean emptyable, StringSet exact, StringSet prefix, StringSet suffix, Expression match) {
		super();
		this.emptyable = emptyable;
		this.exact = exact;
		this.prefix = prefix;
		this.suffix = suffix;
		this.match = match;
	}

	public boolean isEmptyable() {
		return emptyable;
	}

	public StringSet getExact() {
		return exact;
	}

	public StringSet getPrefix() {
		return prefix;
	}

	public StringSet getSuffix() {
		return suffix;
	}

	public Expression getMatch() {
		return match;
	}

	/**
	 * Makes handling immutability easier.
	 * 
	 * Basically creates a new RegexInfo, copies over fields but replaces with
	 * <code>match</code> with the given expression.
	 * 
	 * @param match
	 * @return
	 */
	public RegexInfo cloneWithNewMatch(Expression match) {
		return new RegexInfo(isEmptyable(), getExact(), getPrefix(), getSuffix(), match);
	}

	@Override
	public String toString() {
		return "RegexInfo [emptyable=" + emptyable + ", exact=" + exact + ", prefix=" + prefix + ", suffix=" + suffix
				+ ", match=" + match + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (emptyable ? 1231 : 1237);
		result = prime * result + ((exact == null) ? 0 : exact.hashCode());
		result = prime * result + ((match == null) ? 0 : match.hashCode());
		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
		result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegexInfo other = (RegexInfo) obj;
		if (emptyable != other.emptyable)
			return false;
		if (exact == null) {
			if (other.exact != null)
				return false;
		} else if (!exact.equals(other.exact))
			return false;
		if (match == null) {
			if (other.match != null)
				return false;
		} else if (!match.equals(other.match))
			return false;
		if (prefix == null) {
			if (other.prefix != null)
				return false;
		} else if (!prefix.equals(other.prefix))
			return false;
		if (suffix == null) {
			if (other.suffix != null)
				return false;
		} else if (!suffix.equals(other.suffix))
			return false;
		return true;
	}

}
