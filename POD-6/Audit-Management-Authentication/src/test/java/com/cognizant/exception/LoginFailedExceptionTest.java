package com.cognizant.exception;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *
 *
 */

@RunWith(SpringRunner.class)
@ContextConfiguration @Slf4j
public class LoginFailedExceptionTest {

	/**
	 * to test the LoginFailedException Exception
	 * 
	 */
	@Mock
	Environment env;
	@Test
	public void testInvalidAuthorizationException() {
		log.info(env.getProperty("string.start"));
		LoginFailedException loginFailedException = new LoginFailedException(env.getProperty("string.not.valid"));
		assertNotNull(loginFailedException);
		log.info(env.getProperty("string.end"));

	}


}
