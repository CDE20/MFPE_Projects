package com.cognizant.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.exception.LoginFailedException;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.ProjectManager;
import com.cognizant.model.UserCredentials;
import com.cognizant.repository.ManagerRepository;
import com.cognizant.service.JwtUtil;
import com.cognizant.service.ManagerDetailsService;

import lombok.extern.slf4j.Slf4j;
/**
 *  This class contains test cases for the AuthController
 *         class which are written using Junit and Mockito
 */
@RunWith(SpringRunner.class) @Slf4j
public class AuthControllerTest {

	@InjectMocks
	AuthController authController;

	AuthResponse authResponse;

	UserDetails userdetails;

	@Mock
	JwtUtil jwtutil;

	@Mock
	ManagerDetailsService managerdetailservice;

	@Mock
	ManagerRepository managerservice;
	
	@Mock
	Environment env;
	/**
	 * This method is used to check the credentials whether the provided credentials
	 * are correct or not. For this we will call authenticate method. If user
	 * credentials are correct then we will fetch the data from database based on
	 * userId and return it to the user with a token
	 * */
	@Test
	public void healthTest() {
		ResponseEntity<?> health=authController.healthCheckup();
		assertEquals(200 , health.getStatusCodeValue());
	}

	@Test
	public void loginTest() throws Exception {
		
		UserCredentials user = new UserCredentials("admin", "admin");
		
		UserDetails loadUserByUsername = managerdetailservice.loadUserByUsername("admin");
		UserDetails value = new User(user.getUserId(), user.getPassword(), new ArrayList<>());
		
		when(managerdetailservice.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		
		ResponseEntity<?> login = authController.login(user);
		assertEquals( 200 , login.getStatusCodeValue() );
	}
	/**
     * to test the token validity
    */
	@Test(expected = LoginFailedException.class)
	public void invalidLoginTest() throws LoginFailedException, Exception {

		UserCredentials user = new UserCredentials("admin", "admin");
		UserDetails loadUserByUsername = managerdetailservice.loadUserByUsername("admin");
		UserDetails value = new User(user.getUserId(), "admin11", new ArrayList<>());
		when(managerdetailservice.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		when(authController.login(user)).thenThrow(new LoginFailedException());
	}

	@Test
	public void validateTestValidtoken() {

		log.info(env.getProperty("string.start"));

		when(jwtutil.validateToken("token")).thenReturn(true);
		when(jwtutil.extractUsername("token")).thenReturn("admin");
		ProjectManager user1 = new ProjectManager("admin", "admin", "admin");
		Optional<ProjectManager> data = Optional.of(user1);
		when(managerservice.findById("admin")).thenReturn(data);
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals(validity.getBody().toString().contains("true"), true);
		log.info(env.getProperty("string.end"));

	}

	@Test
	public void validateTestInValidtoken() {
		when(jwtutil.validateToken("token")).thenReturn(false);
		ResponseEntity<?> validity = authController.getValidity("bearer token");
		assertEquals( true ,  validity.getBody().toString().contains("false") );
	}
}
