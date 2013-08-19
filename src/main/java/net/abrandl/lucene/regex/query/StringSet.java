package net.abrandl.lucene.regex.query;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class StringSet implements Iterable<String> {

	private final static StringSet emptyString = new StringSet("");
	private final static StringSet emptySet = new StringSet();

	public final static StringSet emptyStringOnly() {
		return emptyString;
	}

	public final static StringSet unknownSet() {
		return emptySet;
	}

	private final Set<String> strings;

	private static Set<String> toSet(String... strings) {
		Set<String> set = new HashSet<String>();
		for (String s : strings) {
			set.add(s);
		}
		return set;
	}

	private StringSet(Set<String> strings) {
		this.strings = Collections.unmodifiableSet(strings);
	}

	public StringSet(String... strings) {
		this(toSet(strings));
	}

	public StringSet() {
		this.strings = Collections.emptySet();
	}

	public boolean isKnown() {
		return !strings.isEmpty();
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

	@Override
	public String toString() {
		return strings.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((strings == null) ? 0 : strings.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringSet other = (StringSet) obj;
		if (strings == null) {
			if (other.strings != null)
				return false;
		} else if (!strings.equals(other.strings))
			return false;
		return true;
	}

}
