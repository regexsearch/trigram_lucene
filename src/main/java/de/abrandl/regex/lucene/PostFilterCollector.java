package de.abrandl.regex.lucene;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.AtomicReaderContext;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.Scorer;

import de.abrandl.regex.helpers.DetailsCollector;
import de.abrandl.regex.helpers.Timer;
import static com.google.common.base.Preconditions.checkNotNull;

public class PostFilterCollector extends Collector {

	public interface MatchCollector {
		void collect(Document doc);
	}

	private final String field;
	private final Pattern pattern;

	private AtomicReaderContext context;
	private final List<Integer> candidates = new LinkedList<Integer>();
	private final MatchCollector collector;

	private int candidateCounter = 0;

	private final Timer timer = new Timer();

	public PostFilterCollector(String field, Pattern pattern, MatchCollector collector) {
		this.field = checkNotNull(field);
		this.pattern = checkNotNull(pattern);
		this.collector = checkNotNull(collector);
	}

	@Override
	public void setScorer(Scorer scorer) throws IOException {
		// not needed here
	}

	public void finish() throws IOException {
		verifyCandidates(); // verify candidates of last segment
		System.out.printf("candidates: %d\n", candidateCounter);
		System.out.printf("candidate verification took %d ms\n", timer.getSum());

		DetailsCollector.instance.put("candidate_count", candidateCounter);
		DetailsCollector.instance.put("candidate_verification_time", timer.getSum());
	}

	private void verifyCandidates() throws IOException {
		timer.start();
		for (Integer doc : candidates) {
			Document document = context.reader().document(doc);

			String content = document.get(field);
			if (pattern.matcher(content).find()) {
				// document qualifies
				collector.collect(document);
			}
		}
		candidates.clear();
		timer.stop();
	}

	@Override
	public void collect(int doc) throws IOException {
		candidates.add(doc);
		candidateCounter++;
	}

	@Override
	public void setNextReader(AtomicReaderContext context) throws IOException {
		if (this.context != null) {
			verifyCandidates(); // verify candidates of last segment - we need
								// the old context for this
		}
		this.context = context;
	}

	@Override
	public boolean acceptsDocsOutOfOrder() {
		return true;
	}

}
