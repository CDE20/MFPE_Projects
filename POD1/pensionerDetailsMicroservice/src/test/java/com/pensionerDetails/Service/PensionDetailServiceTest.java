package com.pensionerDetails.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.pensionerDetailsMicroservice.Exception.NotFoundException;
import com.pensionerDetailsMicroservice.Model.Bank;
import com.pensionerDetailsMicroservice.Model.PensionerDetail;
import com.pensionerDetailsMicroservice.Service.PensionerdetailService;
import com.pensionerDetailsMicroservice.Util.DateUtil;

public class PensionDetailServiceTest {

	@InjectMocks
	private PensionerdetailService pds;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNotNullPensionDetailServiceObject() {
		assertNotNull(pds);
	}

	@Test
	public void testCorrectDetailsReturnedFromServiceWithCorrectAadharNumber() throws IOException, NotFoundException,
			NumberFormatException, com.pensionerDetailsMicroservice.Exception.NotFoundException, ParseException {

		PensionerDetail pensionerDetail = new PensionerDetail("Shubham", DateUtil.parseDate("29-01-1999"), "PCASD1234Q",
				27000, 10000, "self", new Bank("ICICI", 12345678, "private"));
		assertEquals(pds.getPensionerDetailByAadhaarNumber(123456789012L), pensionerDetail);
	}

	@Test
	public void testForIncorrectAadharNumber()
			throws NumberFormatException, IOException, NotFoundException, ParseException {
		exception.expect(NotFoundException.class);
		exception.expectMessage("AadharNumber Not Found");
		pds.getPensionerDetailByAadhaarNumber(12345678);
	}

}
