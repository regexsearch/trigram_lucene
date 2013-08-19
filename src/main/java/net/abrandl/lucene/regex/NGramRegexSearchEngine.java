package net.abrandl.lucene.regex;

import java.util.*;
import java.util.regex.Pattern;

import net.abrandl.lucene.regex.grammar.RegexParser;
import net.abrandl.lucene.regex.grammar.RegexParsingException;
import net.abrandl.lucene.regex.grammar.tree.RegexNode;
import net.abrandl.lucene.regex.query.NGramQueryTransformation;
import net.abrandl.lucene.regex.query.QueryTransformation;
import net.abrandl.lucene.regex.query.bool.*;
import static com.google.common.base.Preconditions.checkArgument;

public class NGramRegexSearchEngine implements RegexSearchEngine {

	private final NGramTokenizer tokenizer;

	private final QueryTransformation queryTransformation;

	private final Map<String, Set<Document>> invertedIndex = new HashMap<String, Set<Document>>();

	public NGramRegexSearchEngine(int gramSize) {
		checkArgument(gramSize >= 1);

		this.tokenizer = new NGramTokenizer(gramSize);
		this.queryTransformation = new NGramQueryTransformation(gramSize);
	}

	@Override
	public void addDocument(Document document) {

		Set<String> ngrams = tokenizer.tokenize(document.getContent());

		for (String ngram : ngrams) {
			if (!invertedIndex.containsKey(ngram)) {
				invertedIndex.put(ngram, new HashSet<Document>());
			}
			Set<Document> postings = invertedIndex.get(ngram);
			postings.add(document);
		}

	}

	@Override
	public Collection<Document> search(String regex) throws SearchFailedException {

		try {
			RegexNode parsedRegex = RegexParser.parse(regex);
			Expression query = queryTransformation.expressionFor(parsedRegex);

			Set<Document> candidates = query.accept(new ExpressionVisitor<Set<Document>>() {

				@Override
				public Set<Document> visit(And query) {
					Iterator<Expression> iterator = query.iterator();
					Set<Document> match = iterator.next().accept(this);

					while (iterator.hasNext()) {
						match.retainAll(iterator.next().accept(this));
					}
					return match;
				}

				@Override
				public Set<Document> visit(Or query) {
					Iterator<Expression> iterator = query.iterator();
					Set<Document> match = iterator.next().accept(this);

					while (iterator.hasNext()) {
						match.addAll(iterator.next().accept(this));
					}
					return match;
				}

				@Override
				public Set<Document> visit(Literal query) {
					return invertedIndex.get(query.getContent());
				}

				// TODO: optimize
				@Override
				public Set<Document> visit(Any any) {
					Set<Document> allDocs = new HashSet<Document>();
					for (Set<Document> postings : invertedIndex.values()) {
						allDocs.addAll(postings);
					}
					return allDocs;
				}

			});

			if (!(candidates.isEmpty())) {
				Pattern pattern = Pattern.compile(regex);
				Iterator<Document> iterator = candidates.iterator();
				while (iterator.hasNext()) {
					Document doc = iterator.next();
					if (!(pattern.matcher(doc.getContent()).matches())) {
						iterator.remove();
					}
				}
			}

			return candidates;

		} catch (RegexParsingException e) {
			throw new SearchFailedException(e);
		}

	}

}
