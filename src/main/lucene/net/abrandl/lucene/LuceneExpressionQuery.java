package net.abrandl.lucene;

import net.abrandl.lucene.regex.query.bool.*;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.*;

import static com.google.common.base.Preconditions.checkNotNull;

public class LuceneExpressionQuery implements ExpressionVisitor<Query> {

	private final String indexField;

	public LuceneExpressionQuery(String indexField) {
		this.indexField = checkNotNull(indexField);
	}

	@Override
	public Query visit(And query) {
		BooleanQuery boolQuery = new BooleanQuery();
		for (Expression e : query) {
			boolQuery.add(e.accept(this), Occur.MUST);
		}
		return boolQuery;
	}

	@Override
	public Query visit(Or query) {
		BooleanQuery boolQuery = new BooleanQuery();
		for (Expression e : query) {
			boolQuery.add(e.accept(this), Occur.SHOULD);
		}
		return boolQuery;
	}

	@Override
	public Query visit(Literal query) {
		return new TermQuery(new Term(indexField, query.getContent()));
	}

	@Override
	public Query visit(Any any) {
		checkNotNull(any);
		return new MatchAllDocsQuery();
	}

}
