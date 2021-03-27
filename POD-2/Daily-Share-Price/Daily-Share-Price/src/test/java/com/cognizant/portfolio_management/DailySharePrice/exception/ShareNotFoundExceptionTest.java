package com.cognizant.portfolio_management.DailySharePrice.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShareNotFoundExceptionTest {

	@Test
	void testShareNotFoundException() {
		ShareNotFoundException shareNotFoundException=new ShareNotFoundException("Error occured");
		assertEquals("Error occured",shareNotFoundException.getMessage());
	}

}
