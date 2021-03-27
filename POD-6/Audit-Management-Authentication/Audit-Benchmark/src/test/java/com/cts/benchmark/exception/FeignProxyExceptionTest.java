package com.cts.benchmark.exception;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 
 * This class test the FeignProxyException class
 * 
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
public class FeignProxyExceptionTest{
	
	
	
	@Mock
	FeignProxyException feignProxyException;
	
	@Test
	public void contextLoads() {
		assertNotNull(feignProxyException);
	}
	
	@Test 
	public void testConstructor() {
		
		assertNotNull(new FeignProxyException());
	}

}
