package de.abrandl.regex.query.bool;

import java.util.HashSet;
import java.util.Set;

public abstract class Expression {

	public abstract <ReturnType> ReturnType accept(ExpressionVisitor<ReturnType> visitor);

	final public static Expression and(String... strings) {
		Set<Expression> literals = new HashSet<Expression>(strings.length, 1.0f);
		for (String s : strings) {
			literals.add(new Literal(s));
		}
		return And.create(literals);
	}

	final public static Expression or(String... strings) {
		Set<Expression> literals = new HashSet<Expression>(strings.length, 1.0f);
		for (String s : strings) {
			literals.add(literal(s));
		}
		return Or.create(literals);
	}

	final public static Expression any() {
		return Any.instance();
	}

	final public static Literal literal(String string) {
		return new Literal(string);
	}

	public Expression and(Expression... other) {
		Set<Expression> all = new HashSet<Expression>(other.length + 1, 1.0f);
		all.add(this);
		for (Expression e : other) {
			all.add(e);
		}
		return And.create(all);
	}

	public Expression or(Expression... other) {
		Set<Expression> all = new HashSet<Expression>(other.length + 1, 1.0f);
		all.add(this);
		for (Expression e : other) {
			all.add(e);
		}
		return Or.create(all);
	}

	@Override
	public String toString() {
		return accept(new ToStringVisitor()).toString();
	}

	/**
	 * Counts the number of leaves (i.e. literals) in this Expression's tree
	 * representation.
	 * 
	 * @return number of leave-nodes in this Expression
	 */
	public final int size() {
		return accept(new NodeCountVisitor());
	}

	private static class NodeCountVisitor implements ExpressionVisitor<Integer> {

		@Override
		public Integer visit(And query) {
			return count(query);
		}

		private Integer count(InnerExpressionNode query) {
			int count = 0;
			for (Expression e : query) {
				count += e.accept(this);
			}
			return count;
		}

		@Override
		public Integer visit(Or query) {
			return count(query);
		}

		@Override
		public Integer visit(Literal query) {
			return 1;
		}

		@Override
		public Integer visit(Any any) {
			return 1;
		}

	}

}
