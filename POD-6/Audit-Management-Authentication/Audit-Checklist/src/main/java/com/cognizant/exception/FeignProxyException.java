package com.cognizant.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * 
 * This class handles the FeignProxy exception
 * this class extends the Exception class.
 *
 */

public class FeignProxyException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	Environment env;
	
	public FeignProxyException() {
		super();
	}

}
