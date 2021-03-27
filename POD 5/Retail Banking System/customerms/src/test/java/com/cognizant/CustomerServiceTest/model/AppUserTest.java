package com.cognizant.CustomerServiceTest.model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.cognizant.customerservice.model.AppUser;

 class AppUserTest {
	AppUser accInp = new AppUser();

	@Test
	void setAccountIdTest() {
		accInp.setUserid("1");
		assertEquals("1", accInp.getUserid());
	}

	@Test
	void setRoleTest() {
		accInp.setRole("user");
		assertEquals("user", accInp.getRole());
	}

	@Test
	void setUsernameTest() {
		accInp.setUsername("1");
		assertEquals("1", accInp.getUsername());
	}

	@Test
	void setPassTest() {
		accInp.setPassword("user");
		assertEquals("user", accInp.getPassword());
	}

	@Test
	void setAuthTokenTest() {
		accInp.setAuthToken("user");
		assertEquals("user", accInp.getAuthToken());
	}

	@Test
	void getAccIdTest() {
		accInp.setUserid("1");
		assertEquals("1", accInp.getUserid());
	}

	@Test
	void getRoleTest() {
		accInp.setRole("user");
		assertEquals("user", accInp.getRole());
	}

	@Test
	void getUsernameTest() {
		accInp.setUsername("1");
		assertEquals("1", accInp.getUsername());
	}

	@Test
	void getPasswordTest() {
		accInp.setPassword("user");
		assertEquals("user", accInp.getPassword());
	}

	@Test
	void getTokenTest() {
		accInp.setAuthToken("token");
		assertEquals("token", accInp.getAuthToken());
	}

}
