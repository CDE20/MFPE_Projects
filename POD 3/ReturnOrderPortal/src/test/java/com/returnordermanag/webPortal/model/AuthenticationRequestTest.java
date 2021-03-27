package com.returnordermanag.webPortal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.returnordermanag.webPortal.model.AuthenticationRequest;

public class AuthenticationRequestTest {

	AuthenticationRequest authenticationRequest = new AuthenticationRequest();
	
	
	
	@Test
	void testGetUserName() {
		authenticationRequest.setUsername("Abhishek");
		assertEquals("Abhishek", authenticationRequest.getUsername());
	}
	
	@Test
	void testSetUserName() {
		authenticationRequest.setUsername("Abhishek");
		assertEquals("Abhishek", authenticationRequest.getUsername());
	}
	@Test
	void testGetPassword() {
		authenticationRequest.setPassword("Abhishek");
		assertEquals("Abhishek", authenticationRequest.getPassword());
	}
	
	@Test
	void testSetPassword() {
		authenticationRequest.setPassword("Abhishek");
		assertEquals("Abhishek", authenticationRequest.getPassword());
	}
	
	@Test
	void testConstructor() {
		AuthenticationRequest ar = new AuthenticationRequest("Abhishek", "Abhishek");
		assertEquals("Abhishek", ar.getUsername());
		assertEquals("Abhishek", ar.getPassword());
	}
}