package de.abrandl.regex.document;

import java.io.IOException;

public abstract class SimpleDocument {

	public abstract String getIdentifier();

	public abstract String getContent() throws IOException;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		String identifier = getIdentifier();
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SimpleDocument))
			return false;
		SimpleDocument other = (SimpleDocument) obj;

		String identifier = getIdentifier();
		String otherIdentifier = other.getIdentifier();
		if (identifier == null) {
			if (otherIdentifier != null)
				return false;
		} else if (!identifier.equals(otherIdentifier))
			return false;
		return true;
	}

}