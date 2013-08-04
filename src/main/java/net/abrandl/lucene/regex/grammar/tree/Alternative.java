package net.abrandl.lucene.regex.grammar.tree;

public class Alternative extends RegexNode {

	public Alternative(RegexNode... alternatives) {
		super();
		addChildren(alternatives);
	}
	
	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}
	
}
