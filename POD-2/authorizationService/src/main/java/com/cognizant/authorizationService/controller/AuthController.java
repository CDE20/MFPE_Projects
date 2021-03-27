package com.cognizant.authorizationService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authorizationService.model.AuthResponse;
import com.cognizant.authorizationService.model.UserData;
import com.cognizant.authorizationService.service.AdminDetailsService;
import com.cognizant.authorizationService.service.JwtUtil;

/**
 * This class is having all the endpoints related to authorization purpose. For
 * getting the token and validating the token this class will be used.
 */
@RestController
public class AuthController {
	private static Logger logger = LoggerFactory.getLogger(AuthController.class);

	/**
	 * This is a private field of type JwtUtil class which provides the
	 * utilities for the token like get token, validate token, expiration time etc.
	 */
	@Autowired
	private JwtUtil jwtutil;
	
	/**
	 * This is a private field of type AdminDetailsService class which is
	 * used to fetch the user credentials from the database
	 */	
	@Autowired
	private AdminDetailsService adminDetailService;

	/**
	 * This method is used to check the login credentials, if there are valid,
	 * by checking against the database.
	 */		

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserData userlogincredentials) {
		logger.info("START");
		final UserDetails userdetails = adminDetailService.loadUserByUsername(userlogincredentials.getUserid());
		String uid = "";
		String generateToken = "";
		if (userdetails.getPassword().equals(userlogincredentials.getUpassword())) {
			uid = userlogincredentials.getUserid();
			generateToken = jwtutil.generateToken(userdetails);
			logger.info(generateToken);
			logger.info("END");
			return new ResponseEntity<>(new UserData(uid, null, null, generateToken), HttpStatus.OK);
		} else {
			logger.info("END - Wrong credentials");
			return new ResponseEntity<>("Not Accesible", HttpStatus.FORBIDDEN);
		}
	}
	
	/**
	 * This method validates the token {see @JwtUtils}
	 * @param token
	 * @return
	 */

	@GetMapping("/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) {
		logger.info("START");

		AuthResponse res = new AuthResponse();
		if (token == null) {
			res.setValid(false);
			logger.info("END - Null Token");

			return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
		} else {
			String token1 = token.substring(7);
			if (jwtutil.validateToken(token1)) {
				res.setUid(jwtutil.extractUsername(token1));
				res.setValid(true);
				res.setName("admin");
			} else {
				res.setValid(false);
				logger.info("END - Token expired");

				return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);

			}
		}
		logger.info("END - Token accepted");

		return new ResponseEntity<>(res, HttpStatus.OK);

	}

}
