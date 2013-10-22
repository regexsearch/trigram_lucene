package de.abrandl.regex.document;

import java.io.*;

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
		return readFile(path);
	}

	private String readFile(File file) throws FileNotFoundException, IOException {
		StringBuffer content = new StringBuffer();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}
		}
		return content.toString();
	}

	@Override
	public String toString() {
		return "FileDocument [identifier=\"" + getIdentifier() + "\"]";
	}

}
