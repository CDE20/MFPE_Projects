package com.returnordermanag.webPortal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.returnordermanag.webPortal.model.ProcessResponse;

public class ProcessResponseTest {
	ProcessResponse processResponse = new ProcessResponse();
	
	@Test
	void testGetRequestID() {
		processResponse.setRequestID(11);
		assertEquals(11, processResponse.getRequestID());
	}

	@Test
	void testSetRequestID() {
		processResponse.setRequestID(11);
		assertEquals(11, processResponse.getRequestID());
	}
	
	@Test
	void testGetUserID() {
		processResponse.setUserID(1);
		assertEquals(1, processResponse.getUserID());
	}
	
	@Test
	void testSetUserID() {
		processResponse.setUserID(1);
		assertEquals(1, processResponse.getUserID());
	}
	
	@Test
	void testGetProcessingCharge() {
		processResponse.setProcessingCharge(500.0);
		assertEquals(500.0, processResponse.getProcessingCharge());
	}
	
	@Test
	void testSetProcessingCharge() {
		processResponse.setProcessingCharge(500.0);
		assertEquals(500.0, processResponse.getProcessingCharge());
	}
	
	@Test
	void testGetPackagingAndDeliveryCharge() {
		processResponse.setPackagingAndDeliveryCharge(500.0);
		assertEquals(500.0, processResponse.getPackagingAndDeliveryCharge());
	}
	
	@Test
	void testSetPackagingAndDeliveryCharge() {
		processResponse.setPackagingAndDeliveryCharge(500.0);
		assertEquals(500.0, processResponse.getPackagingAndDeliveryCharge());
	}
	
	@Test
	void testGetDateOfDelivery() {
		processResponse.setDateOfDelivery("13/03/2021");
		assertEquals("13/03/2021", processResponse.getDateOfDelivery());
	}
	
	@Test
	void testSetDateOfDelivery() {
		processResponse.setDateOfDelivery("13/03/2021");
		assertEquals("13/03/2021", processResponse.getDateOfDelivery());
	}
	
	@Test
	void testConstructor() {
		ProcessResponse pres = new ProcessResponse(11, 1, 500.0, 500.0, "13/03/2021");
		assertEquals(11,pres.getRequestID());
		assertEquals(1,pres.getUserID());
		assertEquals(500.0,pres.getProcessingCharge());
		assertEquals(500.0,pres.getPackagingAndDeliveryCharge());
		assertEquals("13/03/2021",pres.getDateOfDelivery());
	}
}