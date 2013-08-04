package net.abrandl.lucene.regex.grammar.tree;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CharacterClass extends RegexNode {

	public CharacterClass(CharacterRange... ranges) {
		addChildren(ranges);
	}

	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

	public Collection<Character> enumerateCharacters() {
		Set<Character> chars = new HashSet<Character>();
		for (RegexNode node : getChildren()) {
			CharacterRange range = (CharacterRange) node;
			for (Character c : range.enumerateCharacters()) {
				chars.add(c);
			}
		}
		return chars;
	}

}
