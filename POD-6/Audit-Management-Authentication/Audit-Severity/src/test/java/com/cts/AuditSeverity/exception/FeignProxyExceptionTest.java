package com.cts.AuditSeverity.exception;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.AuditSeverity.exception.FeignProxyException;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration @Slf4j
public class FeignProxyExceptionTest {

	/**
	 * to test the FeignProxyException
	 * 
	 */
	@Mock
	Environment env;
	@Test
	public void testInvalidAuthorizationException() {
		log.info(env.getProperty("string.start"));
		FeignProxyException feignProxyException = new FeignProxyException();
		assertNotNull(feignProxyException);
		log.info(env.getProperty("string.end"));

	}
}
