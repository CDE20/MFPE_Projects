package com.cognizant.authorization.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyUserTest {

	@Mock
	private MyUser myUser;
	
	@Before
	public void setUp() {
		myUser=new MyUser("admin","admin","admin");
	}
	@Test
	public void testAllArgumentConstructor() {
		MyUser user=new MyUser("admin","admin","admin");
		assertEquals("admin",user.getUserid());
		assertEquals("admin",user.getPassword());
		assertEquals("admin",user.getUsername());
	}
	@Test
	public void testNoArgumentConstructor() {
		MyUser user=new MyUser();
		assertEquals(user,user);
	}
	
	@Test
	public void testSetter() {
		MyUser user=new MyUser();
		user.setUsername("Rock");
		assertEquals("Rock",user.getUsername());
	}
	@Test
	public void testToStringMethod() {
		
		assertEquals("MyUser(userid=" + myUser.getUserid() + ", password=" + myUser.getPassword()
				+ ", username=" + myUser.getUsername() + ")", myUser.toString());	
	}
	@Test
	public void testEqualsMethod() {
		boolean equals = myUser.equals(myUser);
		assertTrue(equals);
	}
	
}
