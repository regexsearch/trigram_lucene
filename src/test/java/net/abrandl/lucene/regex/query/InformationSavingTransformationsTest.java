package net.abrandl.lucene.regex.query;

import net.abrandl.lucene.regex.query.bool.Expression;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class InformationSavingTransformationsTest {

	@Mock
	private NGramExtractor extractor;

	@Mock
	private StringSet exact, prefix, suffix;

	@Mock
	private Expression match, trigrams, newMatch;

	private RegexInfo info;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(InformationSavingTransformationsTest.class);
		info = new RegexInfo(false, exact, prefix, suffix, match);
	}

	@Test
	public void appendsPrefixInfoToMatchExpression() {
		when(extractor.ngrams(prefix)).thenReturn(trigrams);
		when(match.and(trigrams)).thenReturn(newMatch);

		QueryTransformation transformation = new PrefixToMatchTransformation(extractor);
		RegexInfo result = transformation.transform(info);

		verify(match).and(trigrams);
		assertThat(result.getMatch(), equalTo(newMatch));
		assertStringSetsUnchanged(result);
	}

	@Test
	public void appendsSuffixInfoToMatchExpression() {
		when(extractor.ngrams(suffix)).thenReturn(trigrams);
		when(match.and(trigrams)).thenReturn(newMatch);

		QueryTransformation transformation = new SuffixToMatchTransformation(extractor);
		RegexInfo result = transformation.transform(info);

		verify(match).and(trigrams);
		assertThat(result.getMatch(), equalTo(newMatch));
		assertStringSetsUnchanged(result);
	}

	@Test
	public void appendsExactInfoToMatchExpression() {
		when(extractor.ngrams(exact)).thenReturn(trigrams);
		when(match.and(trigrams)).thenReturn(newMatch);

		QueryTransformation transformation = new ExactToMatchTransformation(extractor);
		RegexInfo result = transformation.transform(info);

		verify(match).and(trigrams);
		assertThat(result.getMatch(), equalTo(newMatch));
		assertStringSetsUnchanged(result);
	}

	private void assertStringSetsUnchanged(RegexInfo result) {
		assertThat(result.getPrefix(), equalTo(prefix));
		assertThat(result.getSuffix(), equalTo(suffix));
		assertThat(result.getExact(), equalTo(exact));
	}

}
