package com.cognizant.portal.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MedicineNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MedicineNotFoundException(String message) {
		super(message);
	}

}
