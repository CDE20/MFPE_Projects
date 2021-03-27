package com.returnordermanag.authorizationService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.returnordermanag.authorizationService.exception.BadCredentialException;
import com.returnordermanag.authorizationService.model.AuthenticationRequest;
import com.returnordermanag.authorizationService.model.AuthenticationResponse;
import com.returnordermanag.authorizationService.service.JwtUtil;
import com.returnordermanag.authorizationService.service.MyUserDetailsService;
import com.returnordermanag.authorizationService.service.ValidateService;


@RestController
public class AuthenticationController {

	static Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private ValidateService validateService;
	

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws BadCredentialException {

		logger.info("Creating token");
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new BadCredentialException();
		}



		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt,true));
	}
	
	
	  @GetMapping("/validate") 
	  public AuthenticationResponse getValidity(@RequestHeader("Authorization") final String token) {
		  
			logger.info("Validating");
	  
		  return validateService.validate(token); 
	  }
	 

}
	

