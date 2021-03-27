package com.cts.benchmark.pojo;

/**
 * Test AuthResponse class
 */
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthResponseTest {

AuthResponse authResponse=new AuthResponse();
	
	/**
	 * Testing constructor
	 */
	@Test
	public void testAuthResponseConstructor()
	{
		AuthResponse response=new AuthResponse("abc", true);
		assertEquals( "abc" ,  response.getUid() );
	}
	/**
	 * Testing setter for uid
	 */
	@Test
	public void testUid()
	{
		authResponse.setUid("abc");
		assertEquals("abc" , authResponse.getUid() );
	}
	/**
	 * Testing isValid setter
	 */
	
	@Test
	public void testIsValid()
	{
		authResponse.setValid(true);
		assertEquals( true , authResponse.isValid());
	}
	
	/** 
	 * Testing toString method
	 */
	@Test
	public void testtoString() 
	{
        String s = authResponse.toString();
        assertEquals( s , authResponse.toString());
    }

}
