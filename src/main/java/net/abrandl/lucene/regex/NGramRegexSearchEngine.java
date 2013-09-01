package net.abrandl.lucene.regex;

import java.util.*;
import java.util.regex.Pattern;

import net.abrandl.lucene.regex.grammar.RegexParser;
import net.abrandl.lucene.regex.grammar.RegexParsingException;
import net.abrandl.lucene.regex.grammar.tree.RegexNode;
import net.abrandl.lucene.regex.grammar.tree.RegexNodeVisitorToStringTree;
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

			System.out.println(parsedRegex.accept(new RegexNodeVisitorToStringTree()));
			System.out.println(query);

			Set<Document> candidates = query.accept(new ExpressionVisitor<Set<Document>>() {

				@Override
				public Set<Document> visit(And query) {
					Iterator<Expression> iterator = query.iterator();
					Set<Document> match = iterator.next().accept(this);

					debug(match);

					while (iterator.hasNext()) {
						match.retainAll(iterator.next().accept(this));
						debug(match);
					}
					return match;
				}

				private void debug(Set<Document> match) {

				}

				@Override
				public Set<Document> visit(Or query) {
					Iterator<Expression> iterator = query.iterator();
					Set<Document> match = iterator.next().accept(this);
					debug(match);

					while (iterator.hasNext()) {
						match.addAll(iterator.next().accept(this));
						debug(match);
					}
					return match;
				}

				@Override
				public Set<Document> visit(Literal query) {
					Set<Document> match = new HashSet<Document>();
					String lookupKey = query.getContent();
					if (invertedIndex.containsKey(lookupKey)) {
						match.addAll(invertedIndex.get(lookupKey));
					}
					debug(match);
					return match;
				}

				// TODO: optimize
				@Override
				public Set<Document> visit(Any any) {
					Set<Document> allDocs = new HashSet<Document>();
					for (Set<Document> postings : invertedIndex.values()) {
						allDocs.addAll(postings);
					}
					debug(allDocs);
					return allDocs;
				}

			});

			System.out.printf("candidates [%03d]:   %s\n", candidates.size(), candidates);

			if (!(candidates.isEmpty())) {
				Pattern pattern = Pattern.compile(regex);
				Iterator<Document> iterator = candidates.iterator();
				while (iterator.hasNext()) {
					Document doc = iterator.next();
					if (!(pattern.matcher(doc.getContent()).find())) {
						iterator.remove();
					}
				}
			}

			return candidates;

		} catch (RegexParsingException e) {
			throw new SearchFailedException(e);
		}

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NGramRegexSearchEngine:\n");
		builder.append(invertedIndex);
		for (String key : invertedIndex.keySet()) {
			builder.append(String.format("'%s'  ->  %s\n", key, invertedIndex.get(key)));
		}
		return builder.toString();
	}

}
