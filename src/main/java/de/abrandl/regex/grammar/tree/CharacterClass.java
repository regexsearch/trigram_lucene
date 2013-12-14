package de.abrandl.regex.grammar.tree;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;

public class CharacterClass extends RegexNode {

	private final Set<Character> chars = new HashSet<Character>();

	public void addChars(CharacterRange range) {
		chars.addAll(Arrays.asList(range.enumerateCharacters()));
		addChild(range);
	}

	public void addChars(Literal literal) {
		checkArgument(literal.getChars().length() == 1, "literal with other than one char");
		chars.add(literal.getChars().charAt(0));
		addChild(literal);
	}

	@Override
	public <A> A accept(RegexNodeVisitor<A> visitor) {
		return visitor.visit(this);
	}

	public Collection<Character> enumerateCharacters() {
		return Collections.unmodifiableCollection(chars);
	}

}
