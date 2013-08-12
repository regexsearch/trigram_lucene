package net.abrandl.lucene.regex.query.bool;

public interface ExpressionVisitor<ReturnType> {

	ReturnType visit(And query);

	ReturnType visit(Or query);

	ReturnType visit(Literal query);

}
