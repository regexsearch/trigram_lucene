package net.abrandl.lucene.regex;

public class SearchFailedException extends Exception {

	private static final long serialVersionUID = 8136794735164170869L;

	public SearchFailedException() {
		super();
	}

	public SearchFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SearchFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public SearchFailedException(String message) {
		super(message);
	}

	public SearchFailedException(Throwable cause) {
		super(cause);
	}
}
