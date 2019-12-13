package com.meehnia.amazonaws.services.lambda.util;

/**
 * @author Vipul Meehnia <vipulmeehnia@gmail.com>
 *
 */
public class PathParseException extends Exception {

	private static final long serialVersionUID = -7727692353653080129L;

	/**
	 * 
	 */
	public PathParseException() {}

	/**
	 * @param message
	 */
	public PathParseException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PathParseException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PathParseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PathParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
