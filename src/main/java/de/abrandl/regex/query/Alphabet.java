package de.abrandl.regex.query;

public enum Alphabet {

	/**
	 * There is only one alphabet used at the moment, which is ASCII_PRINTABLE.
	 */
	ASCII_PRINTABLE;

	public Character[] allCharacters() {
		return enumerateCharacters((char) 32, (char) 126);
	}

	public Character[] enumerateCharacters(char start, char end) {
		Character[] characters = new Character[end - start + 1];
		int index = 0;
		for (char c = start; c <= end; c++) {
			characters[index] = c;
			index++;
		}
		return characters;
	}

}
