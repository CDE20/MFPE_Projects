package com.cognizant.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.repository.ManagerRepository;

import lombok.extern.slf4j.Slf4j;
/**

 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest @Slf4j
public class JwtUtilTest {
	/**
	 * This method will test the token based on the given parameter userDetails
	 * 
	
	 */
	UserDetails userdetails;
	@Mock
	Environment env;
	
	@InjectMocks
	JwtUtil jwtUtil;
	
	@Mock
	ManagerRepository managerrepositary;

	@Test
	public void generateTokenTest() {
		log.info(env.getProperty("string.start"));
		when(env.getProperty("set.expire.token")).thenReturn("30");
		userdetails = new User("admin", "admin", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userdetails);
		assertNotNull(generateToken);
		log.info(env.getProperty("string.end"));

	}
	/**
	 * This method is used to test the token based on the given token and
	 * userDetails as parameter. First from the token we will extract the username
	 * and then will check in the database whether the token extracted username and
	 * the user residing in database is same or not and also will check whether the
	 * token has been expired or not
	 * 
	
	 */
	@Test
	public void validateTokenTest() {
		log.info(env.getProperty("string.start"));
		userdetails = new User("admin", "admin", new ArrayList<>());
		when(env.getProperty("set.expire.token")).thenReturn("30");
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
		log.info(env.getProperty("string.end"));

	}
	/**
	 * to test the validity of token with name
	 */
	@Test
	public void validateTokenWithNameTest() {
		log.info(env.getProperty("string.start"));
		userdetails = new User("admin", "admin", new ArrayList<>());
		when(env.getProperty("set.expire.token")).thenReturn("30");
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken, userdetails);
		assertEquals(true, validateToken);
		log.info(env.getProperty("string.end"));

	}
	/**
	 * to test the validity of token with falseS name
	 */
	@Test
	public void validateTokenWithNameFalseTest() {
		log.info(env.getProperty("string.start"));
		userdetails = new User("admin", "admin", new ArrayList<>());
		UserDetails user1 = new User("admin1", "admin1", new ArrayList<>());
		when(env.getProperty("set.expire.token")).thenReturn("30");
		String generateToken = jwtUtil.generateToken(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken, user1);
		assertEquals(false, validateToken);
		log.info(env.getProperty("string.end"));
	}

}
