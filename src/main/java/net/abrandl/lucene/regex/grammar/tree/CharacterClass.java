package net.abrandl.lucene.regex.grammar.tree;


public class CharacterClass extends RegexNode {
	
	public CharacterClass(CharacterRange... ranges) {
		addChildren(ranges);
	}
	
	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}
	
}
