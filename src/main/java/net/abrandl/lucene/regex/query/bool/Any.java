package net.abrandl.lucene.regex.query.bool;

public final class Any extends Expression {

	// TODO: check java singleton pattern
	private final static Any SINGLETON = new Any();

	public final static Any instance() {
		return SINGLETON;
	}

	private Any() {
		super();
	}

	@Override
	public <ReturnType> ReturnType accept(ExpressionVisitor<ReturnType> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Any)) {
			return false;
		} else {
			Any any = (Any) o;
			return any == SINGLETON;
		}
	}

	@Override
	public int hashCode() {
		return 0; // there is only one instance! TODO: check if ok :)
	}

}
