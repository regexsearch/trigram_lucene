package de.abrandl.regex.grammar.tree;

public class OneOrMore extends RegexNode {

	public OneOrMore(RegexNode node) {
		addChild(node);
	}
	
	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

}
