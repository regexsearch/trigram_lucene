package net.abrandl.lucene.regex.grammar.tree;

public class MatchGroup extends RegexNode {

	public MatchGroup(RegexNode... children) {
		for (RegexNode node : children) {
			if (node != null) {
				addChild(node);
			}
		}
	}

	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

}
