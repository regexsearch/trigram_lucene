package net.abrandl.lucene.regex.query.bool;

import java.util.Arrays;
import java.util.List;

public class Or extends InnerExpressionNode {

	public Or(List<Expression> children) {
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
		children.addAll(Arrays.asList(other));
		return this;
	}

}