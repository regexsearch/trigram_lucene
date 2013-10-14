package de.abrandl.regex.query;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringSetTest {

	@Test
	public void unionOfSet() {
		StringSet a = new StringSet("a", "b");
		StringSet b = new StringSet("b", "c");

		assertStringsEqual(a.union(b), "a", "b", "c");
	}

	@Test
	public void joinOfSet() {
		StringSet a = new StringSet("a", "b");
		StringSet b = new StringSet("b", "c");
		assertStringsEqual(a.join(b), "ab", "bb", "ac", "bc");
	}

	@Test
	public void unionShouldPreserveNullElement() {
		StringSet a = new StringSet("a", "b");
		StringSet b = new StringSet("b", null);

		assertStringsEqual(a.union(b), "a", "b", null);
	}

	private void assertStringsEqual(StringSet set, String... strings) {
		Set<String> expected = new HashSet<>(Arrays.asList(strings));
		assertThat(set.getStrings(), equalTo(expected));
	}
}
