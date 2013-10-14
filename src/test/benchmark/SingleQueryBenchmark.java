import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import de.abrandl.regex.RegexSearchEngine;
import de.abrandl.regex.SearchFailedException;
import de.abrandl.regex.SimpleDocument;

public class SingleQueryBenchmark {

	public static class BenchmarkResult {
		public long indexingTime;
		public long queryTime;
		public Collection<SimpleDocument> result;

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

	public BenchmarkResult benchmark(String regex, Iterator<SimpleDocument> docs) throws IOException,
			SearchFailedException {
		BenchmarkResult result = new BenchmarkResult();

		result.indexingTime = index(docs);
		query(regex, result);

		return result;
	}

	private void query(String regex, BenchmarkResult result) throws SearchFailedException, IOException {
		long startTime = System.currentTimeMillis();

		try (RegexSearchEngine.Reader reader = engine.getReader()) {
			result.result = reader.search(regex);
		}

		result.queryTime = System.currentTimeMillis() - startTime;
	}

	private long index(Iterator<SimpleDocument> docs) throws IOException {
		long startTime = System.currentTimeMillis();

		try (RegexSearchEngine.Writer writer = engine.getWriter()) {
			while (docs.hasNext()) {
				writer.add(docs.next());
			}
		}

		return System.currentTimeMillis() - startTime;
	}

}
