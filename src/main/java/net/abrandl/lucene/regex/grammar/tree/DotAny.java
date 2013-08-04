package net.abrandl.lucene.regex.grammar.tree;

public class DotAny extends RegexNode {

	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

}
