package de.abrandl.regex.lucene;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.AtomicReader;
import org.apache.lucene.index.AtomicReaderContext;
import org.apache.lucene.search.DocIdSet;
import org.apache.lucene.search.Filter;
import org.apache.lucene.util.Bits;
import org.apache.lucene.util.FixedBitSet;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class PatternFilter extends Filter {

	private final Pattern pattern;
	private final String field;

	public PatternFilter(Pattern regex, String field) {
		checkArgument(!field.isEmpty());

		this.pattern = checkNotNull(regex);
		this.field = checkNotNull(field);
	}

	public PatternFilter(String regex, String field) {
		this(Pattern.compile(regex), field);
	}

	@Override
	public DocIdSet getDocIdSet(AtomicReaderContext context, Bits acceptDocs) throws IOException {

		return correctBits(context.reader(), acceptDocs);
		// BinaryDocValues binaryDocValues =
		// context.reader().getBinaryDocValues("content");

	}

	private FixedBitSet correctBits(AtomicReader reader, Bits acceptDocs) throws IOException {
		FixedBitSet bits = new FixedBitSet(reader.maxDoc()); // assume all are
																// INvalid

		Bits liveDocs = reader.getLiveDocs();

		Set<String> fieldsToLoad = new HashSet<String>();
		fieldsToLoad.add(field);

		for (int docID = 0; docID < reader.maxDoc(); docID++) {

			if (liveDocs != null && !(liveDocs.get(docID))) {
				// document is not alive anymore...
				continue;
			}

			if (acceptDocs != null && !(acceptDocs.get(docID))) {
				continue;
			}

			Document document = reader.document(docID, fieldsToLoad);
			String content = document.get(field);

			if (content == null) {
				// field is not present
				continue;
			}

			if (pattern.matcher(content).find()) {
				bits.set(docID);
			}

		}

		return bits;
	}

}
