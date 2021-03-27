package com.cognizant.portfoliomanagement.WebPortal.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserDataTest {
	
	UserData userData=new UserData();

	@Test
	void testSetUserid() {
		userData.setUserid("user1");
		assertEquals("user1", userData.getUserid());
	}

	@Test
	void testSetUpassword() {
		userData.setUpassword("pwd");
		assertEquals("pwd", userData.getUpassword());
	}

	@Test
	void testSetUname() {
		userData.setUname("user1");
		assertEquals("user1", userData.getUname());
	}

	@Test
	void testSetAuthToken() {
		userData.setAuthToken("authToken");
		assertEquals("authToken", userData.getAuthToken());
	}

	@Test
	void testUserDataStringStringStringString() {
		UserData user=new UserData("101", "pwd", "101", "usertoken");
	}

	@Test
	void testUserData() {
		UserData user1=new UserData();
	}

}
