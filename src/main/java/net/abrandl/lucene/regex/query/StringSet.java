package net.abrandl.lucene.regex.query;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringSet implements Iterable<String> {

	private final Set<String> strings;

	private static Set<String> toSet(String... strings) {
		Set<String> set = new HashSet<String>();
		for (String s : strings) {
			set.add(s);
		}
		return set;
	}

	public StringSet(Set<String> strings) {
		this.strings = Collections.unmodifiableSet(strings);
	}

	public StringSet(String... strings) {
		this(toSet(strings));
	}

	public StringSet() {
		this.strings = Collections.emptySet();
	}

	public Set<String> getStrings() {
		return strings;
	}

	@Override
	public Iterator<String> iterator() {
		return strings.iterator();
	}

	public StringSet union(StringSet other) {
		Set<String> union = new HashSet<String>(getStrings().size() + other.getStrings().size(), 1);
		union.addAll(this.getStrings());
		union.addAll(other.getStrings());
		return new StringSet(union);
	}

	public StringSet join(StringSet other) {
		Set<String> join = new HashSet<String>(getStrings().size() * other.getStrings().size(), 1);
		for (String outer : getStrings()) {
			for (String inner : other.getStrings()) {
				join.add(outer + inner);
			}
		}
		return new StringSet(join);
	}

}
