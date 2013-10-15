package de.abrandl.regex.document;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class InMemoryDocument implements SimpleDocument {

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InMemoryDocument other = (InMemoryDocument) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return (identifier.equals(content)) ? String.format("\"%s\"", content) : "Document [identifier=" + identifier
				+ ", content=" + content + "]";
	}

}
