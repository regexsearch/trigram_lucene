package de.abrandl.regex.query.bool;

import java.util.HashSet;
import java.util.Set;

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

	/**
	 * ANY and (other) -> (other)
	 */
	@Override
	public Expression and(Expression... other) {
		Set<Expression> all = new HashSet<Expression>(other.length + 1, 1.0f);
		for (Expression e : other) {
			all.add(e);
		}
		return And.create(all);
	}

	/**
	 * ANY or (other) -> ANY
	 */
	@Override
	public Expression or(Expression... other) {
		return this;
	}

	@Override
	public boolean requires(Literal literal) {
		return false;
	}

}
