package net.abrandl.lucene;

import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.ngram.NGramTokenizer;
import org.apache.lucene.util.Version;

public class NGramAnalyzer extends Analyzer {

	private final int minGram;
	private final int maxGram;
	private final Version luceneVersion;

	public NGramAnalyzer(Version luceneVersion, int minGram, int maxGram) {
		super();
		this.luceneVersion = luceneVersion;
		this.minGram = minGram;
		this.maxGram = maxGram;
	}

	public NGramAnalyzer(Version luceneVersion) {
		this(luceneVersion, 3, 3);
	}

	@Override
	protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
		return new TokenStreamComponents(new NGramTokenizer(luceneVersion, reader, minGram, maxGram));
	}

}
