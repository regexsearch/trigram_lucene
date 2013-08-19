package net.abrandl.lucene.regex;

import java.util.*;
import java.util.regex.Pattern;

public class ExhaustiveSearchEngine implements RegexSearchEngine {

	private final Map<String, Document> documents = new HashMap<String, Document>();

	@Override
	public void addDocument(Document document) {
		documents.put(document.getIdentifier(), document);
	}

	@Override
	public Collection<Document> search(String regex) {
		Pattern pattern = Pattern.compile(regex);

		List<Document> matches = new LinkedList<Document>();

		for (Document document : documents.values()) {

			if (pattern.matcher(document.getContent()).matches()) {
				matches.add(document);
			}
		}

		return matches;
	}

}
