package net.abrandl.lucene.regex.grammar.tree;

public class Concatenation extends RegexNode {

	public Concatenation(RegexNode... children) {
		for (RegexNode node : children) {
			addChild(node);
		}
	}
	
	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

}
