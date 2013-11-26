package de.abrandl.regex.helpers;

public class Timer {

	private long start;
	private boolean running = false;
	private long sum = 0L;

	public boolean isRunning() {
		return running;
	}

	public void start() {
		if (isRunning()) {
			throw new IllegalStateException("already running");
		}
		start = System.currentTimeMillis();
		running = true;
	}

	public long stop() {
		if (!isRunning()) {
			throw new IllegalStateException("not running");
		}
		sum += System.currentTimeMillis() - start;
		running = false;
		return sum;
	}

	public long getSum() {
		return sum;
	}

	public void reset() {
		start = 0L;
		sum = 0L;
		running = false;
	}

}
