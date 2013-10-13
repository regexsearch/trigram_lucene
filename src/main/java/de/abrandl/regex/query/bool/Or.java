package de.abrandl.regex.query.bool;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Or extends InnerExpressionNode {

	public static Expression create(Collection<Expression> children) {

		// Any eats other clauses here
		for (Expression e : children) {
			if (e instanceof Any) {
				return Expression.any();
			}
		}

		return new Or(children);
	}

	public static Expression create(Expression... children) {
		Collection<Expression> unique = new HashSet<Expression>(children.length, 1.0f);
		for (Expression e : children) {
			unique.add(e);
		}
		return create(unique);
	}

	private Or(Collection<Expression> children) {
		super(children);
	}

	private Or(Expression... children) {
		super(children);
	}

	@Override
	public <ReturnType> ReturnType accept(ExpressionVisitor<ReturnType> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Expression or(Expression... other) {
		Set<Expression> clauses = new HashSet<Expression>(children.size() + other.length, 1.0f);
		clauses.addAll(children);
		for (Expression e : other) {
			clauses.add(e);
		}
		return create(clauses);
	}

}