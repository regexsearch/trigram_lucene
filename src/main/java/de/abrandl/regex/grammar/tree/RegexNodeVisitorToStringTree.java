package de.abrandl.regex.grammar.tree;

import de.abrandl.regex.query.RegexAnalyzer;
import de.abrandl.regex.query.RegexInfo;

public class RegexNodeVisitorToStringTree implements RegexNodeVisitor<StringBuilder> {

	private StringBuilder builder = new StringBuilder();
	private int level = 0;

	private final RegexAnalyzer analyzer;

	public RegexNodeVisitorToStringTree() {
		analyzer = new RegexAnalyzer();
	}

	public void reset() {
		builder = new StringBuilder();
		level = 0;
	}

	private StringBuilder append(String s) {
		nest();
		builder.append(s);
		return builder;
	}

	private StringBuilder append(String type, String chars) {
		append(String.format("'- '%s'\n", chars));
		return builder;
	}

	private void nest() {
		for (int i = 0; i <= level; i++) {
			builder.append(" ");
		}
	}

	private StringBuilder append(RegexNode parent) {
		RegexInfo info = null;
		if (!(parent instanceof CharacterRange)) {
			info = parent.accept(analyzer);
		}
		append(String.format("- %-15s  %s\n", parent.getClass().getSimpleName(), info));
		for (RegexNode e : parent.getChildren()) {
			level++;
			e.accept(this);
			level--;
		}
		return builder;
	}

	@Override
	public StringBuilder visit(Literal literal) {
		return append("Literal", literal.getChars());
	}

	@Override
	public StringBuilder visit(Alternative alternative) {
		return append(alternative);
	}

	@Override
	public StringBuilder visit(ZeroOrMore zeroOrMore) {
		return append(zeroOrMore);
	}

	@Override
	public StringBuilder visit(Optional optional) {
		return append(optional);
	}

	@Override
	public StringBuilder visit(Concatenation concatenation) {
		return append(concatenation);
	}

	@Override
	public StringBuilder visit(MatchGroup matchGroup) {
		return append(matchGroup);
	}

	@Override
	public StringBuilder visit(OneOrMore oneOrMore) {
		return append(oneOrMore);
	}

	@Override
	public StringBuilder visit(DotAny dotAny) {
		return append(dotAny);
	}

	@Override
	public StringBuilder visit(CharacterClass characterClass) {
		return append(characterClass);
	}

	@Override
	public StringBuilder visit(CharacterRange characterRange) {
		return append(characterRange);
	}

	@Override
	public StringBuilder visit(Empty empty) {
		return append(empty);
	}

}
