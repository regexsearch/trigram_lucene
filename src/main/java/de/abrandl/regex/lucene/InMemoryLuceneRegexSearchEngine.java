package de.abrandl.regex.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import de.abrandl.regex.RegexSearchEngine;
import de.abrandl.regex.RegexSearchEngine.Writer;
import de.abrandl.regex.helpers.RecursiveFileContentIterator;

public class InMemoryLuceneRegexSearchEngine extends LuceneRegexSearchEngine implements RegexSearchEngine {

	public InMemoryLuceneRegexSearchEngine(Version luceneVersion, File initialLoadPath) throws IOException {
		super(luceneVersion, new RAMDirectory());

		initialize(initialLoadPath);
	}

	private void initialize(File initialLoadPath) throws IOException {
		try (Writer writer = getWriter()) {
			writer.add(new RecursiveFileContentIterator(initialLoadPath));
		}
	}

}