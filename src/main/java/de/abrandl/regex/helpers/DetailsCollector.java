package de.abrandl.regex.helpers;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collection;

import org.json.JSONWriter;

public enum DetailsCollector {

	instance();

	private ByteArrayOutputStream baos;
	private PrintWriter printWriter;
	private JSONWriter object;

	private DetailsCollector() {
		reset();

		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {
				flush(System.out);
			}

		});
	}

	private void reset() {
		baos = new ByteArrayOutputStream();
		printWriter = new PrintWriter(baos);
		object = new JSONWriter(printWriter).object();
	}

	public void put(String key, String value) {
		object.key(key).value(value);
	}

	public void put(String key, Integer value) {
		object.key(key).value(value);
	}

	public void put(String key, Long value) {
		object.key(key).value(value);
	}

	public void put(String key, Collection<? extends Object> values) {
		object.key(key).array();
		for (Object s : values) {
			object.value(s.toString());
		}
		object.endArray();
	}

	public void flush(PrintStream out) {
		object.endObject();
		printWriter.flush();

		out.println(String.format("benchmark: %s", baos.toString()));
		out.flush();

		reset();
	}

}
