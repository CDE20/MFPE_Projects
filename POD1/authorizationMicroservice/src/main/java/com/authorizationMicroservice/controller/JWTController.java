package com.authorizationMicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authorizationMicroservice.model.JWTResponse;
import com.authorizationMicroservice.model.User;
import com.authorizationMicroservice.service.CustomUserDetailsService;
import com.authorizationMicroservice.util.JWTUtil;

@RestController
public class JWTController {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	private UserDetails userDetails;

	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody User authenticationRequest) throws Exception {

		// to be deleted
		System.out.println(authenticationRequest.getUsername() + " " + authenticationRequest.getPassword());
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		} catch (UsernameNotFoundException e) {
			//e.printStackTrace();
			throw new Exception("Incorrect username or password", e);
		} catch (BadCredentialsException e) {
			//e.printStackTrace();
			throw new Exception("Incorrect username or password", e);
		}

		userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		String token = jwtUtil.generateToken(userDetails);

		// to be deleted
		System.out.println("JWT Token: " + token);

		return ResponseEntity.ok(new JWTResponse(token));
	}

	@PostMapping("/validate")
	public Boolean validateToken(@RequestBody String token) {
		return jwtUtil.validateToken(token, userDetails);
	}

}
