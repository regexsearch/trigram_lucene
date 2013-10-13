package de.abrandl.regex.grammar;

public class RegexParsingException extends Exception {

	private static final long serialVersionUID = 2438749667894366906L;

	public RegexParsingException() {
	}

	public RegexParsingException(String message) {
		super(message);
	}

	public RegexParsingException(Throwable cause) {
		super(cause);
	}

	public RegexParsingException(String message, Throwable cause) {
		super(message, cause);
	}

	public RegexParsingException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
