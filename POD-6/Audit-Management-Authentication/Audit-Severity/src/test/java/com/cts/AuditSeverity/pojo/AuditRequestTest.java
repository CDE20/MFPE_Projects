package com.cts.AuditSeverity.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cts.AuditSeverity.pojo.AuditDetails;
import com.cts.AuditSeverity.pojo.AuditRequest;
/**
 * 
 * 	Test class to test AuditRequest
 *
 */
public class AuditRequestTest {

	private AuditRequest request;
	
	@Before
	public void setup() {
		request = new AuditRequest();
	}
	
	@Test
	public void testGetSetProjectName() {
		request.setProjectName("ProjectName");
		assertEquals("ProjectName", request.getProjectName());
	}
	@Test
	public void testGetSetProjectManagerName() {
		request.setProjectManagerName("ManagerName");
		assertEquals("ManagerName", request.getProjectManagerName());
	}
	@Test
	public void testGetSetOwnerName() {
		request.setApplicationOwnerName("OwnerName");
		assertEquals("OwnerName", request.getApplicationOwnerName());
	}
	@Test
	public void testGetSetAuditDetails() {
		AuditDetails details = new AuditDetails();
		request.setAuditDetails(details);
		assertEquals(details, request.getAuditDetails());
	}
}
