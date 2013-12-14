import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import de.abrandl.regex.ExhaustiveSearchEngine;
import de.abrandl.regex.helpers.DetailsCollector;
import de.abrandl.regex.helpers.RecursiveFileContentIterator;
import de.abrandl.regex.lucene.LuceneRegexSearchEngine;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.OrderingComparison.lessThan;

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
		File documentDirectory = new File("/mnt/msc/datasets/linux-3.12.4");
		Integer limit = null;

		File luceneIndexPath = new File("/home/abrandl/tmp/lucene-benchmark");
		if (luceneIndexPath.isDirectory()) {
			FileUtils.deleteDirectory(luceneIndexPath);
		}
		SingleQueryBenchmark lucene = new SingleQueryBenchmark(new LuceneRegexSearchEngine(Version.LUCENE_46,
				FSDirectory.open(luceneIndexPath)));

		SingleQueryBenchmark exhaustive = new SingleQueryBenchmark(new ExhaustiveSearchEngine());

		// String regex = "(Pp)?anorama|6aus49";
		String regex = "hello world\\.?";
		// String regex = "define|refine";

		log("running lucene benchmark...");
		SingleQueryBenchmark.BenchmarkResult luceneResult = lucene.benchmark(regex,
				createIterator(documentDirectory, limit));
		System.out.println(luceneResult);

		DetailsCollector.instance.flush(System.out);

		log("running exhaustive search...");
		SingleQueryBenchmark.BenchmarkResult exhaustiveResult = exhaustive.benchmark(regex,
				createIterator(documentDirectory, limit));
		System.out.println(exhaustiveResult);

		DetailsCollector.instance.flush(System.out);

		assertThat(luceneResult.result, equalTo(exhaustiveResult.result));

		assertThat(luceneResult.queryTime, is(lessThan(exhaustiveResult.queryTime)));
	}

	private RecursiveFileContentIterator createIterator(File documentDirectory, Integer limit) {
		return new RecursiveFileContentIterator(documentDirectory, RecursiveFileContentIterator.Strategy.LAZY, limit);
	}
}
