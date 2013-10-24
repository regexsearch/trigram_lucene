package de.abrandl.regex.query.bool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExpressionRedundancyRemover implements ExpressionVisitor<Expression> {

	@Override
	public Expression visit(And query) {
		return query;
	}

	@Override
	public Expression visit(Or query) {

		Set<Expression> survivors = new HashSet<Expression>();
		survivors.addAll(query.getChildren());

		for (Expression e : query.getChildren()) {
			if (!(e instanceof Literal))
				continue;

			Literal literal = (Literal) e;

			Iterator<Expression> survivorsIter = survivors.iterator();
			while (survivorsIter.hasNext()) {
				Expression other = survivorsIter.next();
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
