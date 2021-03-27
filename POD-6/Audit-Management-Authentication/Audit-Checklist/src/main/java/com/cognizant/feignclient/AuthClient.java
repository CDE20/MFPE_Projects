package com.cognizant.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import com.cognizant.pojo.AuthResponse;

/**
 * 
 *
 * 			This class communicates with Auth microservice to verify the
 *          token. 
 *          Interface to call methods of another Auth microservice 
 *          using Feign client With provided URL and name of microservice it 
 *          interact with that microservice.
 *
 */



@FeignClient(url = "${fos.auth}", name = "audit-auth")
public interface AuthClient {
	
	/**
	 * 
	 * @param String token
	 * @return AuthResponse
	 * This method interact with method from other microservice with method mapping
	 *  given as parameter i.e. Get and with path provided.
	 *  To verify token String token is provided.
	 */
	
	@GetMapping(value = "/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String token) ;


}

	
