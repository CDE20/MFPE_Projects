package com.pensionManagementSystem.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pensionManagementSystem.model.User;

@FeignClient("AuthorizationService")//, url = "http://localhost:8084/"
public interface AuthorizationMicroserviceClient {

	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody User authenticationRequest) throws Exception;
	
	@PostMapping("/validate")
	public Boolean validateToken(@RequestBody String token);
}
