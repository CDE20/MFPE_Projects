package com.cts.benchmark.pojo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * @version 1.8 
 * 			This class we are using as a response of error handling message.
 *          In the {@link GlobalErrorHandler} class we are using this
 *          {@link CustomErrorResponse} class as a return type that will be
 *          shown to the client whenever any kind of exception occurs. The
 *          fields of this class will be used to show this kind of response.
 */

@RunWith(SpringRunner.class)
@ContextConfiguration @Slf4j
public class CustomErrorResponseTest {

	/**
	 * to test the no param constructor of CustomErrorResponse
	 */
	@Mock
	Environment env;
	@Test
	public void testCustomErrorResponse() {
		log.info(env.getProperty("string.start"));

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		assertNotNull(customErrorResponse);
	}
	/**
	 * to test the all param constructor of CustomErrorResponse
	 */

	@Test
	public void testCustomErrorResponseParameterized() {
		log.info(env.getProperty("string.start"));

		CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK,
				"Message","reason");
		assertNotNull(customErrorResponse);
		log.info(env.getProperty("string.end"));

	}
	 /**
     * to test the ToStringMethod
     */
	@Test
	public void testToStringMethod() {
		log.info(env.getProperty("string.start"));

		CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK,
				"Message","reason");
		assertEquals(customErrorResponse.toString(), customErrorResponse.toString());
		log.info(env.getProperty("string.end"));

	}

	
	@Test
	public void testGetStatus() {
		log.info(env.getProperty("string.start"));

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.OK);
		assertEquals(HttpStatus.OK, customErrorResponse.getStatus());
		log.info(env.getProperty("string.end"));

	}
	/**
	    * to test the getter setter of message
	    */
	@Test
	public void testGetMessage() {
		log.info(env.getProperty("string.start"));

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setMessage("Message");
		assertEquals("Message", customErrorResponse.getMessage());
		log.info(env.getProperty("string.end"));

	}
	/**
	    * to test the getter setter of LocalDateTime
	    */
	@Test
	public void testSetLocalDateTime() {
		log.info(env.getProperty("string.start"));

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setTimestamp(LocalDateTime.now());
		log.info(env.getProperty("string.end"));

	}
	  /**
	   *  to test the getter setter of Status
	   */
	@Test
	public void testSetStatus() {
		log.info(env.getProperty("string.start"));

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.OK);
		log.info(env.getProperty("string.end"));

	}
	/**
	  *  to test the getter setter of message
	  */
	@Test
	public void testSetMessage() {
		log.info(env.getProperty("string.start"));

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setMessage("Message");
		log.info(env.getProperty("string.end"));

	}

}
