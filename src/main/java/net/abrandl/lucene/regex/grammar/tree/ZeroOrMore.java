package net.abrandl.lucene.regex.grammar.tree;

public class ZeroOrMore extends RegexNode {

	public ZeroOrMore(RegexNode node) {
		addChild(node);
	}
	
	public RegexNode getChild() {
		return getChildren().get(0);
	}

	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

}
