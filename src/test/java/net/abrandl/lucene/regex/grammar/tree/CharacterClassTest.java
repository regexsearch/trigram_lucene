package net.abrandl.lucene.regex.grammar.tree;

import static net.abrandl.test.Helpers.asSet;
import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

public class CharacterClassTest {

	@Test
	public void enumerateCharacters() {
		CharacterRange[] ranges = new CharacterRange[] { new CharacterRange(
				'a', 'c') };
		CharacterClass cclass = new CharacterClass(ranges);
		Collection<Character> result = cclass.enumerateCharacters();

		assertEquals(asSet('a', 'b', 'c'), result);
	}

}
