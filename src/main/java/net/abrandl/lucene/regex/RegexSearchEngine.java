package net.abrandl.lucene.regex;

import java.util.Collection;

public interface RegexSearchEngine {

	void addDocument(Document document);

	Collection<Document> search(String regex) throws SearchFailedException;

}
