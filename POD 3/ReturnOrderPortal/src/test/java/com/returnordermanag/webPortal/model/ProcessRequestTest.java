package com.returnordermanag.webPortal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.returnordermanag.webPortal.model.ProcessRequest;

public class ProcessRequestTest {
	ProcessRequest processRequest = new ProcessRequest();
	
	@Test
	void testGetUserID() {
		processRequest.setUserID(1);
		assertEquals(1, processRequest.getUserID());
	}
	
	@Test
	void testSetUserID() {
		processRequest.setUserID(1);
		assertEquals(1, processRequest.getUserID());
	}
	
	@Test
	void testGetUserName() {
		processRequest.setUsername("Abhishek");
		assertEquals("Abhishek", processRequest.getUsername());
	}
	
	@Test
	void testSetUserName() {
		processRequest.setUsername("Abhishek");
		assertEquals("Abhishek", processRequest.getUsername());
	}
	
	@Test
	void testGetContactNumber() {
		processRequest.setContactNumber(987456123);
		assertEquals(987456123, processRequest.getContactNumber());
	}
	
	@Test
	void testSetContactNumber() {
		processRequest.setContactNumber(987456123);
		assertEquals(987456123, processRequest.getContactNumber());
	}
	
	@Test
	void testGetCreditCardNumber() {
		processRequest.setCreditCardNumber(1234567890);
		assertEquals(1234567890, processRequest.getCreditCardNumber());
	}

	@Test
	void testSetCreditCardNumber() {
		processRequest.setCreditCardNumber(1234567890);
		assertEquals(1234567890, processRequest.getCreditCardNumber());
	}
	
	@Test
	void testGetComponentType() {
		processRequest.setComponentType("integral");
		assertEquals("integral", processRequest.getComponentType());
	}
	
	@Test
	void testSetComponentType() {
		processRequest.setComponentType("integral");
		assertEquals("integral", processRequest.getComponentType());
	}
	
	@Test
	void testGetComponentTypeAccessory() {
		processRequest.setComponentType("accessory");
		assertEquals("accessory", processRequest.getComponentType());
	}
	
	@Test
	void testSetComponentTypeAccessory() {
		processRequest.setComponentType("accessory");
		assertEquals("accessory", processRequest.getComponentType());
	}
	
	@Test
	void testGetComponentName() {
		processRequest.setComponentName("Laptop");
		assertEquals("Laptop", processRequest.getComponentName());
	}
	
	@Test
	void testSetComponentName() {
		processRequest.setComponentName("Laptop");
		assertEquals("Laptop", processRequest.getComponentName());
	}
	
	@Test
	void testGetQuantityOfDefective() {
		processRequest.setQuantityOfDefective(1);
		assertEquals(1, processRequest.getQuantityOfDefective());
	}
	
	@Test
	void testSetQuantityOfDefective() {
		processRequest.setQuantityOfDefective(1);
		assertEquals(1, processRequest.getQuantityOfDefective());
	}
	
	@Test
	void testGetPriorityRequest() {
		processRequest.setPriorityRequest(true);
		assertEquals(true, processRequest.isPriorityRequest());
	}
	
	@Test
	void testSetPriorityRequest() {
		processRequest.setPriorityRequest(true);
		assertEquals(true, processRequest.isPriorityRequest());
	}
	
	@Test
	void testConstructor() {
		ProcessRequest pr = new ProcessRequest(101, "Abhishek", 987456123, 1234567890, "integral", "laptop", 1, true);
		assertEquals(101,pr.getUserID());
		assertEquals("Abhishek",pr.getUsername());
		assertEquals(987456123,pr.getContactNumber());
		assertEquals(1234567890,pr.getCreditCardNumber());
		assertEquals("integral",pr.getComponentType());
		assertEquals("laptop",pr.getComponentName());
		assertEquals(1,pr.getQuantityOfDefective());
		assertEquals(true,pr.isPriorityRequest());
	}
	
	@Test
	void testConstructorForAccessory() {
		ProcessRequest pr = new ProcessRequest(101, "Abhishek", 987456123, 1234567890, "accessory", "laptop", 1, true);
		assertEquals(101,pr.getUserID());
		assertEquals("Abhishek",pr.getUsername());
		assertEquals(987456123,pr.getContactNumber());
		assertEquals(1234567890,pr.getCreditCardNumber());
		assertEquals("accessory",pr.getComponentType());
		assertEquals("laptop",pr.getComponentName());
		assertEquals(1,pr.getQuantityOfDefective());
		assertEquals(true,pr.isPriorityRequest());
	}
	
	@Test
	void testConstructorNoPriority() {
		ProcessRequest pr = new ProcessRequest(101, "Abhishek", 987456123, 1234567890, "integral", "laptop", 1, false);
		assertEquals(101,pr.getUserID());
		assertEquals("Abhishek",pr.getUsername());
		assertEquals(987456123,pr.getContactNumber());
		assertEquals(1234567890,pr.getCreditCardNumber());
		assertEquals("integral",pr.getComponentType());
		assertEquals("laptop",pr.getComponentName());
		assertEquals(1,pr.getQuantityOfDefective());
		assertEquals(false,pr.isPriorityRequest());
	}
	
	@Test
	void testConstructorAccessoryNoPriority() {
		ProcessRequest pr = new ProcessRequest(101, "Abhishek", 987456123, 1234567890, "accessory", "laptop", 1, false);
		assertEquals(101,pr.getUserID());
		assertEquals("Abhishek",pr.getUsername());
		assertEquals(987456123,pr.getContactNumber());
		assertEquals(1234567890,pr.getCreditCardNumber());
		assertEquals("accessory",pr.getComponentType());
		assertEquals("laptop",pr.getComponentName());
		assertEquals(1,pr.getQuantityOfDefective());
		assertEquals(false,pr.isPriorityRequest());
	}
}