package com.returnordermanag.webPortal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.returnordermanag.webPortal.model.AuthenticationRequest;
import com.returnordermanag.webPortal.model.AuthenticationResponse;


@FeignClient(name = "authenticationFeignClient", url = "http://returnorderauth.ap-south-1.elasticbeanstalk.com:8084/")
public interface AuthenticationFeignClient {

	@PostMapping("/login")
	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest);

}
