package com.pensionerDetailsMicroservice;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pensionerDetailsMicroservice.Exception.NotFoundException;
import com.pensionerDetailsMicroservice.Model.Bank;
import com.pensionerDetailsMicroservice.Model.PensionerDetail;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
class PensionerDetailsMicroserviceApplicationTests {

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
	void testMainMethod() throws NumberFormatException, IOException, NotFoundException, ParseException {
		PensionerDetailsMicroserviceApplication.main(new String [] {});
	}

}
