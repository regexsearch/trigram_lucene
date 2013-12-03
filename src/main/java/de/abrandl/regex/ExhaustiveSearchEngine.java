package de.abrandl.regex;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import de.abrandl.regex.document.FileDocument;
import de.abrandl.regex.document.SimpleDocument;
import de.abrandl.regex.helpers.FileUtil;
import static com.google.common.base.Preconditions.checkArgument;
import static de.abrandl.regex.helpers.FileUtil.read;

public class ExhaustiveSearchEngine implements RegexSearchEngine {

	private final File indexPath;

	public ExhaustiveSearchEngine(File indexPath) {
		super();
		this.indexPath = indexPath;
	}

	public ExhaustiveSearchEngine() throws IOException {
		this(FileUtil.createEmptyTempDirectory("exhaustive_search"));
	}

	private class Writer implements RegexSearchEngine.Writer {

		@Override
		public void close() throws IOException {
			// does nothing
		}

		@Override
		public void open() throws IOException {
			if (!indexPath.isDirectory()) {
				indexPath.mkdirs();
			}
		}

		@Override
		public void add(Iterator<SimpleDocument> documents) throws IOException {
			checkArgument(indexPath.isDirectory(), "index is not a directory");
			checkArgument(indexPath.canRead(), "cannot write to index");

			while (documents.hasNext()) {
				SimpleDocument document = documents.next();
				File docPath = new File(document.getIdentifier());
				File directory = new File(indexPath, docPath.getParentFile().getAbsolutePath());
				directory.mkdirs();
				FileUtils.copyFile(docPath, new File(directory, docPath.getName()));
			}
		}
	}

	private class Reader implements RegexSearchEngine.Reader {

		@Override
		public void close() throws IOException {
			// does nothing
		}

		@Override
		public void open() throws IOException {
			// does nothing
		}

		private List<File> listFiles(File directory, List<File> files) {
			for (File file : directory.listFiles()) {
				if (file.isDirectory()) {
					listFiles(file, files);
				} else if (file.isFile()) {
					files.add(file);
				}
			}
			return files;
		}

		private List<File> listFiles(File directory) {
			return listFiles(directory, new LinkedList<File>());
		}

		private File originalPath(File indexFile) {
			return new File(indexFile.getAbsolutePath().replaceFirst(indexPath.getAbsolutePath(), ""));
		}

		@Override
		public Collection<SimpleDocument> search(String regex) throws SearchFailedException {
			final Pattern pattern = Pattern.compile(regex);
			final Set<SimpleDocument> matches = new HashSet<SimpleDocument>();

			try {
				for (File file : listFiles(indexPath)) {
					StringBuffer content;
					content = read(file);
					if (pattern.matcher(content).find()) {
						SimpleDocument doc = new FileDocument(originalPath(file));
						matches.add(doc);
					}
				}
			} catch (IOException e) {
				throw new SearchFailedException(e);
			}

			return matches;
		}

	}

	@Override
	public Writer getWriter() {
		return new Writer();
	}

	@Override
	public Reader getReader() {
		return new Reader();
	}

	@Override
	public Collection<SimpleDocument> search(String regex) throws SearchFailedException, IOException {
		try (Reader reader = getReader()) {
			return reader.search(regex);
		}
	}

}
