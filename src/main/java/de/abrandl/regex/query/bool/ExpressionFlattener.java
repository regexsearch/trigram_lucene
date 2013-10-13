package de.abrandl.regex.query.bool;

import java.util.HashSet;
import java.util.Set;

public class ExpressionFlattener implements ExpressionVisitor<Expression> {

	@Override
	public Expression visit(And query) {
		return And.create(flatten(query, And.class));
	}

	@Override
	public Expression visit(Or query) {
		return Or.create(flatten(query, Or.class));
	}

	private Set<Expression> flatten(InnerExpressionNode query, Class<? extends InnerExpressionNode> nodeType) {
		Set<Expression> children = new HashSet<Expression>();
		for (Expression e : query.getChildren()) {
			if (nodeType.isInstance(e)) {
				InnerExpressionNode node = nodeType.cast(e);
				for (Expression sube : node.getChildren()) {
					children.add(sube.accept(this));
				}
			} else {
				children.add(e.accept(this));
			}
		}
		return children;
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
