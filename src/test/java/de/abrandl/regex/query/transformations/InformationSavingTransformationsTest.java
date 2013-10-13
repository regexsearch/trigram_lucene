package de.abrandl.regex.query.transformations;


import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import de.abrandl.regex.query.NGramExtractor;
import de.abrandl.regex.query.RegexInfo;
import de.abrandl.regex.query.RegexInfoTransformation;
import de.abrandl.regex.query.StringSet;
import de.abrandl.regex.query.bool.Expression;
import de.abrandl.regex.query.transformations.ExactToMatchTransformation;
import de.abrandl.regex.query.transformations.PrefixToMatchTransformation;
import de.abrandl.regex.query.transformations.SuffixToMatchTransformation;

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
		when(prefix.isKnown()).thenReturn(true);

		RegexInfoTransformation transformation = new PrefixToMatchTransformation(extractor);
		RegexInfo result = transformation.transform(info);

		verify(match).and(trigrams);
		assertThat(result.getMatch(), equalTo(newMatch));
		assertStringSetsUnchanged(result);
	}

	@Test
	public void ignoresPrefixIfUnknown() {
		when(prefix.isKnown()).thenReturn(false);

		RegexInfoTransformation transformation = new PrefixToMatchTransformation(extractor);
		RegexInfo result = transformation.transform(info);

		assertThat(result.getMatch(), equalTo(match));
		assertStringSetsUnchanged(result);
	}

	@Test
	public void appendsSuffixInfoToMatchExpression() {
		when(extractor.ngrams(suffix)).thenReturn(trigrams);
		when(match.and(trigrams)).thenReturn(newMatch);
		when(suffix.isKnown()).thenReturn(true);

		RegexInfoTransformation transformation = new SuffixToMatchTransformation(extractor);
		RegexInfo result = transformation.transform(info);

		verify(match).and(trigrams);
		assertThat(result.getMatch(), equalTo(newMatch));
		assertStringSetsUnchanged(result);
	}

	@Test
	public void ignoresSuffixIfUnknown() {
		when(suffix.isKnown()).thenReturn(false);

		RegexInfoTransformation transformation = new SuffixToMatchTransformation(extractor);
		RegexInfo result = transformation.transform(info);

		assertThat(result.getMatch(), equalTo(match));
		assertStringSetsUnchanged(result);
	}

	@Test
	public void appendsExactInfoToMatchExpression() {
		when(extractor.ngrams(exact)).thenReturn(trigrams);
		when(match.and(trigrams)).thenReturn(newMatch);
		when(exact.isKnown()).thenReturn(true);

		RegexInfoTransformation transformation = new ExactToMatchTransformation(extractor);
		RegexInfo result = transformation.transform(info);

		verify(match).and(trigrams);
		assertThat(result.getMatch(), equalTo(newMatch));
		assertStringSetsUnchanged(result);
	}

	@Test
	public void ignoresExactIfUnknown() {
		when(exact.isKnown()).thenReturn(false);

		RegexInfoTransformation transformation = new ExactToMatchTransformation(extractor);
		RegexInfo result = transformation.transform(info);

		assertThat(result.getMatch(), equalTo(match));
		assertStringSetsUnchanged(result);
	}

	private void assertStringSetsUnchanged(RegexInfo result) {
		assertThat(result.getPrefix(), equalTo(prefix));
		assertThat(result.getSuffix(), equalTo(suffix));
		assertThat(result.getExact(), equalTo(exact));
	}

}
