import java.io.IOException;
import java.util.Collection;

import de.abrandl.regex.Document;
import de.abrandl.regex.RegexSearchEngine;
import de.abrandl.regex.SearchFailedException;

public class SingleQueryBenchmark {

	public static class BenchmarkResult {
		public long indexingTime;
		public long queryTime;
		public Collection<Document> result;

		@Override
		public String toString() {
			return "BenchmarkResult [indexingTime=" + indexingTime + ", queryTime=" + queryTime + ", foundDocs="
					+ result.size() + "]";
		}

	}

	private final RegexSearchEngine engine;

	public SingleQueryBenchmark(RegexSearchEngine engine) {
		super();
		this.engine = engine;
	}

	public BenchmarkResult benchmark(String regex, Collection<Document> docs) throws IOException, SearchFailedException {
		BenchmarkResult result = new BenchmarkResult();

		result.indexingTime = index(docs);
		query(regex, result);

		return result;
	}

	private void query(String regex, BenchmarkResult result) throws SearchFailedException {
		long startTime = System.currentTimeMillis();

		result.result = engine.search(regex);

		result.queryTime = System.currentTimeMillis() - startTime;
	}

	private long index(Collection<Document> docs) throws IOException {
		long startTime = System.currentTimeMillis();

		for (Document doc : docs) {
			engine.addDocument(doc);
		}

		return System.currentTimeMillis() - startTime;
	}

}
