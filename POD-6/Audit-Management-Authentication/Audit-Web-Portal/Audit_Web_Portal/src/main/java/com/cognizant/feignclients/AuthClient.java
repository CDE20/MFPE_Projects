package com.cognizant.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.cognizant.model.ProjectManager;
import com.cognizant.model.User;


/*
 * This feign client is used to call methods of  Authentication microservice
 */


@FeignClient(url = "${fos.auth}", name = "audit-auth")
public interface AuthClient {
	
	@PostMapping(value = "/login")
	public ResponseEntity<ProjectManager> login(@RequestBody User userlogincredentials);

	
	@GetMapping(value = "/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) ;


}

	
