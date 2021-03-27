package com.cognizant.exception;

import io.jsonwebtoken.ExpiredJwtException;

public class TokenExpiredException extends ExpiredJwtException{

	/**
	  This class is used for handling exception. When the token
	 *          expires then this exception will be thrown. Here we are
	 *          extending {@link RuntimeException} which is an unchecked exception
	 *
	 */
	private static final long serialVersionUID = 1L;
	public TokenExpiredException(String message)
	{
		super(null, null, message);
	}
}
