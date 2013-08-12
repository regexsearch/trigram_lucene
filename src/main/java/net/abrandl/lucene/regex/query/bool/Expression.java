package net.abrandl.lucene.regex.query.bool;

import java.util.LinkedList;
import java.util.List;

public abstract class Expression {

	public abstract <ReturnType> ReturnType accept(ExpressionVisitor<ReturnType> visitor);

	final public static Expression and(String... strings) {
		List<Expression> literals = new LinkedList<Expression>();
		for (String s : strings) {
			literals.add(new Literal(s));
		}
		return new And(literals);
	}

	final public static Expression or(String... strings) {
		List<Expression> literals = new LinkedList<Expression>();
		for (String s : strings) {
			literals.add(new Literal(s));
		}
		return new Or(literals);
	}

	public Expression and(Expression... other) {
		List<Expression> all = new LinkedList<Expression>();
		all.add(this);
		for (Expression e : other) {
			all.add(e);
		}
		return new And(all);
	}

	public Expression or(Expression... other) {
		List<Expression> all = new LinkedList<Expression>();
		all.add(this);
		for (Expression e : other) {
			all.add(e);
		}
		return new Or(all);
	}

	@Override
	public String toString() {
		return accept(new ToStringVisitor()).toString();
	}

}
