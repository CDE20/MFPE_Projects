package com.cts.AuditSeverity.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cts.AuditSeverity.pojo.AuditBenchmark;
/**
 * 
 * 	Test class to test AuditBenchMark 
 *
 */
public class AuditBenchmarkTest {

	private AuditBenchmark benchmark;
	
	@Before
	public void setup() {
		benchmark = new AuditBenchmark();
	}
	/**
	 * to test getter and setter
	 */
	@Test
	public void testGetSetAuditType() {
		benchmark.setAuditType("Internal");
		assertEquals("Internal", benchmark.getAuditType());
	}
	/**
	 * to test getter and setter
	 */
	@Test
	public void testGetSetAccNoAnswers() {
		benchmark.setAccNoAnswers(12);
		assertEquals(12, benchmark.getAccNoAnswers());
	}
}
