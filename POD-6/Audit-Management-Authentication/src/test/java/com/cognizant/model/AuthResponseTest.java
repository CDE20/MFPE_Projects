package com.cognizant.model;

import static org.junit.Assert.*;

/**
 * @author POD5
 *  For testing the AuthResponse 
 * 
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthResponseTest {

AuthResponse authResponse=new AuthResponse();
	/**
	 * to test  the AuthResponseConstructor()
	 * all params constructor
	 */
	@Test
	public void testAuthResponseConstructor()
	{
		AuthResponse response=new AuthResponse("abc", true);
		assertEquals( "abc" ,  response.getUid() );
	}
	/**
	 * to test the setter getter for user ID
	 */
	@Test
	public void testUid()
	{
		authResponse.setUid("abc");
		assertEquals("abc" , authResponse.getUid() );
	}
	
	/**
	 * to test the setter getter for validity
	 */
	@Test
	public void testIsValid()
	{
		authResponse.setValid(true);
		assertEquals( true , authResponse.isValid());
	}
	/**
	 * to test the toString method 
	 */
	@Test
	public void testtoString() 
	{
        String s = authResponse.toString();
        assertEquals( s , authResponse.toString());
    }

}
