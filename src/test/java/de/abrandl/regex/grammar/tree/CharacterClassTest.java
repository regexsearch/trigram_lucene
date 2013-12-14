package de.abrandl.regex.grammar.tree;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CharacterClassTest {

	@Test
	public void enumerateCharacters() {
		CharacterClass cclass = new CharacterClass();
		cclass.addChars(new CharacterRange('a', 'c'));
		cclass.addChars(new Literal("z"));

		Collection<Character> chars = cclass.enumerateCharacters();

		assertTrue(chars.contains('a'));
		assertTrue(chars.contains('b'));
		assertTrue(chars.contains('c'));
		assertTrue(chars.contains('z'));

		assertThat(chars.size(), is(4));
	}

	@Test
	public void children() {
		CharacterRange range = new CharacterRange('a', 'c');
		Literal literal = new Literal("z");

		CharacterClass cclass = new CharacterClass();
		cclass.addChars(literal);
		cclass.addChars(range);

		List<RegexNode> children = cclass.getChildren();
		assertTrue(children.contains(range));
		assertTrue(children.contains(literal));
	}
}
