package de.abrandl.regex;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class ExhaustiveSearchEngine implements RegexSearchEngine {

	private final List<SimpleDocument> documents = new LinkedList<SimpleDocument>();

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
		public void add(SimpleDocument document) throws IOException {
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
		public Collection<SimpleDocument> search(String regex) throws SearchFailedException {
			Pattern pattern = Pattern.compile(regex);

			Set<SimpleDocument> matches = new HashSet<SimpleDocument>();

			for (SimpleDocument document : documents) {

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
	public Collection<SimpleDocument> search(String regex) throws SearchFailedException, IOException {
		try (Reader reader = getReader()) {
			return reader.search(regex);
		}
	}

}
