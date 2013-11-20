package de.abrandl.regex.helpers;

public class Timer {

	private Long start;

	public void start() {
		if (start != null) {
			throw new IllegalStateException("already running");
		}
		start = System.currentTimeMillis();
	}

	public long stop() {
		if (start == null) {
			throw new IllegalStateException("not running");
		}
		long runtime = System.currentTimeMillis() - start;
		return runtime;
	}

	public void reset() {
		start = null;
	}

}
