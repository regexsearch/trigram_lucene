package net.abrandl.lucene.regex.grammar.tree;

public class Alternative extends RegexNode {

	public Alternative(RegexNode... alternatives) {
		super();
		for (RegexNode alternative : alternatives) {
			if (alternative != null) {
				addChild(alternative);
			}
		}
	}
	
	public Alternative() {
		super();
	}

	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}
	
}
