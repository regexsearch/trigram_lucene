package de.abrandl.regex.query.bool;

import java.util.*;

abstract public class InnerExpressionNode extends Expression implements Iterable<Expression> {

	final protected Set<Expression> children;

	InnerExpressionNode(Set<Expression> children) {
		super();
		this.children = Collections.unmodifiableSet(children);
	}

	InnerExpressionNode(Expression... children) {
		super();
		Set<Expression> sube = new HashSet<Expression>(children.length);
		for (Expression e : children) {
			sube.add(e);
		}
		this.children = Collections.unmodifiableSet(sube);
	}

	@Override
	public Iterator<Expression> iterator() {
		return children.iterator();
	}

	public Collection<Expression> getChildren() {
		return children;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InnerExpressionNode other = (InnerExpressionNode) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		return true;
	}

}
