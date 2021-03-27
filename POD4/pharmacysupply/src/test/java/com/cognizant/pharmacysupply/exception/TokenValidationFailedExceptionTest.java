package com.cognizant.pharmacysupply.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This class contains test cases for the TokenValidationFailedException class which
 * are written using junit and mockito
 * 
 * @author Pod3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenValidationFailedExceptionTest {

	@Mock
	private TokenValidationFailedException tokenValidationFailedException;

	@Test
	public void testOneArgConstructor() {
		TokenValidationFailedException medicineNotFoundException = new TokenValidationFailedException(
				"Token validation failed.");
		assertEquals("Token validation failed.", medicineNotFoundException.getMessage());
	}
	
	@Test
	public void testNoArgsConstructor() {
		TokenValidationFailedException exception = new TokenValidationFailedException();
		assertEquals(null, exception.getMessage());
	}

}
