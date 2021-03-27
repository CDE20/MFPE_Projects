package com.cognizant.exception;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration 
public class TokenExpiredExceptionTest {

	@Mock
	TokenExpiredException handler;
	
	@Test
	public void contextLoads() {
		assertNotNull(handler);
	}
	
	@Test 
	public void testConstructor() {
		assertNotNull(new TokenExpiredException("Exception"));
	}
}
