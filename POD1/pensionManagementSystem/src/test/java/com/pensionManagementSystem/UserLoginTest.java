package com.pensionManagementSystem;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pensionManagementSystem.model.User;

@SpringBootTest
public class UserLoginTest {
	User user = new User(1,"pensioner1","pensioner2");

	@Test
	public void testNotNullJwtRequest() {
		assertNotNull(user);
	}
	
	@Test
	public void testUsername() {
		user.setUsername("pensioner1");
		assertEquals(user.getUsername(), "pensioner1");
	}

	@Test
	public void testPassword() {
		user.setPassword("pensioner2");
		assertEquals(user.getPassword(), "pensioner2");
	}

}
