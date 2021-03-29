package com.processPensionMicroservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.processPensionMicroservice.model.Bank;
import com.processPensionMicroservice.model.PensionDetail;
import com.processPensionMicroservice.model.PensionerDetail;
import com.processPensionMicroservice.model.PensionerInput;
import com.processPensionMicroservice.model.ProcessPensionResponse;
import com.processPensionMicroservice.util.DateUtil;

public class ProcessPensionServiceTest {

	@InjectMocks
	ProcessPensionService processPensionService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCheckDetailsForCorrectPensionerInputForSelfPensionType() throws ParseException {
		PensionerInput input = new PensionerInput("Shubham", DateUtil.parseDate("23-11-1996"), "ASDFG3456",
				123456789012L, "self");
		Bank bank = new Bank("ICICI", 456678, "public");
		PensionerDetail details = new PensionerDetail("Shubham", DateUtil.parseDate("23-11-1996"), "ASDFG3456", 100000,
				10000, "self", bank);

		ProcessPensionResponse response = processPensionService.checkdetails(input, details);

		assertEquals(10, response.getPensionStatusCode());
	}

	@Test
	public void testCheckDetailsForCorrectPensionerInputForFamilyPensionType() throws ParseException {
		PensionerInput input = new PensionerInput("Shubham", DateUtil.parseDate("23-11-1996"), "ASDFG3456",
				123456789012L, "family");
		Bank bank = new Bank("ICICI", 456678, "public");
		PensionerDetail details = new PensionerDetail("Shubham", DateUtil.parseDate("23-11-1996"), "ASDFG3456", 100000,
				10000, "family", bank);

		ProcessPensionResponse response = processPensionService.checkdetails(input, details);

		assertEquals(10, response.getPensionStatusCode());
	}

	@Test
	public void testCheckDetailsForIncorrectPensionerInputForSelf() throws ParseException {
		PensionerInput input = new PensionerInput("Shubham", DateUtil.parseDate("23-11-1996"), "ASDFG3908",
				123456789012L, "self");
		Bank bank = new Bank("ICICI", 456678, "public");
		PensionerDetail details = new PensionerDetail("Shubham", DateUtil.parseDate("23-11-1996"), "ASDFG3456", 100000,
				10000, "self", bank);

		ProcessPensionResponse response = processPensionService.checkdetails(input, details);

		assertEquals(21, response.getPensionStatusCode());
	}

	@Test
	public void testCheckDetailsForIncorrectPensionerInputForFamily() throws ParseException {
		PensionerInput input = new PensionerInput("Shubham", DateUtil.parseDate("23-11-1996"), "ASDFG3908",
				123456789012L, "family");
		Bank bank = new Bank("ICICI", 456678, "public");
		PensionerDetail details = new PensionerDetail("Shubham", DateUtil.parseDate("23-11-1996"), "ASDFG3456", 100000,
				10000, "family", bank);

		ProcessPensionResponse response = processPensionService.checkdetails(input, details);

		assertEquals(21, response.getPensionStatusCode());
	}

	@Test
	public void testGettingPensionDetailByPassingPensionerDetalisForSelfPensionType() throws ParseException {
		Bank bank = new Bank("ICICI", 456678, "public");
		PensionerDetail details = new PensionerDetail("Shubham", DateUtil.parseDate("23-11-1996"), "ASDFG3456", 100000,
				10000, "self", bank);

		PensionDetail actualDetail = processPensionService.getresult(details);

		assertEquals(90000, actualDetail.getPensionAmount());
	}

	@Test
	public void testGettingPensionDetailByPassingPensionerDetalisForFamilyPensionType() throws ParseException {
		Bank bank = new Bank("ICICI", 456678, "public");
		PensionerDetail details = new PensionerDetail("Shubham", DateUtil.parseDate("23-11-1996"), "ASDFG3456", 100000,
				10000, "family", bank);

		PensionDetail actualDetail = processPensionService.getresult(details);

		assertEquals(60000, actualDetail.getPensionAmount());
	}

}
