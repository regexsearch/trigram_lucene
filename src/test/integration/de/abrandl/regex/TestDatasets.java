package de.abrandl.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public enum TestDatasets {

	KEYWORDS("keywords.docs.csv", "keywords.queries.csv"), SALEWA("salewa.docs.csv", "salewa.queries.csv");

	private final String documentsPath, queriesPath;

	private TestDatasets(String documents, String queries) {
		this.documentsPath = documents;
		this.queriesPath = queries;
	}

	public void createIndex(RegexSearchEngine engine) throws IOException {
		try (InputStream resourceAsStream = getClass().getResourceAsStream(documentsPath);
				BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
				RegexSearchEngine.Writer writer = engine.getWriter()) {
			String line;

			while ((line = reader.readLine()) != null) {
				Document document = new Document(line, line);
				writer.add(document);
			}
		}
	}

	public Iterator<String> queries() throws IOException {
		List<String> queries = new LinkedList<String>();
		try (InputStream resourceAsStream = getClass().getResourceAsStream(queriesPath);
				final BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));) {
			String line;

			while ((line = reader.readLine()) != null) {
				queries.add(line);
			}

		}
		return queries.iterator();
	}

}
