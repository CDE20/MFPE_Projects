package com.cognizant.service;
/**
 * 			This interface communicates with Auth microservice to check validity of the
 *          token. 
 *          Interface to call methods of another Auth microservice 
 *          using Feign client With provided URL and name of microservice it 
 *          interact with that microservice.
 *
 */
public interface TokenService {
	/**
	 * 
	 * @param token
	 * @return Boolean
	 */
	Boolean checkTokenValidity(String token);

}
