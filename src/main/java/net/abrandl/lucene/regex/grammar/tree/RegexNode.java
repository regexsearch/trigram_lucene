package net.abrandl.lucene.regex.grammar.tree;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.LinkedList;
import java.util.List;

public abstract class RegexNode {

	private RegexNode parent;
	private List<RegexNode> children;

	public RegexNode() {
		children = new LinkedList<RegexNode>();
	}

	public void addChild(RegexNode node) {
		checkNotNull(node);

		children.add(node);
		node.setParent(this);
	}

	public void addChildren(RegexNode[] nodes) {
		checkNotNull(nodes);
		for (RegexNode node : nodes) {
			addChild(node);
		}
	}

	public void setParent(RegexNode parent) {
		this.parent = parent;
	}

	public RegexNode getParent() {
		return parent;
	}

	public List<RegexNode> getChildren() {
		return children;
	}

	public RegexNode getFirstChild() {
		if (children.isEmpty()) {
			return null;
		} else {
			return children.get(0);
		}
	}

	public boolean isRoot() {
		return parent == null;
	}

	public abstract <A> A accept(RegexNodeVisitor<A> visitor);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
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
		RegexNode other = (RegexNode) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}

}
