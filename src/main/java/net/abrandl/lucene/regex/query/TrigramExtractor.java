package net.abrandl.lucene.regex.query;

import java.util.Iterator;

import net.abrandl.lucene.regex.grammar.tree.*;

public class TrigramExtractor implements RegexNodeVisitor<ExtractionResult> {

	@Override
	public ExtractionResult visit(Literal literal) {
		String chars = literal.getChars();
		if (chars.length() != 1) {
			throw new IllegalArgumentException("assuming literals to be of length 1 here, got length " + chars.length());
		}
		StringSet set = new StringSet(chars);
		return new ExtractionResult(false, set, set, set);
	}

	@Override
	public ExtractionResult visit(Alternative alternative) {

		if (alternative.getChildren().isEmpty()) {
			throw new IllegalArgumentException("expecting children here");
		}

		Iterator<RegexNode> children = alternative.getChildren().iterator();

		boolean emptyable;
		StringSet exact, prefix, suffix;

		{
			ExtractionResult e1 = children.next().accept(this);

			emptyable = e1.isEmptyable();
			exact = e1.getExact();
			prefix = e1.getPrefix();
			suffix = e1.getSuffix();
		}

		while (children.hasNext()) {
			RegexNode child = children.next();

			ExtractionResult r = child.accept(this);

			emptyable = emptyable || r.isEmptyable();

			exact = exact.union(r.getExact());
			prefix = prefix.union(r.getPrefix());
			suffix = suffix.union(r.getSuffix());
		}

		return new ExtractionResult(emptyable, exact, prefix, suffix);
	}

	@Override
	public ExtractionResult visit(ZeroOrMore zeroOrMore) {
		if (zeroOrMore.getChildren().size() != 1) {
			throw new IllegalArgumentException("zeroOrMore should have exactly one element");
		}

		// TODO: interesting, we don't need the child here
		// RegexNode child = zeroOrMore.getFirstChild();
		// ExtractionResult r = child.accept(this);

		boolean emptyable = true;
		StringSet exact = StringSet.unknownSet();
		StringSet prefix = StringSet.emptyStringOnly();
		StringSet suffix = StringSet.emptyStringOnly();

		return new ExtractionResult(emptyable, exact, prefix, suffix);
	}

	@Override
	public ExtractionResult visit(Optional optional) {
		if (optional.getChildren().size() != 1) {
			throw new IllegalArgumentException("zeroOrMore should have exactly one element");
		}

		RegexNode child = optional.getFirstChild();
		ExtractionResult r = child.accept(this);

		boolean emptyable = true;
		StringSet exact = r.getExact().union(new StringSet(""));
		StringSet prefix = new StringSet("");
		StringSet suffix = new StringSet("");

		return new ExtractionResult(emptyable, exact, prefix, suffix);
	}

	@Override
	public ExtractionResult visit(Concatenation concatenation) {
		if (concatenation.getChildren().isEmpty()) {
			throw new IllegalArgumentException("expecting children here");
		}

		Iterator<RegexNode> children = concatenation.getChildren().iterator();

		boolean emptyable;
		StringSet exact, prefix, suffix;

		{
			ExtractionResult e1 = children.next().accept(this);

			emptyable = e1.isEmptyable();
			exact = e1.getExact();
			prefix = e1.getPrefix();
			suffix = e1.getSuffix();
		}

		while (children.hasNext()) {
			RegexNode child = children.next();

			ExtractionResult e2 = child.accept(this);

			if (exact.isKnown()) {
				prefix = exact.join(e2.getPrefix());
			} else if (emptyable) {
				prefix = prefix.union(e2.getPrefix());
			} else {
				// prefix = prefix
				// (prefix stays the same: prefix(e1, e2) = prefix(e1) )
			}

			if (e2.getExact().isKnown()) {
				suffix = suffix.join(e2.getExact());
			} else if (e2.isEmptyable()) {
				suffix = e2.getSuffix().union(suffix); // TODO: order relevant?
														// check what is meant
														// by U operator
			} else {
				suffix = e2.getSuffix();
			}

			if (exact.isKnown() && e2.getExact().isKnown()) {
				exact = exact.join(e2.getExact());
			} else {
				exact = StringSet.unknownSet();
			}

			emptyable = emptyable && e2.isEmptyable();
		}

		return new ExtractionResult(emptyable, exact, prefix, suffix);
	}

	@Override
	public ExtractionResult visit(MatchGroup matchGroup) {
		if (matchGroup.getChildren().size() != 1) {
			throw new IllegalArgumentException("matchGroup should have exactly one element");
		}
		return matchGroup.getFirstChild().accept(this);
	}

	@Override
	public ExtractionResult visit(OneOrMore oneOrMore) {
		if (oneOrMore.getChildren().size() != 1) {
			throw new IllegalArgumentException("oneOrMore should have exactly one element");
		}

		RegexNode child = oneOrMore.getFirstChild();
		ExtractionResult e = child.accept(this);

		boolean emptyable = e.isEmptyable();
		StringSet exact = StringSet.unknownSet();
		StringSet prefix = e.getPrefix();
		StringSet suffix = e.getSuffix();

		return new ExtractionResult(emptyable, exact, prefix, suffix);
	}

	@Override
	public ExtractionResult visit(DotAny dotAny) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExtractionResult visit(CharacterClass characterClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExtractionResult visit(CharacterRange characterRange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExtractionResult visit(Empty empty) {
		boolean emptyable = true;
		StringSet emptyString = StringSet.emptyStringOnly();

		return new ExtractionResult(emptyable, emptyString, emptyString, emptyString);
	}

}
