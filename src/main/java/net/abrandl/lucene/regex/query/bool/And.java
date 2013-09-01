package net.abrandl.lucene.regex.query.bool;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class And extends InnerExpressionNode {

	public static Expression create(Collection<Expression> children) {

		// filter Any nodes, not useful in And context
		Collection<Expression> filtered = new HashSet<Expression>(children.size());
		for (Expression e : children) {
			if (!(e instanceof Any)) {
				filtered.add(e);
			}
		}

		if (filtered.isEmpty()) {
			return Expression.any();
		} else if (filtered.size() == 1) {
			return filtered.iterator().next();
		} else {
			return new And(filtered);
		}
	}

	public static Expression create(Expression... children) {
		return create(Arrays.asList(children));
	}

	private And(Collection<Expression> children) {
		super(children);
	}

	@Override
	public <ReturnType> ReturnType accept(ExpressionVisitor<ReturnType> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Expression and(Expression... other) {
		Collection<Expression> newChildren = new HashSet<Expression>(children.size() + other.length);
		newChildren.addAll(children);
		newChildren.addAll(Arrays.asList(other));

		return create(newChildren);
	}

}
