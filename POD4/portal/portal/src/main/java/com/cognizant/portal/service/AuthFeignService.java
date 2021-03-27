package com.cognizant.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.portal.feign.AuthenticationFeignClient;
import com.cognizant.portal.model.UserLoginCredential;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class AuthFeignService {

	@Autowired
	private AuthenticationFeignClient authclient;


	public ResponseEntity<?> getToken(UserLoginCredential usercredentials) {
		log.debug("userCredentials{}:", usercredentials);
		return authclient.login(usercredentials);
	}

}