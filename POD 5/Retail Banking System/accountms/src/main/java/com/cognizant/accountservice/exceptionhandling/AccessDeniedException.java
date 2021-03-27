package com.cognizant.accountservice.exceptionhandling;

public class AccessDeniedException extends RuntimeException {

	/**
	 * Access denied exception
	 */
	private static final long serialVersionUID = 1L;

	public AccessDeniedException() {
		super();
	}

	public AccessDeniedException(String message) {
		super(message);
	}

}
