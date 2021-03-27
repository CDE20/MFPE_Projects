package com.returnordermanag.componentProcessModule.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.returnordermanag.componentProcessModule.model.ProcessResponse;

class ProcessResponseTest {
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
		ProcessResponse obj=new ProcessResponse(1, 101, 230, 400,"11-11-2020");
		assertEquals(1, obj.getRequestID());
		assertEquals(101, obj.getUserID());
		assertEquals(230, obj.getProcessingCharge());
		assertEquals(400, obj.getPackagingAndDeliveryCharge());
		assertEquals("11-11-2020", obj.getDateOfDelivery());
	}
	
}
