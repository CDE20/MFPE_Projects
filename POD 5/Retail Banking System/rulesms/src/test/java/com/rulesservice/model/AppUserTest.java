package com.rulesservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



class AppUserTest {
	
AppUser accInp=new AppUser();
	
	@Test
	void setAccountIdTest() {
		accInp.setUsername("yamini");;
		assertEquals("yamini", accInp.getUsername());
	}
	
	@Test
	void setAmountTest() {
		accInp.setUserid("emp");
		assertEquals("emp", accInp.getUserid());
	}
}