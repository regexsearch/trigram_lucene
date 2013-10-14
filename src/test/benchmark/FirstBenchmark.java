import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import de.abrandl.regex.ExhaustiveSearchEngine;
import de.abrandl.regex.helpers.RecursiveFileContentIterator;
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

		// File documentDirectory = new
		// File("/home/abrandl/Dropbox/ma-thesis/data/spiegel2000");
		File documentDirectory = new File("/home/abrandl/Downloads/linux-3.11.4");
		Integer limit = null;

		File luceneIndexPath = new File("/tmp/lucene-benchmark");
		if (luceneIndexPath.isDirectory()) {
			FileUtils.deleteDirectory(luceneIndexPath);
		}
		SingleQueryBenchmark lucene = new SingleQueryBenchmark(new LuceneRegexSearchEngine(Version.LUCENE_44,
				FSDirectory.open(luceneIndexPath)));

		SingleQueryBenchmark exhaustive = new SingleQueryBenchmark(new ExhaustiveSearchEngine());

		// String regex = "(Pp)?anorama|6aus49";
		String regex = "hello world";

		log("running lucene benchmark...");
		SingleQueryBenchmark.BenchmarkResult luceneResult = lucene.benchmark(regex, new RecursiveFileContentIterator(
				documentDirectory, limit));
		System.out.println(luceneResult);

		log("running exhaustive search...");
		SingleQueryBenchmark.BenchmarkResult exhaustiveResult = exhaustive.benchmark(regex,
				new RecursiveFileContentIterator(documentDirectory, limit));
		System.out.println(exhaustiveResult);

		assertThat(luceneResult.result, equalTo(exhaustiveResult.result));
	}

}
