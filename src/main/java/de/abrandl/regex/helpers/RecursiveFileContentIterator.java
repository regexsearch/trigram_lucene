package de.abrandl.regex.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.abrandl.regex.document.FileDocument;
import de.abrandl.regex.document.InMemoryDocument;
import de.abrandl.regex.document.SimpleDocument;

public class RecursiveFileContentIterator implements Iterator<SimpleDocument> {

	public enum Strategy {
		EAGER(new EagerFileLoadStrategy()), LAZY(new LazyFileLoadStrategy());

		private final FileLoadStrategy strategy;

		private Strategy(FileLoadStrategy strategy) {
			this.strategy = strategy;
		}

		public FileLoadStrategy getStrategy() {
			return strategy;
		}

	}

	public interface FileLoadStrategy {
		SimpleDocument load(File file) throws IOException;
	}

	public static class EagerFileLoadStrategy implements FileLoadStrategy {

		@Override
		public SimpleDocument load(File file) throws IOException {
			StringBuffer content = new StringBuffer();
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					content.append(line);
				}
			}
			return new InMemoryDocument(file.getPath(), content.toString());
		}

	}

	public static class LazyFileLoadStrategy implements FileLoadStrategy {

		@Override
		public SimpleDocument load(File file) throws IOException {
			return new FileDocument(file);
		}
	}

	private Integer limit;
	private final List<File> files;

	private Iterator<File> fileIterator;
	private final File directory;
	private final FileLoadStrategy fileLoadStrategy;

	public RecursiveFileContentIterator(File directory) {
		this(directory, new LazyFileLoadStrategy(), null);
	}

	public RecursiveFileContentIterator(File directory, Strategy fileLoadStrategy, Integer limit) {
		this(directory, fileLoadStrategy.getStrategy(), limit);
	}

	public RecursiveFileContentIterator(File directory, FileLoadStrategy fileLoadStrategy, Integer limit) {
		super();
		this.fileLoadStrategy = fileLoadStrategy;
		this.limit = limit;
		this.files = new LinkedList<File>();

		this.directory = directory;

		reinitIterator();
	}

	synchronized public void reset(Integer limit) {
		this.files.clear();
		this.limit = limit;
		reinitIterator();
	}

	private void reinitIterator() {
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
		if (!directory.isDirectory()) {
			throw new IllegalArgumentException("not a directory: " + directory.getAbsolutePath());
		}
		File[] listFiles = directory.listFiles();
		for (File file : listFiles) {
			if (file.isFile() && withinLimit()) {
				files.add(file);
			} else if (file.isDirectory()) {
				readFilePaths(file);
			}
		}
	}

	synchronized public int size() {
		return files.size();
	}

	@Override
	synchronized public boolean hasNext() {
		return fileIterator.hasNext();
	}

	@Override
	synchronized public SimpleDocument next() {
		File file = fileIterator.next();
		if (file != null) {
			try {
				return fileLoadStrategy.load(file);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} else {
			return null;
		}
	}

	@Override
	synchronized public void remove() {
		fileIterator.remove();
	}

}
