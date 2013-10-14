package de.abrandl.regex.helpers;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.abrandl.regex.SimpleDocument;

public class RecursiveFileContentIterator implements Iterator<SimpleDocument> {

	private final Integer limit;
	private final List<File> files;

	private final Iterator<File> fileIterator;

	public RecursiveFileContentIterator(File directory) {
		this(directory, null);
	}

	public RecursiveFileContentIterator(File directory, Integer limit) {
		super();
		this.limit = limit;
		this.files = new LinkedList<File>();

		readFilePaths(directory);
		fileIterator = files.iterator();
	}

	private boolean withinLimit() {
		if (limit != null) {
			return files.size() < limit;
		} else {
			return true;
		}
	}

	private void readFilePaths(File directory) {
		for (File file : directory.listFiles()) {
			if (file.isFile() && withinLimit()) {
				files.add(file);
			} else if (file.isDirectory()) {
				readFilePaths(file);
			}
		}
	}

	private SimpleDocument readFile(File file) throws FileNotFoundException, IOException {
		StringBuffer content = new StringBuffer();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}
		}
		return new SimpleDocument(file.getPath(), content.toString());
	}

	public int size() {
		return files.size();
	}

	@Override
	public boolean hasNext() {
		return fileIterator.hasNext();
	}

	@Override
	public SimpleDocument next() {
		File file = fileIterator.next();
		if (file != null) {
			try {
				return readFile(file);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} else {
			return null;
		}
	}

	@Override
	public void remove() {
		fileIterator.remove();
	}

}
