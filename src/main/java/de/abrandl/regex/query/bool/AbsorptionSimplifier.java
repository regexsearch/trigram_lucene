package de.abrandl.regex.query.bool;

import java.util.*;

public class AbsorptionSimplifier implements ExpressionVisitor<Expression> {

	@Override
	public Expression visit(And query) {
		return And.create(simplify(query));
	}

	@Override
	public Expression visit(Or query) {
		return Or.create(simplify(query));
	}

	private Collection<Expression> simplify(InnerExpressionNode parent) {
		List<Expression> survivors = new ArrayList<Expression>();

		// recurse down to children
		for (Expression child : parent.getChildren()) {
			survivors.add(child.accept(this));
		}

		for (int i = 0; i < survivors.size(); i++) {
			Expression a = survivors.get(i);
			for (int j = 0; j < survivors.size(); j++) {

				Expression b = survivors.get(j);

				if (a != b) {
					if (isSubset(a, b, parent)) {
						survivors.remove(j);
						break;
					}
				}

			}
		}

		// use HashSets internally
		// due to equals being type-aware (InnerExpressionNode)
		Set<Expression> set = new HashSet<Expression>(survivors.size());
		set.addAll(survivors);

		return set;

	}

	/**
	 * Returns true if a is always true given that b is true
	 * 
	 * @param a
	 * @param b
	 * @param parent
	 * @return
	 */
	private boolean isSubset(Expression a, Expression b, InnerExpressionNode parent) {
		if (a.equals(b)) {
			return true;
		}

		// AND( OR(a,b), OR(a,b,c)) -> OR(a,b)
		if (a instanceof Or && b instanceof Or && parent instanceof And) {
			return containsAllChildren((Or) a, (Or) b);
		}

		// OR ( AND(a,b), AND(a,b,c)) -> AND(a,b)
		if (a instanceof And && b instanceof And && parent instanceof Or) {
			return containsAllChildren((And) a, (And) b);
		}

		return false;
	}

	private boolean containsAllChildren(InnerExpressionNode a, InnerExpressionNode b) {
		Collection<Expression> subset = b.getChildren();

		for (Expression child : a.getChildren()) {
			if (!subset.contains(child)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Expression visit(Literal query) {
		return query;
	}

	@Override
	public Expression visit(Any any) {
		return any;
	}

}
