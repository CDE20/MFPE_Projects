package com.cts.AuditSeverity.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cts.AuditSeverity.pojo.AuditResponse;
/**
 * 
 * Test class to test AuditResponse
 *
 */
public class AuditResponseTest {

	private AuditResponse response;
	
	@Before
	public void setup() {
		response = new AuditResponse("GREEN", "2 Weeks");
	}
	
	@Test
	public void testGetSetAuditId() {
		response.setAuditId(101);
		assertEquals(101, response.getAuditId());
	}
	@Test
	public void testGetSetProjectExecutionStatus() {
		response.setProjectExecutionStatus("RED");
		assertEquals("RED", response.getProjectExecutionStatus());
	}
	@Test
	public void testGetSetRemedialActionDuration() {
		response.setRemedialActionDuration("None");
		assertEquals("None", response.getRemedialActionDuration());
	}
}
