package net.abrandl.lucene.regex.query.bool;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

abstract class InnerExpressionNode extends Expression implements Iterable<Expression> {

	final List<Expression> children;

	InnerExpressionNode(List<Expression> children) {
		super();
		this.children = children;
	}

	InnerExpressionNode(Expression... children) {
		this(new LinkedList<Expression>());
		for (Expression e : children) {
			this.children.add(e);
		}
	}

	@Override
	public Iterator<Expression> iterator() {
		return children.iterator();
	}

}
