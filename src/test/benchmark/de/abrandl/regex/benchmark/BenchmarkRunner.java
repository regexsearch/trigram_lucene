package de.abrandl.regex.benchmark;

import java.io.IOException;

public class BenchmarkRunner {

	private final Step dropCaches = new DropFilesystemCaches();

	public long execute(Benchmark benchmark) throws BenchmarkException {
		try {
			benchmark.prepare();
			// clears file system caches
			dropCaches.run();

			long time = run(benchmark);

			benchmark.cleanup();

			return time;
		} catch (IOException e) {
			throw new BenchmarkException(e);
		}

	}

	private long run(Benchmark benchmark) throws BenchmarkException, IOException {
		long start = System.currentTimeMillis();
		benchmark.run();
		return System.currentTimeMillis() - start;
	}

}
