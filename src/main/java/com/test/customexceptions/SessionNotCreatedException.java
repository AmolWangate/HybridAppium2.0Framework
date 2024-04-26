package com.test.customexceptions;

public class SessionNotCreatedException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2052783195893406157L;

	public SessionNotCreatedException(String message) {
		super(message);
	}

	public SessionNotCreatedException(String message, Throwable cause) {
		super(message, cause);
	}
}
