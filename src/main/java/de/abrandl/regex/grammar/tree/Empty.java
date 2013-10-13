package de.abrandl.regex.grammar.tree;

public class Empty extends RegexNode {

	public Empty() {
		super();
	}

	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

}
