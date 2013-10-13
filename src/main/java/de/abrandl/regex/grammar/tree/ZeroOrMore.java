package de.abrandl.regex.grammar.tree;

public class ZeroOrMore extends RegexNode {

	public ZeroOrMore(RegexNode node) {
		addChild(node);
	}
	
	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

}
