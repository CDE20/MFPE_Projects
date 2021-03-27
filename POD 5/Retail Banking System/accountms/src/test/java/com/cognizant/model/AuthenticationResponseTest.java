package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cognizant.accountservice.model.AuthenticationResponse;

class AuthenticationResponseTest {

	AuthenticationResponse response = new AuthenticationResponse();
	AuthenticationResponse response2 = new AuthenticationResponse();

	@Test
	void setUserIdTest() {
		response.setUserid("Cust101");
		assertEquals("Cust101", response.getUserid());
	}

	@Test
	void setNameTest() {
		response.setName("Pratik B");
		assertEquals("Pratik B", response.getName());
	}

	@Test
	void setisValidTest() {
		response.setValid(true);
		assertEquals(true, response.isValid());
	}

	@Test
	void toSringTest() {
		assertEquals(response2.toString(), response.toString());
	}

}
