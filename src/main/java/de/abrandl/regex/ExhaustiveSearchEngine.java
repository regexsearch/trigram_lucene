package de.abrandl.regex;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

import de.abrandl.regex.document.SimpleDocument;

public class ExhaustiveSearchEngine implements RegexSearchEngine {

	private final List<Iterator<SimpleDocument>> documents = new LinkedList<Iterator<SimpleDocument>>();

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
		public void add(Iterator<SimpleDocument> document) throws IOException {
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

			try {
				for (Iterator<SimpleDocument> iter : documents) {
					while (iter.hasNext()) {
						SimpleDocument doc = iter.next();
						if (pattern.matcher(doc.getContent()).find()) {
							matches.add(doc);
						}
					}
				}
				return matches;
			} catch (IOException e) {
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
	public Collection<SimpleDocument> search(String regex) throws SearchFailedException, IOException {
		try (Reader reader = getReader()) {
			return reader.search(regex);
		}
	}

}
