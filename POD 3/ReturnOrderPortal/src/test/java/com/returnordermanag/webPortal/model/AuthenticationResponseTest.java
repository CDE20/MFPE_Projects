package com.returnordermanag.webPortal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.returnordermanag.webPortal.model.AuthenticationResponse;

public class AuthenticationResponseTest {
	AuthenticationResponse authenticationResponse = new AuthenticationResponse();

	@Test
	void testSetUserId() {
		authenticationResponse.setUserID(105);
		assertEquals(105, authenticationResponse.getUserID());
	}
	
	
	@Test
	void testSetJwtToken() {
		authenticationResponse.setJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU");
		assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU", authenticationResponse.getJwtToken());
	}
	
	@Test
	void testSetValid() {
		authenticationResponse.setValid(true);
		assertEquals(true, authenticationResponse.getValid());
	}
	
	@Test
	void testGetUserId() {
		authenticationResponse.setUserID(105);
		assertEquals(105, authenticationResponse.getUserID());
		
	}
	
	@Test
	void testGetJwtToken() {
		authenticationResponse.setJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU");
		assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU", authenticationResponse.getJwtToken());
	}
	
	@Test
	void testGetValid() {
		authenticationResponse.setValid(true);
		assertEquals(true, authenticationResponse.getValid());
	}
	
	@Test
	void testConstructor() {
		AuthenticationResponse ares = new AuthenticationResponse(101, "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU", true);
				assertEquals(101,ares.getUserID());
		assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU",ares.getJwtToken());
		assertEquals(true,ares.getValid());
	}
}