package net.abrandl.lucene.regex.grammar.tree;

public class Optional extends RegexNode {

	public Optional(RegexNode child) {
		addChild(child);
	}
	
	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

}
