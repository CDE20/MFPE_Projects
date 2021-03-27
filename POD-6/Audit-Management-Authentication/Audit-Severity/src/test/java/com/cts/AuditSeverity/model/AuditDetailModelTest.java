package com.cts.AuditSeverity.model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.cts.AuditSeverity.model.AuditDetailModel;
/**
 * 
 * 	Test case to test AuditDetailModel Class
 *
 */
public class AuditDetailModelTest {

	private AuditDetailModel detailModel;
	
	@Before
	public void setup() {
		detailModel = new AuditDetailModel();
	}
	
	@Test
	public void testGetSetAuditType() {
		detailModel.setAuditType("Internal");
		assertEquals("Internal", detailModel.getAuditType());
	}
	@Test
	public void testGetSetAuditDate() {
		Date date = new Date();
		detailModel.setAuditDate(date);
		assertEquals(date, detailModel.getAuditDate());
	}
	@Test
	public void testGetAuditId() {
		assertEquals(0, detailModel.getAuditId());
	}
}
