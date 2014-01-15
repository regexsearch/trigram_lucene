package de.abrandl.regex;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

import org.kamranzafar.jtar.TarEntry;
import org.kamranzafar.jtar.TarInputStream;
import org.kamranzafar.jtar.TarOutputStream;

import de.abrandl.regex.document.FileDocument;
import de.abrandl.regex.document.SimpleDocument;
import de.abrandl.regex.helpers.FileUtil;
import static com.google.common.base.Preconditions.checkArgument;

public class TarSearchEngine implements RegexSearchEngine {

	private final File indexPath;
	private final File indexFile;

	public TarSearchEngine(File indexPath) {
		super();
		this.indexPath = indexPath;
		this.indexFile = new File(indexPath, "index.tar");
	}

	public TarSearchEngine() throws IOException {
		this(FileUtil.createEmptyTempDirectory("tar_search"));
	}

	private class Writer implements RegexSearchEngine.Writer {

		private TarOutputStream tarStream;

		@Override
		public void close() throws IOException {
			tarStream.close();
			tarStream = null;
		}

		@Override
		public void open() throws IOException {
			if (!indexPath.isDirectory()) {
				indexPath.mkdirs();
			}

			checkArgument(indexPath.isDirectory(), "index is not a directory");
			checkArgument(indexPath.canWrite(), "cannot write to index");

			if (tarStream == null) {
				tarStream = new TarOutputStream(new BufferedOutputStream(new FileOutputStream(indexFile)));
			}
		}

		@Override
		public void add(Iterator<SimpleDocument> documents) throws IOException {
			open();
			while (documents.hasNext()) {
				SimpleDocument document = documents.next();
				File docPath = new File(document.getIdentifier());
				tarStream.putNextEntry(new TarEntry(docPath, document.getIdentifier()));

				try (BufferedInputStream origin = new BufferedInputStream(new FileInputStream(docPath))) {
					int count;
					byte data[] = new byte[2048];
					while ((count = origin.read(data)) != -1) {
						tarStream.write(data, 0, count);
					}
				}
				tarStream.flush();
			}
		}
	}

	private class Reader implements RegexSearchEngine.Reader {

		private TarInputStream tarStream;

		@Override
		public void close() throws IOException {
			if (tarStream != null) {
				tarStream.close();
				tarStream = null;
			}
		}

		@Override
		public void open() throws IOException {
			if (tarStream == null) {
				tarStream = new TarInputStream(new BufferedInputStream(new FileInputStream(indexFile)));
			}
		}

		@Override
		public Collection<SimpleDocument> search(String regex) throws SearchFailedException {
			try {
				open();
				final Pattern pattern = Pattern.compile(regex);
				final Set<SimpleDocument> matches = new HashSet<SimpleDocument>();

				TarEntry entry;
				String content;
				int count;
				byte data[] = new byte[2048];

				while ((entry = tarStream.getNextEntry()) != null) {
					try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
						while ((count = tarStream.read(data)) != -1) {
							baos.write(data, 0, count);
						}
						content = baos.toString();
					}
					if (pattern.matcher(content).find()) {
						// System.out.printf("Pattern %s matches content: %s\n",
						// pattern, content);
						SimpleDocument doc = new FileDocument(String.format("/%s", entry.getName()));
						matches.add(doc);
					}
				}

				close();

				return matches;
			} catch (IOException e) {
				throw new SearchFailedException(e);
			}
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

	@Override
	public String explain(String query) {
		return "jgrep-tar '" + query + "'";
	}

}
