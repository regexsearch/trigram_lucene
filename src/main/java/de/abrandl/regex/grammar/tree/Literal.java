package de.abrandl.regex.grammar.tree;

public class Literal extends RegexNode {

	private String chars;
	
	public Literal(String chars) {
		this.chars = chars;
	}
	
	public String getChars() {
		return chars;
	}

	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

}
