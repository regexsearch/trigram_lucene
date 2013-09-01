package net.abrandl.lucene.regex.grammar.tree;

import java.util.Collection;

public class RegexNodeVisitorToStringTree implements RegexNodeVisitor<StringBuilder> {

	private StringBuilder builder = new StringBuilder();
	private int level = 0;

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
		return append(String.format("'- %s  (%s)\n", type, chars));
	}

	private void nest() {
		for (int i = 0; i <= level; i++) {
			builder.append(" ");
		}
	}

	private StringBuilder append(String type, Collection<RegexNode> children) {
		append(String.format("- %s\n", type));
		for (RegexNode e : children) {
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
		return append("Alternative", alternative.getChildren());
	}

	@Override
	public StringBuilder visit(ZeroOrMore zeroOrMore) {
		return append("ZeroOrMore", zeroOrMore.getChildren());
	}

	@Override
	public StringBuilder visit(Optional optional) {
		return append("Optional", optional.getChildren());
	}

	@Override
	public StringBuilder visit(Concatenation concatenation) {
		return append("Concatenation", concatenation.getChildren());
	}

	@Override
	public StringBuilder visit(MatchGroup matchGroup) {
		return append("MatchGroup", matchGroup.getChildren());
	}

	@Override
	public StringBuilder visit(OneOrMore oneOrMore) {
		return append("OneOrMore", oneOrMore.getChildren());
	}

	@Override
	public StringBuilder visit(DotAny dotAny) {
		return append("DotAny", dotAny.getChildren());
	}

	@Override
	public StringBuilder visit(CharacterClass characterClass) {
		return append("CharacterClass", characterClass.getChildren());
	}

	@Override
	public StringBuilder visit(CharacterRange characterRange) {
		return append("CharacterRange", characterRange.getChildren());
	}

	@Override
	public StringBuilder visit(Empty empty) {
		return append("Empty", empty.getChildren());
	}

}
