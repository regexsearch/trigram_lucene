package de.abrandl.test;

import java.util.HashSet;
import java.util.Set;

public final class Helpers {

	private Helpers() {

	}

	@SafeVarargs
	public static <T> Set<T> asSet(T... data) {
		Set<T> set = new HashSet<T>(data.length);
		for (T entry : data) {
			set.add(entry);
		}
		return set;
	}

}
