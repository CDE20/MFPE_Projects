package com.cognizant.authorizationService.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authorizationService.model.UserData;


@SpringBootTest
@RunWith(SpringRunner.class)
public class JwUtilTest {

	@Autowired(required = true)
	JwtUtil jwtUtil;
	@Autowired
	AdminDetailsService adminDetailService;

	@Test
	public void contextLoads() {

		assertNotNull(jwtUtil);

	}

	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";

	@Test
	public void extractUsernameTestSuccess() {

		assertEquals("admin", jwtUtil.extractUsername(token));
	}

	@Test
	public void generateTokenTestSuccess() {
		UserData userData = new UserData("admin", "admin", "admin", "admin");
		UserDetails userDetails = adminDetailService.loadUserByUsername(userData.getUserid());
		String exampleToken = jwtUtil.generateToken(userDetails);
		assertNotNull(exampleToken);
	}

	@Test(expected = UsernameNotFoundException.class)
	public void generateTokenTestFail() {
		UserData userData = new UserData("randomUser", "randomUser", "randomUser", "randomUser");
		UserDetails userDetails = adminDetailService.loadUserByUsername(userData.getUserid());
		String exampleToken = jwtUtil.generateToken(userDetails);
		assertNull(exampleToken);
	}

	@Test
	public void validateTokenTestSuccess() {
		assertTrue(jwtUtil.validateToken(token));
	}

	@Test
	public void validateTokenTestFail() {
		assertFalse(jwtUtil.validateToken("randomToken"));

	}

}
