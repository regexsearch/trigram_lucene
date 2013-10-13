package de.abrandl.regex.grammar.tree;

public class Concatenation extends RegexNode {

	public Concatenation(RegexNode... children) {
		addChildren(children);
	}
	
	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

}
