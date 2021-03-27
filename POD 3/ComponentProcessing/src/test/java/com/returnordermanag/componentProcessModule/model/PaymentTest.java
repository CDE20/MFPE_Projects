package com.returnordermanag.componentProcessModule.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.returnordermanag.componentProcessModule.model.Payment;

class PaymentTest {
	Payment payment = new Payment();
	
	@Test
	void testGetRequestID() {
		payment.setRequestID(11);
		assertEquals(11, payment.getRequestID());
	}

	@Test
	void testSetRequestID() {
		payment.setRequestID(11);
		assertEquals(11, payment.getRequestID());
	}

	@Test
	void testGetCreditCardNumber() {
		payment.setCreditCardNumber(1234567890);
		assertEquals(1234567890, payment.getCreditCardNumber());
	}

	@Test
	void testSetCreditCardNumber() {
		payment.setCreditCardNumber(1234567890);
		assertEquals(1234567890, payment.getCreditCardNumber());
	}
	
	@Test
	void testGetCreditLimit() {
		payment.setCreditLimit(5000.0);
		assertEquals(5000.0, payment.getCreditLimit());
	}
	
	@Test
	void testSetCreditLimit() {
		payment.setCreditLimit(5000.0);
		assertEquals(5000.0, payment.getCreditLimit());
	}
	
	@Test
	void testGetProcessingCharge() {
		payment.setProcessingCharge(5000.0);
		assertEquals(5000.0, payment.getProcessingCharge());
	}
	
	@Test
	void testSetProcessingCharge() {
		payment.setProcessingCharge(5000.0);
		assertEquals(5000.0, payment.getProcessingCharge());
	}
	
	@Test
	void testConstructor() {
		Payment obj=new Payment(1,1234567,5000,230);
		assertEquals(1, obj.getRequestID());
		assertEquals(1234567, obj.getCreditCardNumber());
		assertEquals(5000, obj.getCreditLimit());
		assertEquals(230, obj.getProcessingCharge());
	}
}
