package de.abrandl.regex.grammar.tree;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CharacterRangeTest {

	private CharacterRange getRangeFor(char start, char end) {
		return new CharacterRange(start, end);
	}

	@Test
	public void enumerateCharacters() {
		assertArrayEquals(new Character[] { 'a', 'b', 'c', 'd', 'e' },
				getRangeFor('a', 'e').enumerateCharacters());
	}

	@Test
	public void enumerateDigits() {
		assertArrayEquals(new Character[] { '0', '1', '2', '3', '4' },
				getRangeFor('0', '4').enumerateCharacters());
	}

	@Test
	public void enumerateSingleChar() {
		assertArrayEquals(new Character[] { 'b' }, getRangeFor('b', 'b')
				.enumerateCharacters());
	}

}
