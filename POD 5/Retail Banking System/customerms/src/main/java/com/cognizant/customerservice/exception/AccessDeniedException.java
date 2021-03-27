package com.cognizant.customerservice.exception;

public class AccessDeniedException extends RuntimeException{

	/**
	 * 		Access Denied Exception
	 */
	private static final long serialVersionUID = 895616911464801474L;

	public AccessDeniedException() {
		super();
	}

	public AccessDeniedException(String message) {
		super(message);
	}

	
	
}
