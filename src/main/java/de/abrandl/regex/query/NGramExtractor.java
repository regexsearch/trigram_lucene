package de.abrandl.regex.query;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import de.abrandl.regex.NGramTokenizer;
import de.abrandl.regex.query.bool.And;
import de.abrandl.regex.query.bool.Expression;
import de.abrandl.regex.query.bool.Literal;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class NGramExtractor {

	private final NGramTokenizer tokenizer;

	public NGramExtractor(NGramTokenizer tokenizer) {
		checkNotNull(tokenizer);
		this.tokenizer = tokenizer;
	}

	public Expression ngrams(String string) {
		checkNotNull(string);

		Set<String> ngrams = tokenizer.tokenize(string);
		if (ngrams.isEmpty()) {
			return Expression.any();
		} else if (ngrams.size() == 1) {
			return new Literal(ngrams.iterator().next());
		} else {
			HashSet<Expression> literals = new HashSet<Expression>(ngrams.size());
			for (String chars : ngrams) {
				literals.add(new Literal(chars));
			}
			return And.create(literals);
		}
	}

	public Expression ngrams(StringSet set) {
		checkNotNull(set);

		Iterator<String> iterator = set.iterator();

		checkArgument(iterator.hasNext(), "empty StringSet?");

		Expression e = ngrams(iterator.next());

		while (iterator.hasNext()) {
			Expression next = ngrams(iterator.next());
			e = e.or(next);
		}

		return e;
	}

}
