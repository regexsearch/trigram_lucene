package net.abrandl.lucene.regex.query.bool;

public final class Any extends Expression {

	private final static Any SINGLETON = new Any();

	public final static Any instance() {
		return SINGLETON;
	}

	private Any() {
		super();
		if (SINGLETON != null && SINGLETON != this) {
			throw new IllegalAccessError("only one instance permitted (singleton)");
		}
	}

	@Override
	public <ReturnType> ReturnType accept(ExpressionVisitor<ReturnType> visitor) {
		return visitor.visit(this);
	}

}
