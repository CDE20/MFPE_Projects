package com.cognizant.authorization.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorResponseTest {
	@Mock
	private ErrorResponse customErrorResponse;

	@Before
	public void setup() {
		
		customErrorResponse = new ErrorResponse();
		customErrorResponse.setStatus(HttpStatus.OK);
		customErrorResponse.setReason("Bad request");
		customErrorResponse.setMessage("Please provide valid value");
		
	}


	@Test
	public void testMedicineStockDetails() throws Exception {
	
		assertEquals(HttpStatus.OK, customErrorResponse.getStatus());
		assertEquals("Bad request", customErrorResponse.getReason());
		assertEquals("Please provide valid value", customErrorResponse.getMessage());
		

	}


	@Test
	public void testAllArgsConstructor() {
		ErrorResponse customErrorResponse = new ErrorResponse(null, HttpStatus.OK, "Bad request",
				"Please provide valid value");
		assertEquals("Bad request", customErrorResponse.getReason());
	}

	@Test
	public void testToStringMethod() {
		
		assertEquals(customErrorResponse.toString(), customErrorResponse.toString());
		
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = customErrorResponse.equals(customErrorResponse);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = customErrorResponse.hashCode();
		assertEquals(hashCode, customErrorResponse.hashCode());
	}

	@Test
	public void testSetterMethod() {
		customErrorResponse.setMessage("Hello");
		customErrorResponse.setReason("BAD REQUEST");
		customErrorResponse.setStatus(HttpStatus.OK);
		customErrorResponse.setTimestamp(null);
		assertEquals("Hello", customErrorResponse.getMessage());
	}

}
