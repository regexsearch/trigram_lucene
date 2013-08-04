package net.abrandl.lucene.regex.grammar.tree;

public class MatchGroup extends RegexNode {

	public MatchGroup(RegexNode... children) {
		addChildren(children);
	}

	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

}
