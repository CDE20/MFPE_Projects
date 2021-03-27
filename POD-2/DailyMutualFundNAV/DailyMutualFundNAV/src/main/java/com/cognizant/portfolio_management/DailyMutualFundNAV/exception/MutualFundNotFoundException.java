package com.cognizant.portfolio_management.DailyMutualFundNAV.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MutualFundNotFoundException extends Exception {
	public MutualFundNotFoundException(String message)
	{
		super(message);
	}
}
