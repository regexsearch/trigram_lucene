package de.abrandl.regex.document;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class InMemoryDocument extends SimpleDocument {

	private final String identifier, content;

	public InMemoryDocument(String identifier, String content) {
		checkArgument(!identifier.isEmpty(), "identifier is empty");
		this.identifier = checkNotNull(identifier);
		this.content = checkNotNull(content);
	}

	@Override
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return (identifier.equals(content)) ? String.format("\"%s\"", content) : "Document [identifier=" + identifier
				+ ", content=" + content + "]";
	}

}
