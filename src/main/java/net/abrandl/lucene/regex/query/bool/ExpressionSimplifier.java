package net.abrandl.lucene.regex.query.bool;

import java.util.Collection;

public class ExpressionSimplifier implements ExpressionVisitor<Expression> {

	@Override
	public Expression visit(And query) {
		Collection<Expression> children = query.getChildren();

		if (children.size() == 1) {
			return children.iterator().next();
		}

		return query;
	}

	@Override
	public Expression visit(Or query) {
		Collection<Expression> children = query.getChildren();

		if (children.size() == 1) {
			return children.iterator().next();
		}

		return query;
	}

	@Override
	public Expression visit(Literal query) {
		return query;
	}

	@Override
	public Expression visit(Any any) {
		return any;
	}

}
