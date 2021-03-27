package com.cts.benchmark.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.benchmark.pojo.AuthResponse;


/**
 * 
 * This feign client is used to call methods of  Authentication microservice
 */


@FeignClient(url = "${fos.auth}", name = "audit-auth")
public interface AuthClient {
	
	
	@GetMapping(value = "/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String token) ;


}

	
