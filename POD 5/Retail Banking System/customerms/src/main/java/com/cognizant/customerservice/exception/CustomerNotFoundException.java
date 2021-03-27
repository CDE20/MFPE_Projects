package com.cognizant.customerservice.exception;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 *    Customer Not Found Exception
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
		super();
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}

}
