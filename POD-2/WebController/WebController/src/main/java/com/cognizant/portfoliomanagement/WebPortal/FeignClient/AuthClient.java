package com.cognizant.portfoliomanagement.WebPortal.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.portfoliomanagement.WebPortal.Model.AuthResponse;
import com.cognizant.portfoliomanagement.WebPortal.Model.UserData;



@FeignClient(name = "authorization-service", url = "ec2-13-233-193-246.ap-south-1.compute.amazonaws.com")
public interface AuthClient {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserData login(@RequestBody UserData userlogincredentials);

	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);

}
		