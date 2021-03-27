package com.cognizant.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * 
 *  	   This class contains test cases for the AuditType class
 *         which are written using junit and mockito
 */
public class AuditTypeTest {

	
	AuditType auditType = new AuditType();
	/**
	 * Test the AuditType Setter
	 */
	@Test
	public void testSetAuditType() {
		auditType.setAuditType("Internal");
		assertEquals("Internal",auditType.getAuditType());
	}
	/**
	 * Test the AuditType Getter
	 */
	@Test
	public void testGetAuditType() {
		auditType.setAuditType("SOX");
		assertEquals("SOX",auditType.getAuditType());
	}
	/**
	 * Test the AuditType All Args Constructor
	 */
	@Test
	public void testAuditTypeConstructor() {
		AuditType auditTypeTest = new AuditType("Sox");
		assertEquals("Sox",auditTypeTest.getAuditType());
	}
	/**
	 * Test the AuditType toString
	 */
	@Test
	public void testAuditTypeToString() {
		String s = new AuditType().toString();
		assertEquals(s,auditType.toString());
				
	}
	
	
}
