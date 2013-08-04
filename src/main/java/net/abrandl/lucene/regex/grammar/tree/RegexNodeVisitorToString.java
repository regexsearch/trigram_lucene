package net.abrandl.lucene.regex.grammar.tree;

import java.util.Iterator;
import java.util.List;

public class RegexNodeVisitorToString implements
		RegexNodeVisitor<String> {
	@Override
	public String visit(Alternative alternative) {
		return join(alternative.getChildren(), "|");
	}

	private void join(List<RegexNode> nodes, String separator, StringBuilder builder) {
		Iterator<RegexNode> iterator = nodes.iterator();
		while (iterator.hasNext()) {
			RegexNode node = iterator.next();
			String nodeString = node.accept(this);
			builder.append(nodeString);
			
			if (iterator.hasNext()) {
				builder.append(separator);
			}
		}
	}
	
	private String join(List<RegexNode> nodes, String separator) {
		StringBuilder builder = new StringBuilder();
		join(nodes, separator, builder);
		return builder.toString();
	}

	@Override
	public String visit(Literal literal) {
		return literal.getChars();
	}

	@Override
	public String visit(ZeroOrMore zeroOrMore) {
		return String.format("%s*", zeroOrMore.getFirstChild().accept(this));
	}

	@Override
	public String visit(OneOrMore oneOrMore) {
		return String.format("%s+", oneOrMore.getFirstChild().accept(this));
	}

	@Override
	public String visit(Optional optional) {
		return String.format("%s?", optional.getFirstChild().accept(this));
	}
	
	@Override
	public String visit(MatchGroup matchGroup) {
		return String.format("(%s)", join(matchGroup.getChildren(), ""));
	}

	@Override
	public String visit(Concatenation concatenation) {
		return join(concatenation.getChildren(), "");
	}

	@Override
	public String visit(DotAny dotAny) {
		return ".";
	}

	@Override
	public String visit(CharacterClass characterClass) {
		return String.format("[%s]", join(characterClass.getChildren(), ""));
	}

	@Override
	public String visit(CharacterRange characterRange) {
		return String.format("%s-%s", characterRange.getStart(), characterRange.getEnd());
	}
	
}