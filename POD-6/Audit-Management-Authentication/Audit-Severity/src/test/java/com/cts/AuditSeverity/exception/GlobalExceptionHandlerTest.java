package com.cts.AuditSeverity.exception;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.AuditSeverity.exception.FeignProxyException;
import com.cts.AuditSeverity.exception.GlobalExceptionHandler;
import com.cts.AuditSeverity.fiegnclient.CustomErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration @Slf4j
public class GlobalExceptionHandlerTest {

	@InjectMocks
	GlobalExceptionHandler handler;
	@Mock
	CustomErrorResponse response;
	@Mock
	Environment env;
	
	@Test
	public void contextLoads() {
		assertNotNull(handler);
	}
	
	@Test
	public void testhandelWrongDateFormateException() {
		assertNotNull(handler.handelFeignProxyException(new FeignProxyException()));
	}
	
}
