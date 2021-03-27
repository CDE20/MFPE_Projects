package com.cognizant.pharmacysupply.model;

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
	private ErrorResponse ErrorResponse;

	@Before
	public void setup() {

		ErrorResponse = new ErrorResponse();
		ErrorResponse.setStatus(HttpStatus.OK);
		ErrorResponse.setReason("Bad request");
		ErrorResponse.setMessage("Please provide valid value");

	}

	@Test
	public void testMedicineStockDetails() throws Exception {

		assertEquals(HttpStatus.OK, ErrorResponse.getStatus());
		assertEquals("Bad request", ErrorResponse.getReason());
		assertEquals("Please provide valid value", ErrorResponse.getMessage());

	}

	@Test
	public void testAllArgsConstructor() {
		ErrorResponse ErrorResponse = new ErrorResponse(null, HttpStatus.OK, "Bad request",
				"Please provide valid value");
		assertEquals("Bad request", ErrorResponse.getReason());
	}

	@Test
	public void testToStringMethod() {

		assertEquals(
				"ErrorResponse(timestamp=" + ErrorResponse.getTimestamp() + ", status=" + ErrorResponse.getStatus()
						+ ", reason=" + ErrorResponse.getReason() + ", message=" + ErrorResponse.getMessage() + ")",
				ErrorResponse.toString());

	}

	@Test
	public void testEqualsMethod() {
		boolean equals = ErrorResponse.equals(ErrorResponse);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = ErrorResponse.hashCode();
		assertEquals(hashCode, ErrorResponse.hashCode());
	}

	@Test
	public void testSetterMethod() {
		ErrorResponse.setMessage("Hello");
		ErrorResponse.setReason("BAD REQUEST");
		ErrorResponse.setStatus(HttpStatus.OK);
		ErrorResponse.setTimestamp(null);
		assertEquals("Hello", ErrorResponse.getMessage());
	}

}
