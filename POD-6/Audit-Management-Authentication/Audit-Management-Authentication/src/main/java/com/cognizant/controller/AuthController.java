package com.cognizant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.AuthResponse;
import com.cognizant.model.ProjectManager;
import com.cognizant.model.UserCredentials;
import com.cognizant.service.JwtUtil;
import com.cognizant.service.ManagerDetailsService;
import com.cognizant.exception.LoginFailedException;

import lombok.extern.slf4j.Slf4j;
/**
  This class is having all the endpoints related to authorization
 *          purpose. For getting the token and validating the token this class
 *          willbe used.
 *
 */
@RestController

@Slf4j
public class AuthController {

	/**
	 * This is a private field of type {@link JwtUtil} class which provides the
	 * utilities for the token like get token, validate token, expiration time etc.
	 */
	@Autowired
	private JwtUtil jwtutil;
	/**
	 * This is a private field of type {@link ManagerDetailsService} class which is
	 * used to fetch the user credentials from the database
	 */
	@Autowired
	private ManagerDetailsService managerDetailsService;
	/**
	 * This is used to encrypt password
	 */
	
	@Autowired
	Environment env;

	
	@GetMapping(path = "/health")
	public ResponseEntity<?> healthCheckup() {
		log.info("AWS Health Check");
		return new ResponseEntity<>("Authenticated successfully", HttpStatus.OK);
	}
	/**
	 * This method is used to check the credentials whether the provided credentials
	 * are correct or not. For this we will call authenticate method. If user
	 * credentials are correct then we will fetch the data from database based on
	 * userid and return it to the user with a token
	 * 
	 
	 */
	

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UserCredentials userLoginCredentials) throws Exception{
		log.info(env.getProperty("string.start"));
		log.debug(userLoginCredentials.toString());
				
		final UserDetails userdetails = managerDetailsService.loadUserByUsername(userLoginCredentials.getUserId());

		if (userdetails.getPassword().equals(userLoginCredentials.getPassword())) {
			String token = jwtutil.generateToken(userdetails);
			ProjectManager projectManager = new ProjectManager(userLoginCredentials.getUserId(), userLoginCredentials.getPassword(), token);
			managerDetailsService.saveUser(projectManager);
			log.info(env.getProperty("string.end"));
			return new ResponseEntity<>(
					projectManager,HttpStatus.OK);
		} else {
			log.error(env.getProperty("string.acess.denied"));
			log.info(env.getProperty("string.acess.denied"));
			throw new LoginFailedException(env.getProperty("string.reason.loginfail"));

		}
	}
	/**
	 * 
	
	 */
	@GetMapping(value = "/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token)  {
		token = token.substring(7);
		AuthResponse res = new AuthResponse();
		ResponseEntity<?> response=null;
		log.info(env.getProperty("string.start"));
		log.debug(env.getProperty("string.auth.token"),token);
		try {
				if(jwtutil.validateToken(token)) {
			
				res.setUid(jwtutil.extractUsername(token));
				res.setValid(true);

			}
		}
		catch(Exception e) {
			res.setValid(false);
			log.info(env.getProperty("string.end"));
			if(e.getMessage().contains(env.getProperty("token.expired")))
				response =  new ResponseEntity<String>(env.getProperty("token.expired"),HttpStatus.FORBIDDEN);
			if(e.getMessage().contains(env.getProperty("auth.failed")))
				response = new ResponseEntity<String>(env.getProperty("auth.failed"),HttpStatus.FORBIDDEN);
			response = new ResponseEntity<>(res,HttpStatus.FORBIDDEN);
			return response;
		}
		log.info(env.getProperty("string.end"));
		response = new ResponseEntity<AuthResponse>(res,HttpStatus.OK);
		return response;


	}
	
	
}
