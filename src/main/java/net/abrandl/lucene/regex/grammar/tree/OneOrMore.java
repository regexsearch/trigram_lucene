package net.abrandl.lucene.regex.grammar.tree;

public class OneOrMore extends RegexNode {

	public OneOrMore(RegexNode node) {
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
