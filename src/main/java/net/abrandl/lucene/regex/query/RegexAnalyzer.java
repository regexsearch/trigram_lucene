package net.abrandl.lucene.regex.query;

import java.util.Collection;
import java.util.Iterator;

import net.abrandl.lucene.regex.grammar.tree.*;
import net.abrandl.lucene.regex.query.bool.Expression;
import static com.google.common.base.Preconditions.checkNotNull;
import static net.abrandl.lucene.regex.query.StringSet.unknownSet;
import static net.abrandl.lucene.regex.query.bool.Expression.any;

class RegexAnalyzer implements RegexNodeVisitor<RegexInfo> {

	private final RegexInfoTransformation transformation;

	public RegexAnalyzer(RegexInfoTransformation transformation) {
		this.transformation = checkNotNull(transformation);
	}

	public RegexAnalyzer() {
		this(new NullQueryTransformation());
	}

	@Override
	public RegexInfo visit(Literal literal) {
		String chars = literal.getChars();
		if (chars.length() != 1) {
			throw new IllegalArgumentException("assuming literals to be of length 1 here, got length " + chars.length());
		}
		StringSet set = new StringSet(chars);
		return createResult(false, set, set, set, any());
	}

	@Override
	public RegexInfo visit(Alternative alternative) {

		if (alternative.getChildren().isEmpty()) {
			throw new IllegalArgumentException("expecting children here");
		}

		Iterator<RegexNode> children = alternative.getChildren().iterator();

		boolean emptyable;
		StringSet exact, prefix, suffix;
		Expression match;

		{
			RegexInfo e1 = children.next().accept(this);

			emptyable = e1.isEmptyable();
			exact = e1.getExact();
			prefix = e1.getPrefix();
			suffix = e1.getSuffix();
			match = e1.getMatch();
		}

		while (children.hasNext()) {
			RegexNode child = children.next();

			RegexInfo e2 = child.accept(this);

			emptyable = emptyable || e2.isEmptyable();

			exact = exact.union(e2.getExact());
			prefix = prefix.union(e2.getPrefix());
			suffix = suffix.union(e2.getSuffix());
			match = match.or(e2.getMatch());
		}

		return createResult(emptyable, exact, prefix, suffix, match);
	}

	@Override
	public RegexInfo visit(ZeroOrMore zeroOrMore) {
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

		return createResult(emptyable, exact, prefix, suffix, any());
	}

	@Override
	public RegexInfo visit(Optional optional) {
		if (optional.getChildren().size() != 1) {
			throw new IllegalArgumentException("zeroOrMore should have exactly one element");
		}

		RegexNode child = optional.getFirstChild();
		RegexInfo r = child.accept(this);

		boolean emptyable = true;
		StringSet exact = r.getExact().union(new StringSet(""));
		StringSet prefix = new StringSet("");
		StringSet suffix = new StringSet("");

		return createResult(emptyable, exact, prefix, suffix, any());
	}

	@Override
	public RegexInfo visit(Concatenation concatenation) {
		if (concatenation.getChildren().isEmpty()) {
			throw new IllegalArgumentException("expecting children here");
		}

		Iterator<RegexNode> children = concatenation.getChildren().iterator();

		boolean emptyable;
		StringSet exact, prefix, suffix;
		Expression match;

		{
			RegexInfo e1 = children.next().accept(this);

			emptyable = e1.isEmptyable();
			exact = e1.getExact();
			prefix = e1.getPrefix();
			suffix = e1.getSuffix();
			match = e1.getMatch();
		}

		while (children.hasNext()) {
			RegexNode child = children.next();

			RegexInfo e2 = child.accept(this);

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

			match = match.and(e2.getMatch());
		}

		return createResult(emptyable, exact, prefix, suffix, match);
	}

	@Override
	public RegexInfo visit(MatchGroup matchGroup) {
		if (matchGroup.getChildren().size() != 1) {
			throw new IllegalArgumentException("matchGroup should have exactly one element");
		}
		return matchGroup.getFirstChild().accept(this);
	}

	@Override
	public RegexInfo visit(OneOrMore oneOrMore) {
		if (oneOrMore.getChildren().size() != 1) {
			throw new IllegalArgumentException("oneOrMore should have exactly one element");
		}

		RegexNode child = oneOrMore.getFirstChild();
		RegexInfo e = child.accept(this);

		boolean emptyable = e.isEmptyable();
		StringSet exact = StringSet.unknownSet();
		StringSet prefix = e.getPrefix();
		StringSet suffix = e.getSuffix();
		Expression match = e.getMatch();

		return createResult(emptyable, exact, prefix, suffix, match);
	}

	private RegexInfo createResult(boolean emptyable, StringSet exact, StringSet prefix, StringSet suffix,
			Expression match) {
		return transform(new RegexInfo(emptyable, exact, prefix, suffix, match));
	}

	private RegexInfo transform(RegexInfo extractionResult) {
		return transformation.transform(extractionResult);
	}

	@Override
	public RegexInfo visit(DotAny dotAny) {
		return createResult(false, unknownSet(), unknownSet(), unknownSet(), any());
	}

	@Override
	public RegexInfo visit(CharacterClass characterClass) {
		Collection<Character> chars = characterClass.enumerateCharacters();
		String[] strings = new String[chars.size()];
		int index = 0;
		for (Character c : chars) {
			strings[index] = c.toString();
			index++;
		}

		StringSet stringSet = new StringSet(strings);
		return createResult(false, stringSet, stringSet, stringSet, any());
	}

	@Override
	public RegexInfo visit(CharacterRange characterRange) {
		throw new UnsupportedOperationException("this should not happen");
	}

	@Override
	public RegexInfo visit(Empty empty) {
		boolean emptyable = true;
		StringSet emptyString = StringSet.emptyStringOnly();

		return createResult(emptyable, emptyString, emptyString, emptyString, any());
	}

}
