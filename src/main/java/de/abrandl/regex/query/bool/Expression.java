package de.abrandl.regex.query.bool;

import java.util.HashSet;
import java.util.Set;

public abstract class Expression {

	public abstract <ReturnType> ReturnType accept(ExpressionVisitor<ReturnType> visitor);

	/**
	 * Checks if this expression requires a given <code>literal</code> to be
	 * present.
	 * 
	 * @param literal
	 * @return true iff this expression requires the presence of the given
	 *         <code>literal</code>
	 */
	public abstract boolean requires(Literal literal);

	final public static Expression and(String... strings) {
		Set<Expression> literals = new HashSet<Expression>(strings.length, 1.0f);
		for (String s : strings) {
			literals.add(new Literal(s));
		}
		return And.create(literals);
	}

	final public static Expression or(String... strings) {
		Set<Expression> literals = new HashSet<Expression>(strings.length, 1.0f);
		for (String s : strings) {
			literals.add(literal(s));
		}
		return Or.create(literals);
	}

	final public static Expression any() {
		return Any.instance();
	}

	final public static Literal literal(String string) {
		return new Literal(string);
	}

	public Expression and(Expression... other) {
		Set<Expression> all = new HashSet<Expression>(other.length + 1, 1.0f);
		all.add(this);
		for (Expression e : other) {
			all.add(e);
		}
		return And.create(all);
	}

	public Expression or(Expression... other) {
		Set<Expression> all = new HashSet<Expression>(other.length + 1, 1.0f);
		all.add(this);
		for (Expression e : other) {
			all.add(e);
		}
		return Or.create(all);
	}

	@Override
	public String toString() {
		return accept(new ToStringVisitor()).toString();
	}

}
