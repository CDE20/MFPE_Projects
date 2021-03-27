package com.cognizant.medicalrepresentative.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.medicalrepresentativeschedule.exception.TokenValidationFailedException;

@SpringBootTest
public class TokenValidationFailedExceptionTest {

	@Mock
	private TokenValidationFailedException tokenNotValid;

	@Test
	public void testOneArgConstructor() {
		TokenValidationFailedException tokenNotValid = new TokenValidationFailedException("Token validaton failed.");
		assertEquals("Token validaton failed.", tokenNotValid.getMessage());
	}

	@Test
	public void testNoArgConstructor() {
		TokenValidationFailedException tokenNotValid = new TokenValidationFailedException();
		assertEquals(null, tokenNotValid.getMessage());
	}
}

