package de.abrandl.regex;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import de.abrandl.regex.document.FileDocument;
import de.abrandl.regex.document.SimpleDocument;

public class InMemorySearchEngine implements RegexSearchEngine {

	private final Map<String, String> documents = new HashMap<String, String>();

	@Override
	public Writer getWriter() {
		return new InMemoryWriter();
	}

	@Override
	public Reader getReader() {
		return new InMemoryReader();
	}

	@Override
	public Collection<SimpleDocument> search(String regex) throws SearchFailedException, IOException {
		try (Reader reader = getReader()) {
			return reader.search(regex);
		}
	}

	@Override
	public String explain(String query) {
		return "in-memory-grep: " + query;
	}

	private class InMemoryWriter implements Writer {

		@Override
		public void close() throws IOException {
		}

		@Override
		public void open() throws IOException {
		}

		@Override
		public void add(Iterator<SimpleDocument> iter) throws IOException {
			while (iter.hasNext()) {
				SimpleDocument document = iter.next();

				// store in-memory
				documents.put(document.getIdentifier(), document.getContent());
			}
		}

	}

	private class InMemoryReader implements Reader {

		@Override
		public void close() throws IOException {
		}

		@Override
		public void open() throws IOException {
		}

		@Override
		public Collection<SimpleDocument> search(String regex) throws SearchFailedException {

			final Pattern pattern = Pattern.compile(regex);
			final Set<SimpleDocument> matches = new HashSet<SimpleDocument>();

			for (Entry<String, String> e : documents.entrySet()) {
				String content = e.getValue();
				if (pattern.matcher(content).find()) {
					String identifier = e.getKey();
					SimpleDocument doc = new FileDocument(identifier);
					matches.add(doc);
				}
			}

			return matches;
		}

	}

}
