package net.abrandl.lucene.regex.query.bool;

import java.util.List;

public class And extends InnerExpressionNode {

	public And(List<Expression> children) {
		super(children);
	}

	@SafeVarargs
	public And(Expression... children) {
		super(children);
	}

	@Override
	public <ReturnType> ReturnType accept(ExpressionVisitor<ReturnType> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Expression and(Expression... other) {
		for (Expression e : other) {
			children.add(e);
		}
		return this;
	}

}
