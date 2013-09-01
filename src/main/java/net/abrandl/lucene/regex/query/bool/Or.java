package net.abrandl.lucene.regex.query.bool;

import java.util.Arrays;
import java.util.Collection;

public class Or extends InnerExpressionNode {

	public static Expression create(Collection<Expression> children) {
		return new Or(children);
	}

	public static Expression create(Expression... children) {
		return create(Arrays.asList(children));
	}

	private Or(Collection<Expression> children) {
		super(children);
	}

	public Or(Expression... children) {
		super(children);
	}

	@Override
	public <ReturnType> ReturnType accept(ExpressionVisitor<ReturnType> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Expression or(Expression... other) {
		for (Expression e : other) {
			children.add(e);
		}
		return this;
	}

}