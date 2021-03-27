package com.cts.AuditSeverity.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cts.AuditSeverity.model.AuditRequestModel;
/**
 * 
 * 	Test case to test AuditRequestModel Class
 *
 */
public class AuditRequestModelTest {

	private AuditRequestModel request;
	
	@Before
	public void setup() {
		request = new AuditRequestModel();
	}
	
	@Test
	public void testGetSetProjectName() {
		request.setProjectName("ProjectName");
		assertEquals("ProjectName", request.getProjectName());
	}
	@Test
	public void testGetSetProjectManagerName() {
		request.setManagerName("ManagerName");
		assertEquals("ManagerName", request.getManagerName());
	}
	@Test
	public void testGetSetOwnerName() {
		request.setOwnerName("OwnerName");
		assertEquals("OwnerName", request.getOwnerName());
	}
	@Test
	public void testGetRequestId() {
		assertEquals(0, request.getRequestId());
	}
	
}
