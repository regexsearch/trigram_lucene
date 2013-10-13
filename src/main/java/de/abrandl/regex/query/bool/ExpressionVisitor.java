package de.abrandl.regex.query.bool;

public interface ExpressionVisitor<ReturnType> {

	ReturnType visit(And query);

	ReturnType visit(Or query);

	ReturnType visit(Literal query);

	ReturnType visit(Any any);

}
