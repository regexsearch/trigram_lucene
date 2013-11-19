package de.abrandl.regex.benchmark;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import de.abrandl.regex.ExhaustiveSearchEngine;
import de.abrandl.regex.RegexSearchEngine;
import de.abrandl.regex.SearchFailedException;
import de.abrandl.regex.helpers.RecursiveFileContentIterator;
import de.abrandl.regex.lucene.LuceneRegexSearchEngine;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class ScalingBenchmark implements Benchmark {

	public interface SearchEngineFactory {
		RegexSearchEngine create(File path) throws IOException;
	}

	private final SearchEngineFactory factory;
	private RegexSearchEngine engine;
	private File path;
	private final int scale;
	private final RecursiveFileContentIterator docs;

	public ScalingBenchmark(int scale, SearchEngineFactory factory, RecursiveFileContentIterator docs) {
		checkArgument(scale <= 100);
		checkArgument(scale >= 0);
		this.scale = scale;
		this.factory = checkNotNull(factory);
		this.docs = docs;
	}

	@Override
	public void prepare() throws BenchmarkException, IOException {
		// configure local path for index
		path = new File(String.format("/tmp/benchmark.%d", System.currentTimeMillis()));
		if (path.isDirectory()) {
			cleanup();
		}
		path.mkdirs();

		engine = factory.create(path);

		int allDocsCount = docs.size();
		int scaledDocsCount = (int) (allDocsCount * (scale / 100.0d)) + 1;
		System.out.printf("indexing %d of %d documents at scale %d", scaledDocsCount, allDocsCount, scale);
		docs.reset(scaledDocsCount);

		try (RegexSearchEngine.Writer writer = engine.getWriter()) {
			writer.add(docs);
		}
	}

	@Override
	public void run() throws BenchmarkException, IOException {
		try (RegexSearchEngine.Reader reader = engine.getReader()) {
			reader.search("hello world");
		} catch (SearchFailedException e) {
			throw new BenchmarkException(e);
		}

	}

	@Override
	public void cleanup() throws BenchmarkException, IOException {
		// delete index
		if (path.isDirectory()) {
			FileUtils.deleteDirectory(path);
		}
	}

	public static void main(String[] args) throws BenchmarkException {

		BenchmarkRunner runner = new BenchmarkRunner();

		SearchEngineFactory luceneFactory = new SearchEngineFactory() {

			@Override
			public RegexSearchEngine create(File path) throws IOException {
				return new LuceneRegexSearchEngine(Version.LUCENE_44, FSDirectory.open(path));
			}
		};

		SearchEngineFactory exhaustiveFactory = new SearchEngineFactory() {

			@Override
			public RegexSearchEngine create(File path) throws IOException {
				return new ExhaustiveSearchEngine();
			}
		};

		File docsPath = new File("/home/abrandl/Downloads/linux-3.11.4");

		final int repeat = 5;
		Map<Integer, List<Long>> results = new HashMap<Integer, List<Long>>();

		for (int scale = 0; scale <= 100; scale += 10) {

			List<Long> runtimes = new LinkedList<Long>();
			for (int round = 0; round < repeat; round++) {
				RecursiveFileContentIterator docs = new RecursiveFileContentIterator(docsPath,
						RecursiveFileContentIterator.Strategy.LAZY, null);
				ScalingBenchmark benchmark = new ScalingBenchmark(scale, exhaustiveFactory, docs);
				long runtime = runner.execute(benchmark);
				System.out.printf("scale %03d  runtime %d ms\n", scale, runtime);
				runtimes.add(runtime);
			}

			results.put(scale, runtimes);
		}

		System.out.println("************************* RESULTS **************************");

		for (Entry<Integer, List<Long>> entry : results.entrySet()) {
			print(entry);
		}

		System.out.println("************************* RESULTS **************************");

	}

	private static String DELIM = ";";

	private static void print(Entry<Integer, List<Long>> entry) {
		StringBuffer sb = new StringBuffer();
		sb.append(entry.getKey());
		sb.append(DELIM);
		for (Long runtime : entry.getValue()) {
			sb.append(runtime);
			sb.append(DELIM);
		}
		System.out.println(sb);
	}
}
