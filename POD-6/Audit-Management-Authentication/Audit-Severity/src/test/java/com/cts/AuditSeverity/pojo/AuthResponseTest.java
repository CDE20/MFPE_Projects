package com.cts.AuditSeverity.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.cts.AuditSeverity.pojo.AuthResponse;
/**
 * 
 * 	Test class to test AuthResponse 
 *
 */
public class AuthResponseTest {

	private AuthResponse auth;
	
	@Before
	public void setup() {
		auth = new AuthResponse();
	}
	/**
	 * to test getter and setter
	 */
	@Test
	public void testGetSetUid() {
		auth.setUid("UID");
		assertEquals("UID", auth.getUid());
	}
	/**
	 * to test getter and setter
	 */
	@Test
	public void testValid() {
		auth.setValid(false);
		assertFalse(auth.isValid());
	}
}
