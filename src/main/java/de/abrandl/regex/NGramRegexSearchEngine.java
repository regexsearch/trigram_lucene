package de.abrandl.regex;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

import de.abrandl.regex.grammar.RegexParser;
import de.abrandl.regex.grammar.RegexParsingException;
import de.abrandl.regex.grammar.tree.RegexNode;
import de.abrandl.regex.grammar.tree.RegexNodeVisitorToStringTree;
import de.abrandl.regex.query.NGramQueryTransformation;
import de.abrandl.regex.query.QueryTransformation;
import de.abrandl.regex.query.bool.*;
import static com.google.common.base.Preconditions.checkArgument;

public class NGramRegexSearchEngine implements RegexSearchEngine {

	private final NGramTokenizer tokenizer;

	private final QueryTransformation queryTransformation;

	private final Map<String, Set<SimpleDocument>> invertedIndex = new HashMap<String, Set<SimpleDocument>>();
	private final Set<SimpleDocument> allDocuments = new HashSet<SimpleDocument>();

	public NGramRegexSearchEngine(int gramSize) {
		checkArgument(gramSize >= 1);

		this.tokenizer = new NGramTokenizer(gramSize);
		this.queryTransformation = new NGramQueryTransformation(gramSize);
	}

	private class Writer implements RegexSearchEngine.Writer {

		@Override
		public void close() throws IOException {
			// does nothing
		}

		@Override
		public void open() throws IOException {
			// does nothing
		}

		@Override
		public void add(Iterator<SimpleDocument> docs) throws IOException {
			while (docs.hasNext()) {
				add(docs.next());
			}
		}

		private void add(SimpleDocument document) throws IOException {
			Set<String> ngrams = tokenizer.tokenize(document.getContent());

			for (String ngram : ngrams) {
				if (!invertedIndex.containsKey(ngram)) {
					invertedIndex.put(ngram, new HashSet<SimpleDocument>());
				}
				Set<SimpleDocument> postings = invertedIndex.get(ngram);
				postings.add(document);
			}

			allDocuments.add(document);
		}

	}

	private class Reader implements RegexSearchEngine.Reader {

		@Override
		public void close() throws IOException {
			// does nothing
		}

		@Override
		public void open() throws IOException {
			// does nothing
		}

		@Override
		public Collection<SimpleDocument> search(String regex) throws SearchFailedException {
			try {
				RegexNode parsedRegex = RegexParser.parse(regex);
				Expression query = queryTransformation.expressionFor(parsedRegex);

				System.out.println(parsedRegex.accept(new RegexNodeVisitorToStringTree()));
				System.out.println(query);

				Set<SimpleDocument> candidates = query.accept(new ExpressionVisitor<Set<SimpleDocument>>() {

					@Override
					public Set<SimpleDocument> visit(And query) {
						Iterator<Expression> iterator = query.iterator();
						Set<SimpleDocument> match = iterator.next().accept(this);

						debug(match);

						while (iterator.hasNext()) {
							match.retainAll(iterator.next().accept(this));
							debug(match);
						}
						return match;
					}

					private void debug(Set<SimpleDocument> match) {

					}

					@Override
					public Set<SimpleDocument> visit(Or query) {
						Iterator<Expression> iterator = query.iterator();
						Set<SimpleDocument> match = iterator.next().accept(this);
						debug(match);

						while (iterator.hasNext()) {
							match.addAll(iterator.next().accept(this));
							debug(match);
						}
						return match;
					}

					@Override
					public Set<SimpleDocument> visit(Literal query) {
						Set<SimpleDocument> match = new HashSet<SimpleDocument>();
						String lookupKey = query.getContent();
						if (invertedIndex.containsKey(lookupKey)) {
							match.addAll(invertedIndex.get(lookupKey));
						}
						debug(match);
						return match;
					}

					@Override
					public Set<SimpleDocument> visit(Any any) {
						Set<SimpleDocument> allDocs = new HashSet<SimpleDocument>();
						allDocs.addAll(allDocuments);
						debug(allDocs);
						return allDocs;
					}

				});

				System.out.printf("candidates [%03d]:   %s\n", candidates.size(), candidates);

				if (!(candidates.isEmpty())) {
					Pattern pattern = Pattern.compile(regex);
					Iterator<SimpleDocument> iterator = candidates.iterator();
					while (iterator.hasNext()) {
						SimpleDocument doc = iterator.next();
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

	}

	@Override
	public Writer getWriter() {
		return new Writer();
	}

	@Override
	public Reader getReader() {
		return new Reader();
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

	@Override
	public Collection<SimpleDocument> search(String regex) throws SearchFailedException, IOException {
		try (Reader reader = getReader()) {
			return reader.search(regex);
		}
	}

}
