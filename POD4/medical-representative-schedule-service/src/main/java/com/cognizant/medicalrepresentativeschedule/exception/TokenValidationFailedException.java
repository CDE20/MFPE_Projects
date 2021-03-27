package com.cognizant.medicalrepresentativeschedule.exception;

public class TokenValidationFailedException extends Exception {
	private static final long serialVersionUID = 1L;

	public TokenValidationFailedException() {
		super();
	}

	public TokenValidationFailedException(String message) {
		super(message);
	}
}