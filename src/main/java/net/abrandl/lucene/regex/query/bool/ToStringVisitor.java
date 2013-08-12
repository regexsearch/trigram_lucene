package net.abrandl.lucene.regex.query.bool;

import java.util.*;

/**
 * The ToStringVisitor builds strings for given Expressions.
 * 
 * @author abrandl
 * 
 *         It should be deterministic, despite Expression using Sets internally.
 *         So it's not the fastest beast here.
 * 
 */
public class ToStringVisitor implements ExpressionVisitor<StringBuilder> {

	private final StringBuilder builder;

	public ToStringVisitor() {
		builder = new StringBuilder();
	}

	@Override
	public StringBuilder visit(And query) {
		builder.append("AND(");
		nestChildren(query);
		builder.append(")");
		return builder;
	}

	@Override
	public StringBuilder visit(Or query) {
		builder.append("OR(");
		nestChildren(query);
		builder.append(")");
		return builder;
	}

	@Override
	public StringBuilder visit(Literal query) {
		builder.append(query.getContent());
		return builder;
	}

	private void nestChildren(InnerExpressionNode query) {
		Iterator<Expression> children = sortChildren(query).iterator();
		while (children.hasNext()) {
			Expression child = children.next();
			child.accept(this);
			if (children.hasNext()) {
				builder.append(",");
			}
		}
	}

	private List<Expression> sortChildren(InnerExpressionNode query) {
		List<Expression> sorted = new ArrayList<Expression>(query.getChildren().size());
		sorted.addAll(query.getChildren());
		/*
		 * use an arbitrary, but deterministic order
		 */
		Collections.sort(sorted, new Comparator<Expression>() {

			@Override
			public int compare(Expression arg0, Expression arg1) {
				int h1 = arg0.hashCode();
				int h2 = arg1.hashCode();
				if (h1 == h2) {
					return 0;
				} else if (h1 < h2) {
					return 1;
				} else {
					return -1;
				}
			}

		});
		return sorted;
	}

	@Override
	public StringBuilder visit(Any any) {
		builder.append("ANY");
		return builder;
	}

}
