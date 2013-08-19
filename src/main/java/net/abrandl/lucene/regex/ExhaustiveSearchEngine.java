package net.abrandl.lucene.regex;

import java.util.*;
import java.util.regex.Pattern;

public class ExhaustiveSearchEngine implements RegexSearchEngine {

	private final List<Document> documents = new LinkedList<Document>();

	@Override
	public void addDocument(Document document) {
		documents.add(document);
	}

	@Override
	public Collection<Document> search(String regex) {
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
