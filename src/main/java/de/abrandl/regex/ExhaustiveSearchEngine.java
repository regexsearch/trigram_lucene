package de.abrandl.regex;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class ExhaustiveSearchEngine implements RegexSearchEngine {

	private final List<Document> documents = new LinkedList<Document>();

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
		public void add(Document document) throws IOException {
			documents.add(document);
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
		public Collection<Document> search(String regex) throws SearchFailedException {
			Pattern pattern = Pattern.compile(regex);

			Set<Document> matches = new HashSet<Document>();

			for (Document document : documents) {

				if (pattern.matcher(document.getContent()).find()) {
					matches.add(document);
				}
			}

			return matches;
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
	public Collection<Document> search(String regex) throws SearchFailedException, IOException {
		try (Reader reader = getReader()) {
			return reader.search(regex);
		}
	}

}
