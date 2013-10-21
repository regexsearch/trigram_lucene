package de.abrandl.regex.grammar.tree;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RegexNodeVisitorTypeCollector implements RegexNodeVisitor<Collection<Class<? extends RegexNode>>> {

	private final Set<Class<? extends RegexNode>> types;

	public RegexNodeVisitorTypeCollector() {
		types = new HashSet<Class<? extends RegexNode>>();
	}

	private Collection<Class<? extends RegexNode>> addAndReturn(RegexNode node) {
		types.add(node.getClass());
		for (RegexNode child : node.getChildren()) {
			addAndReturn(child);
		}
		return types;
	}

	@Override
	public Collection<Class<? extends RegexNode>> visit(Literal literal) {
		return addAndReturn(literal);
	}

	@Override
	public Collection<Class<? extends RegexNode>> visit(Alternative alternative) {
		return addAndReturn(alternative);
	}

	@Override
	public Collection<Class<? extends RegexNode>> visit(ZeroOrMore zeroOrMore) {
		return addAndReturn(zeroOrMore);
	}

	@Override
	public Collection<Class<? extends RegexNode>> visit(Optional optional) {
		return addAndReturn(optional);
	}

	@Override
	public Collection<Class<? extends RegexNode>> visit(Concatenation concatenation) {
		return addAndReturn(concatenation);
	}

	@Override
	public Collection<Class<? extends RegexNode>> visit(MatchGroup matchGroup) {
		return addAndReturn(matchGroup);
	}

	@Override
	public Collection<Class<? extends RegexNode>> visit(OneOrMore oneOrMore) {
		return addAndReturn(oneOrMore);
	}

	@Override
	public Collection<Class<? extends RegexNode>> visit(DotAny dotAny) {
		return addAndReturn(dotAny);
	}

	@Override
	public Collection<Class<? extends RegexNode>> visit(CharacterClass characterClass) {
		return addAndReturn(characterClass);
	}

	@Override
	public Collection<Class<? extends RegexNode>> visit(CharacterRange characterRange) {
		return addAndReturn(characterRange);
	}

	@Override
	public Collection<Class<? extends RegexNode>> visit(Empty empty) {
		return addAndReturn(empty);
	}

}
