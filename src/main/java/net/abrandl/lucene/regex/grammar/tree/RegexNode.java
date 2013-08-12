package net.abrandl.lucene.regex.grammar.tree;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class RegexNode {

	private RegexNode parent;
	private final List<RegexNode> children;

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

	public void collectMembers(Collection<RegexNode> nodes) {
		nodes.add(this);
		for (RegexNode child : children) {
			if (!nodes.contains(child)) {
				child.collectMembers(nodes);
			}
		}
	}

	public abstract <A> A accept(RegexNodeVisitor<A> visitor);

}
