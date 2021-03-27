package com.returnordermanag.paymentService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="Card not found")
public class CardNotFoundException extends RuntimeException{
	public CardNotFoundException() {
		super("Card Not Found");
	}

}
