package com.processPensionMicroservice;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.processPensionMicroservice.exception.NotFoundException;
import com.processPensionMicroservice.model.Bank;
import com.processPensionMicroservice.model.PensionDetail;
import com.processPensionMicroservice.model.PensionerDetail;
import com.processPensionMicroservice.model.PensionerInput;
import com.processPensionMicroservice.model.ProcessPensionInput;
import com.processPensionMicroservice.model.ProcessPensionResponse;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
class ProcessPensionMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testBankDetails() {
		EqualsVerifier.simple().forClass(Bank.class).verify();
	}

	@Test
	void testPensionerDeatils() {
		EqualsVerifier.simple().forClass(PensionerDetail.class).verify();
	}
	
	@Test
	void testPensionDetails() {
		EqualsVerifier.simple().forClass(PensionDetail.class).verify();
	}

	@Test
	void testPensionerInputDeatils() {
		EqualsVerifier.simple().forClass(PensionerInput.class).verify();
	}
	
	@Test
	void testProcessPensionerInputDeatils() {
		EqualsVerifier.simple().forClass(ProcessPensionInput.class).verify();
	}
	
	@Test
	void testProcessPensionResponseDeatils() {
		EqualsVerifier.simple().forClass(ProcessPensionResponse.class).verify();
	}

	@Test
	void testMainMethod() throws NumberFormatException, IOException, NotFoundException, ParseException {
		ProcessPensionMicroserviceApplication.main(new String[] {});
	}

}
