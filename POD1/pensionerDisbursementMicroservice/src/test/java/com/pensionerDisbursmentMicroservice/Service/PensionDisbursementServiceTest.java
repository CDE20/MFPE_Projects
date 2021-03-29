package com.pensionerDisbursmentMicroservice.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.pensionerDisbursementMicroservice.Model.Bank;
import com.pensionerDisbursementMicroservice.Model.ProcessPensionResponse;
import com.pensionerDisbursementMicroservice.service.PensionDisbursmentService;

@RunWith(MockitoJUnitRunner.class)
public class PensionDisbursementServiceTest {

	@InjectMocks
	PensionDisbursmentService service;
	
	@Mock
	ProcessPensionResponse response;
	
	int serviceCharge = 500;
	
	@Test
	public void testServiceObjectNotNull() {
		assertNotNull(service);
	}
	
	@Test
	public void testResponseObjectNotNull() {
		assertNotNull(response);
	}
	
	@Test
	public void testGettingCodeForPublicTypeBank() {
		Bank bank = new Bank("ICICI", 123456, "public");
		response = service.code(bank, serviceCharge);
		assertEquals(10, response.getPensionStatusCode());
	}
	
	@Test
	public void testGettingCodeForPrivateTypeBank() {
		Bank bank = new Bank("ICICI", 123456, "private");
		response = service.code(bank, serviceCharge);
		assertEquals(21, response.getPensionStatusCode());
	}

}
