import java.io.*;
import java.util.Collection;
import java.util.HashSet;

import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import de.abrandl.regex.Document;
import de.abrandl.regex.ExhaustiveSearchEngine;
import de.abrandl.regex.lucene.LuceneRegexSearchEngine;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FirstBenchmark {

	private void log(String message) {
		System.out.println(message);
	}

	@Test
	public void start() throws Exception {
		Collection<Document> docs = new HashSet<Document>();
		readDocs(new File("/home/abrandl/Dropbox/ma-thesis/data/spiegel2000"), docs);

		log(String.format("loaded %d docs", docs.size()));

		SingleQueryBenchmark lucene = new SingleQueryBenchmark(new LuceneRegexSearchEngine(Version.LUCENE_44,
				new RAMDirectory()));

		SingleQueryBenchmark exhaustive = new SingleQueryBenchmark(new ExhaustiveSearchEngine());

		// String regex = "(Pp)?anorama|6aus49";
		String regex = "(MF)?erkel";

		log("running lucene benchmark...");
		SingleQueryBenchmark.BenchmarkResult luceneResult = lucene.benchmark(regex, docs);
		System.out.println(luceneResult);

		log("running exhaustive search...");
		SingleQueryBenchmark.BenchmarkResult exhaustiveResult = exhaustive.benchmark(regex, docs);
		System.out.println(exhaustiveResult);

		assertThat(luceneResult.result, equalTo(exhaustiveResult.result));
	}

	private Collection<Document> readDocs(File directory, Collection<Document> docs) throws FileNotFoundException,
			IOException {
		return readDocs(directory, docs, null);
	}

	private Collection<Document> readDocs(File directory, Collection<Document> docs, Integer limit)
			throws FileNotFoundException, IOException {

		for (File file : directory.listFiles()) {

			if (file.isFile()) {

				StringBuffer content = new StringBuffer();
				try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
					String line = null;
					while ((line = reader.readLine()) != null) {
						content.append(line);
					}
				}
				Document doc = new Document(file.getName(), content.toString());
				docs.add(doc);

			} else if (file.isDirectory()) {
				readDocs(file, docs, limit);
			}

			if (limit != null && docs.size() >= limit) {
				break;
			}
		}

		return docs;
	}

}
