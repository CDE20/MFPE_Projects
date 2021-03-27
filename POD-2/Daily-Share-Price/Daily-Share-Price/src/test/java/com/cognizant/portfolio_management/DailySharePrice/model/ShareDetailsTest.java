package com.cognizant.portfolio_management.DailySharePrice.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShareDetailsTest {

	ShareDetails shareDetails=new ShareDetails();
	@Test
	void testGetShareId() {
		shareDetails.setShareId("101");
		assertEquals("101", shareDetails.getShareId());
	}

	@Test
	void testGetShareName() {
		shareDetails.setShareName("abc");
		assertEquals("abc", shareDetails.getShareName());
	}

	@Test
	void testGetShareValue() {
		shareDetails.setShareValue(10.0);
		assertEquals(10.0, shareDetails.getShareValue());
	}
	
	@Test
	void testShareDetailsStringStringDouble() {
		ShareDetails shareDetails=new ShareDetails("101", "abc", 10.0);
		assertEquals("101", shareDetails.getShareId());
		assertEquals("abc", shareDetails.getShareName());
		assertEquals(10.0, shareDetails.getShareValue());
	}

	@Test
	void testShareDetails() {
		ShareDetails shareDetails=new ShareDetails();
	}

	@Test
	void testToString() {
		ShareDetails shareDetails=new ShareDetails("101", "abc", 10.0);
		assertEquals("ShareDetails [shareId=101, shareName=abc, shareValue=10.0]", shareDetails.toString());
		
	}

	

}
