package net.abrandl.lucene.regex.grammar.tree;

public class CharacterRange extends RegexNode {

	private final char start, end;

	public CharacterRange(char start, char end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	public char getStart() {
		return start;
	}

	public char getEnd() {
		return end;
	}

	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return String.format("[%s-%s]", start, end);
	}

}
