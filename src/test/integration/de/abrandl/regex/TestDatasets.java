package de.abrandl.regex;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.abrandl.regex.helpers.FileUtil;
import de.abrandl.regex.helpers.RecursiveFileContentIterator;

public enum TestDatasets {

	KEYWORDS("keywords.docs.csv", "keywords.queries.csv"), SALEWA("salewa.docs.csv", "salewa.queries.csv");

	private final String documentsFile, queriesFile;

	private TestDatasets(String documents, String queries) {
		this.documentsFile = documents;
		this.queriesFile = queries;
	}

	public void createIndex(RegexSearchEngine engine) throws IOException {

		File localDocsDirectory = FileUtil.createEmptyTempDirectory(documentsFile);

		try (InputStream resourceAsStream = getClass().getResourceAsStream(documentsFile);
				BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));) {
			String line;

			int id = 0;
			while ((line = reader.readLine()) != null) {
				File docFile = new File(localDocsDirectory, String.format("%04d.csv", id));

				writeFile(docFile, line);

				id++;
			}
		}

		try (RegexSearchEngine.Writer writer = engine.getWriter()) {
			RecursiveFileContentIterator docs = new RecursiveFileContentIterator(localDocsDirectory);
			writer.add(docs);
		}

	}

	private void writeFile(File docFile, String line) throws IOException {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)))) {
			writer.write(line);
		}
	}

	public Iterator<String> queries() throws IOException {
		List<String> queries = new LinkedList<String>();
		try (InputStream resourceAsStream = getClass().getResourceAsStream(queriesFile);
				final BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));) {
			String line;

			while ((line = reader.readLine()) != null) {
				queries.add(line);
			}

		}
		return queries.iterator();
	}

}
