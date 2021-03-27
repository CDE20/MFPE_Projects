package com.cognizant.exception;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration @Slf4j
public class GlobalErrorHandlerTest {

	@InjectMocks
	GlobalErrorHandler handler;

	@Mock
	Environment env;
	@Test
	public void contextLoads() {
		assertNotNull(handler);
	}
	
	@Test
	public void testhandelWrongDateFormateException() {
		assertNotNull(handler.handleIdNotFoundexception(new LoginFailedException()));
	}
	
	@Test
	public void testhandelWrongDateFormateExceptionThrowable() {
		assertNotNull(handler.handleIdNotFoundexception(new LoginFailedException(new Throwable())));
	}
	
	@Test
	public void testhandelWrongDateFormateExceptionmsg() {
		assertNotNull(handler.handleIdNotFoundexception(new LoginFailedException("message")));
	}
	
	@Test
	public void testhandelWrongDateFormateExceptionmsgThrowable() {
		assertNotNull(handler.handleIdNotFoundexception(new LoginFailedException("msg",new Throwable())));
	}
	
	@Test
	public void testhandelWrongDateFormateExceptionmsgThrowtrue() {
		assertNotNull(handler.handleIdNotFoundexception(new LoginFailedException("msg",new Throwable(),true,true)));
	}
}
