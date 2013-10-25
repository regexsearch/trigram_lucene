package de.abrandl.regex.query.bool;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExpressionRedundancyRemover implements ExpressionVisitor<Expression> {

	@Override
	public Expression visit(And query) {

		Collection<Expression> newChildren = new HashSet<Expression>();

		for (Expression child : query.getChildren()) {
			newChildren.add(child.accept(this));
		}

		return And.create(newChildren);
	}

	@Override
	public Expression visit(Or query) {

		Set<Expression> survivors = new HashSet<Expression>();
		survivors.addAll(query.getChildren());

		for (Expression e : query.getChildren()) {

			e = e.accept(this);

			if (!(e instanceof Literal))
				continue;

			Literal literal = (Literal) e;

			Iterator<Expression> survivorsIter = survivors.iterator();
			while (survivorsIter.hasNext()) {
				Expression other = survivorsIter.next();
				other.accept(this);
				if (other != literal && other.requires(literal)) {
					survivorsIter.remove();
				}
			}
		}

		return Or.create(survivors);

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
