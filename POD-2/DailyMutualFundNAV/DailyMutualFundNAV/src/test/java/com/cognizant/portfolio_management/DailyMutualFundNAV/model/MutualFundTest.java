package com.cognizant.portfolio_management.DailyMutualFundNAV.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MutualFundTest {
	
	MutualFund mutualFund=new MutualFund();
	
	@Test
	void testSetMutualFundId() {
		mutualFund.setMutualFundId("101");
		assertEquals("101", mutualFund.getMutualFundId());
	}

	@Test
	void testSetMutualFundName() {
		mutualFund.setMutualFundName("abc");
		assertEquals("abc", mutualFund.getMutualFundName());
	}

	@Test
	void testSetMutualFundValue() {
		mutualFund.setMutualFundValue(10.0);
		assertEquals(10.0, mutualFund.getMutualFundValue());
	}

	@Test
	void testToString() {
		MutualFund mf=new MutualFund("101", "abc", 100.0);
		assertEquals("MutualFund [mutualFundId=101, mutualFundName=abc, mutualFundValue=100.0]", mf.toString());
	}

	@Test
	void testMutualFund() {
		MutualFund mf=new MutualFund();
	}

	@Test
	void testMutualFundStringStringDouble() {
		MutualFund mf=new MutualFund("101", "abc", 100.0);
		assertEquals("101", mf.getMutualFundId());
		assertEquals("abc", mf.getMutualFundName());
		assertEquals(100.0, mf.getMutualFundValue());
		
	}
}
