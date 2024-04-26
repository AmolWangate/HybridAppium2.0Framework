package com.test.customexceptions;

public class InvalidDriverTypeException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1980460671455109241L;

	public InvalidDriverTypeException(String message) {
		super(message);
	}

	public InvalidDriverTypeException(String message, Throwable cause) {
		super(message, cause);
	}
}
