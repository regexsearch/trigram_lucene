package net.abrandl.lucene.regex.query.bool;

import java.util.Iterator;

public class ToStringVisitor implements ExpressionVisitor<StringBuilder> {

	private final StringBuilder builder;

	public ToStringVisitor() {
		builder = new StringBuilder();
	}

	@Override
	public StringBuilder visit(And query) {
		builder.append("AND(");
		nestChildren(query);
		builder.append(")");
		return builder;
	}

	@Override
	public StringBuilder visit(Or query) {
		builder.append("OR(");
		nestChildren(query);
		builder.append(")");
		return builder;
	}

	@Override
	public StringBuilder visit(Literal query) {
		builder.append(query.getContent());
		return builder;
	}

	private void nestChildren(InnerExpressionNode query) {
		Iterator<Expression> children = query.iterator();
		while (children.hasNext()) {
			Expression child = children.next();
			child.accept(this);
			if (children.hasNext()) {
				builder.append(",");
			}
		}
	}

}
