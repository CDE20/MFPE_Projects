package com.cognizant.portfolio_management.DailySharePrice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ShareNotFoundException extends Exception{ 
	
	public ShareNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
