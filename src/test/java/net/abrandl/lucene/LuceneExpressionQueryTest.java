package net.abrandl.lucene;

import java.util.HashSet;
import java.util.Set;

import net.abrandl.lucene.regex.query.bool.Expression;
import net.abrandl.lucene.regex.query.bool.Literal;
import net.abrandl.test.Helpers;

import org.apache.lucene.search.*;
import org.apache.lucene.search.BooleanClause.Occur;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LuceneExpressionQueryTest {

	private LuceneExpressionQuery visitor;
	private final String indexField = "field";

	@Before
	public void setUp() throws Exception {
		visitor = new LuceneExpressionQuery(indexField);
	}

	@Test
	public void convertsAnyToMatchAllDocsQuery() {
		Expression any = Expression.any();
		Query result = any.accept(visitor);

		assertThat(result, is(MatchAllDocsQuery.class));
	}

	@Test
	public void convertsLiteralsToTermQueries() {
		Literal literal = new Literal("literal");
		TermQuery result = (TermQuery) literal.accept(visitor);

		assertThat(result.getTerm().toString(), equalTo(withField("literal")));
	}

	@Test
	public void convertsAndToBooleanQueryWithMUST() {
		Expression and = Expression.and("foo", "bar", "bla");
		BooleanQuery result = (BooleanQuery) and.accept(visitor);

		BooleanClause[] clauses = result.getClauses();

		assertThat(clauses.length, equalTo(3));

		Set<String> expected = Helpers.asSet(withField("foo"), withField("bar"), withField("bla"));
		Set<String> literals = new HashSet<String>();

		for (BooleanClause clause : clauses) {
			assertThat(clause.getOccur(), equalTo(Occur.MUST));
			String literal = ((TermQuery) clause.getQuery()).getTerm().toString();
			literals.add(literal);
		}

		assertThat(literals, equalTo(expected));
	}

	@Test
	public void convertsOrToBooleanQueryWithMUST() {
		Expression and = Expression.or("foo", "bar", "bla");
		BooleanQuery result = (BooleanQuery) and.accept(visitor);

		BooleanClause[] clauses = result.getClauses();

		assertThat(clauses.length, equalTo(3));

		Set<String> expected = Helpers.asSet(withField("foo"), withField("bar"), withField("bla"));
		Set<String> literals = new HashSet<String>();

		for (BooleanClause clause : clauses) {
			assertThat(clause.getOccur(), equalTo(Occur.SHOULD));
			String literal = ((TermQuery) clause.getQuery()).getTerm().toString();
			literals.add(literal);
		}

		assertThat(literals, equalTo(expected));
	}

	private String withField(String literal) {
		return String.format("%s:%s", indexField, literal);
	}

}