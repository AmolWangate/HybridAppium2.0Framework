package com.test.customexceptions;

public class InvalidWaitTypeException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7958425333687306634L;

	public InvalidWaitTypeException(String message) {
		super(message);
	}

	public InvalidWaitTypeException(String message, Throwable cause) {
		super(message, cause);
	}
}
