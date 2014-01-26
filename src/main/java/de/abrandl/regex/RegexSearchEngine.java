package de.abrandl.regex;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import de.abrandl.regex.document.SimpleDocument;

public interface RegexSearchEngine {

	public interface Writer extends Closeable {
		void open() throws IOException;

		void add(Iterator<SimpleDocument> document) throws IOException;
	}

	public interface Reader extends Closeable {
		void open() throws IOException;

		Collection<SimpleDocument> search(String regex) throws SearchFailedException;
	}

	Writer getWriter();

	Reader getReader();

	/**
	 * one-shot search which opens/closes the engine automatically
	 * 
	 * @param regex
	 * @return
	 * @throws SearchFailedException
	 * @throws IOException
	 */
	Collection<SimpleDocument> search(String regex) throws SearchFailedException, IOException;

	/**
	 * Explain how the engine would process the given query
	 *
	 * @param query
	 * @return
	 * @throws UnsupportedRegexException
	 */
	String explain(String query) throws UnsupportedRegexException;

}
