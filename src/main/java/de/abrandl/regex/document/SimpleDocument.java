package de.abrandl.regex.document;

import java.io.IOException;

public interface SimpleDocument {

	public abstract String getIdentifier();

	public abstract String getContent() throws IOException;

}