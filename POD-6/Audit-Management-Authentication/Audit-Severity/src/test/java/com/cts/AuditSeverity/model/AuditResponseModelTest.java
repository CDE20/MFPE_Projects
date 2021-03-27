package com.cts.AuditSeverity.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cts.AuditSeverity.model.AuditResponseModel;
/**
 * 
 * 	Test cases to test AuditResponseModel Class
 *
 */
public class AuditResponseModelTest {

	private AuditResponseModel response;
	
	@Before
	public void setup() {
		response = new AuditResponseModel();
	}
	
	
	@Test
	public void testGetSetProjectExecutionStatus() {
		response.setExecutionStatus("RED");
		assertEquals("RED", response.getExecutionStatus());
	}
	@Test
	public void testGetSetRemedialActionDuration() {
		response.setActionDuration("None");
		assertEquals("None", response.getActionDuration());
	}
	@Test
	public void testGetResponseId() {
		assertEquals(0, response.getResponseId());
	}
}
