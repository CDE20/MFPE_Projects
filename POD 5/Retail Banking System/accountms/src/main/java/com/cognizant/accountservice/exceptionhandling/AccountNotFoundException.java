package com.cognizant.accountservice.exceptionhandling;

public class AccountNotFoundException extends RuntimeException {

	/**
	 *  Account Not Found exception
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
		super();
	}

	public AccountNotFoundException(String message) {
		super(message);
	}
}
