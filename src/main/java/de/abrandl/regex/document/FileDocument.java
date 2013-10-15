package de.abrandl.regex.document;

import java.io.*;

public class FileDocument implements SimpleDocument {

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		FileDocument other = (FileDocument) obj;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileDocument [path=" + path + "]";
	}

}
