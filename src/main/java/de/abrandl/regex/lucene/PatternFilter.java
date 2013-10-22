package de.abrandl.regex.lucene;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.*;
import org.apache.lucene.search.DocIdSet;
import org.apache.lucene.search.Filter;
import org.apache.lucene.util.Bits;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.FixedBitSet;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @deprecated That's not the way to go for verification of the candidate set.
 * 
 *             A filter is applied to all docs within the index, so it should be
 *             very fast. Verification of candidates is slow, thus it should not
 *             be done within a Filter.
 * 
 * @author abrandl
 * 
 */
@Deprecated
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
		// return otherMethodButBuggy(context.reader(), acceptDocs);
		return correctBits(context.reader(), acceptDocs);
	}

	private FixedBitSet otherMethodButBuggy(AtomicReader reader, Bits acceptDocs) throws IOException {
		FixedBitSet bits = new FixedBitSet(reader.maxDoc()); // assume all are
																// invalid

		// TODO: check for live docs

		Terms terms = reader.terms(field);
		TermsEnum termsEnum = terms.iterator(null);
		BytesRef currTerm = termsEnum.next();

		System.out.println(currTerm.utf8ToString());
		System.out.println("--");

		DocsEnum docsEnum = null;

		while (currTerm != null) {
			if (pattern.matcher(currTerm.utf8ToString()).find()) {
				docsEnum = termsEnum.docs(acceptDocs, docsEnum);

				int docID = docsEnum.nextDoc();

				while (docID != DocsEnum.NO_MORE_DOCS) {
					bits.set(docID);
					docID = docsEnum.nextDoc();
				}
			}

			currTerm = termsEnum.next();
		}

		return bits;
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
