package com.test.customexceptions;

public class InvalidModeException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7213291225201414261L;

	public InvalidModeException(String message) {
		super(message);
	}

	public InvalidModeException(String message, Throwable cause) {
		super(message, cause);
	}
}
