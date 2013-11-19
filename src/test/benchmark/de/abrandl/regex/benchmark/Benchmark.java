package de.abrandl.regex.benchmark;

import java.io.IOException;

public interface Benchmark {
	void prepare() throws BenchmarkException, IOException;

	void run() throws BenchmarkException, IOException;

	void cleanup() throws BenchmarkException, IOException;
}
