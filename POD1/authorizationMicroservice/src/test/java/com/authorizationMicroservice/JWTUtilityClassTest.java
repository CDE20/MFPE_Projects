package com.authorizationMicroservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.authorizationMicroservice.repository.LoginRepository;
import com.authorizationMicroservice.util.JWTUtil;

public class JWTUtilityClassTest {

	@Mock
	LoginRepository repository;

	@InjectMocks
	JWTUtil jwtUtil;

	UserDetails userDetails;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		jwtUtil.setSecret("pensionSecret");
	}

	@Test
	public void testLoginRepositoryObjectNotNull() {
		assertNotNull(repository);
	}

	@Test
	public void testJWTUtilObjectNotNull() {
		assertNotNull(jwtUtil);
	}

	@Test
	public void testGenerateToken() {
		userDetails = new User("admin@gmail.com", "password", new ArrayList<>());
		String token = jwtUtil.generateToken(userDetails);
		System.out.println(token);
		assertNotNull(token);
	}

	@Test
	public void testValidateToken() {
		userDetails = new User("admin", "admin", new ArrayList<>());
		String token = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(token, userDetails);
		assertTrue(validateToken);
	}

	@Test
	public void testValidateTokenWithCorrectUserDetails() {
		userDetails = new User("admin", "admin", new ArrayList<>());
		String token = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(token, userDetails);
		assertTrue(validateToken);
	}

	@Test
	public void testValidateTokenWithIncorrectUsername() {
		userDetails = new User("admin", "admin", new ArrayList<>());
		String token = jwtUtil.generateToken(userDetails);
		UserDetails actualUserDetails = new User("hjdc", "hhd", new ArrayList<>());
		Boolean validateToken = jwtUtil.validateToken(token, actualUserDetails);
		assertFalse(validateToken);
	}

	@Test
	public void extractUsernameTest() {
		userDetails = new User("admin", "admin", new ArrayList<>());
		String token = jwtUtil.generateToken(userDetails);
		String username = jwtUtil.getUsernameFromToken(token);
		assertEquals(username, "admin");
	}

}
