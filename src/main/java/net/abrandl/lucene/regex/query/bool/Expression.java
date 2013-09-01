package net.abrandl.lucene.regex.query.bool;

import java.util.HashSet;
import java.util.Set;

public abstract class Expression {

	public abstract <ReturnType> ReturnType accept(ExpressionVisitor<ReturnType> visitor);

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
			literals.add(new Literal(s));
		}
		return Or.create(literals);
	}

	final public static Expression any() {
		return Any.instance();
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
