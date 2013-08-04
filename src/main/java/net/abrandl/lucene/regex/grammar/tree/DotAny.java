package net.abrandl.lucene.regex.grammar.tree;

public class DotAny extends RegexNode {

	public DotAny() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

}
