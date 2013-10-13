package net.abrandl.lucene.regex;

import java.io.IOException;
import java.util.Collection;

public interface RegexSearchEngine {

	void addDocument(Document document) throws IOException;

	Collection<Document> search(String regex) throws SearchFailedException;

}
