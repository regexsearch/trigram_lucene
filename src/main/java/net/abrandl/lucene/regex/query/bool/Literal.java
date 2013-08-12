package net.abrandl.lucene.regex.query.bool;

public class Literal extends Expression {

	private final String content;

	public Literal(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	@Override
	public <ReturnType> ReturnType accept(ExpressionVisitor<ReturnType> visitor) {
		return visitor.visit(this);
	}

}
