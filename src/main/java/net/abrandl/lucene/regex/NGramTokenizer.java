package net.abrandl.lucene.regex;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

public class NGramTokenizer {

	private final int gramSize;

	public NGramTokenizer(int gramSize) {
		checkArgument(gramSize >= 1, "gramSize is expected to be greater than zero");
		this.gramSize = gramSize;
	}

	public NGramTokenizer() {
		this(3);
	}

	public Set<String> tokenize(String input) {
		Set<String> ngrams = new HashSet<String>(input.length() / 2);

		int beginIndex = 0;

		while (beginIndex < input.length() - gramSize + 1) {
			String ngram = input.substring(beginIndex, beginIndex + gramSize);
			ngrams.add(ngram);
			beginIndex++;
		}

		return ngrams;
	}
}
