package net.abrandl.lucene.regex.query;

import java.util.Arrays;

import net.abrandl.lucene.regex.NGramTokenizer;
import net.abrandl.lucene.regex.grammar.tree.RegexNode;
import net.abrandl.lucene.regex.query.bool.Expression;
import net.abrandl.lucene.regex.query.bool.NestedExpressionSimplifier;

public class NGramQueryTransformation implements QueryTransformation {

	private final int gramSize;

	public NGramQueryTransformation(int gramSize) {
		this.gramSize = gramSize;
	}

	public NGramQueryTransformation() {
		this(3);
	}

	@Override
	public Expression expressionFor(RegexNode regex) {
		RegexAnalyzer analyzer = createAnalyzer();

		// convert regex to ngram expression
		Expression match = regex.accept(analyzer).getMatch();

		// simplify nested expressions
		return match.accept(new NestedExpressionSimplifier());

	}

	private RegexAnalyzer createAnalyzer() {
		NGramTokenizer tokenizer = new NGramTokenizer(gramSize);
		NGramExtractor extractor = new NGramExtractor(tokenizer);
		RegexInfoTransformation prefixToMatch = new PrefixToMatchTransformation(extractor);
		RegexInfoTransformation suffixToMatch = new SuffixToMatchTransformation(extractor);
		RegexInfoTransformation exactToMatch = new ExactToMatchTransformation(extractor);
		RegexInfoTransformation transformations = new CompositeRegexInfoTransformation(Arrays.asList(exactToMatch,
				prefixToMatch, suffixToMatch));
		RegexAnalyzer analyzer = new RegexAnalyzer(transformations);
		return analyzer;
	}

}
