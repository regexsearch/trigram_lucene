package de.abrandl.regex.document;

import java.io.File;
import java.io.IOException;

import static de.abrandl.regex.helpers.FileUtil.read;

public class FileDocument extends SimpleDocument {

	private final File path;

	public FileDocument(File path) {
		super();
		this.path = path;
	}

	public FileDocument(String path) {
		this(new File(path));
	}

	@Override
	public String getIdentifier() {
		return path.getAbsolutePath();
	}

	@Override
	public String getContent() throws IOException {
		return read(path).toString();
	}

	@Override
	public String toString() {
		return getIdentifier();
	}

}
