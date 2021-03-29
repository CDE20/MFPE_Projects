package com.pensionerDisbursementMicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("authorization-service") //url = "http://localhost:9696/"
public interface AuthorizationServieceClient {
	
	@PostMapping("/validate")
	public Boolean validateToken(@RequestBody String token);
}
