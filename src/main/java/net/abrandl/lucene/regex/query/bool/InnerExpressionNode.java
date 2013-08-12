package net.abrandl.lucene.regex.query.bool;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

abstract class InnerExpressionNode extends Expression implements Iterable<Expression> {

	final Collection<Expression> children;

	InnerExpressionNode(Collection<Expression> children) {
		super();
		this.children = children;
	}

	InnerExpressionNode(Expression... children) {
		this(new HashSet<Expression>(children.length));
		for (Expression e : children) {
			this.children.add(e);
		}
	}

	@Override
	public Iterator<Expression> iterator() {
		return children.iterator();
	}

}
