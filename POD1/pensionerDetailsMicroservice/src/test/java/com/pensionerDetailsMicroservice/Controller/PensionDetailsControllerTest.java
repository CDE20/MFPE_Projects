package com.pensionerDetailsMicroservice.Controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pensionerDetailsMicroservice.Model.Bank;
import com.pensionerDetailsMicroservice.Model.PensionerDetail;
import com.pensionerDetailsMicroservice.Service.PensionerdetailService;
import com.pensionerDetailsMicroservice.Util.DateUtil;

public class PensionDetailsControllerTest {

	@InjectMocks
	PensionerDetailsController controller;

	@Mock
	PensionerdetailService service;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testToGetCorrectPenionerDetailsFromController() throws Exception {
		PensionerDetail pensionerDetail = new PensionerDetail("Shubham", DateUtil.parseDate("29-01-1999"), "PCASD1234Q",
				27000, 10000, "self", new Bank("ICICI", 12345678, "private"));
		when(service.getPensionerDetailByAadhaarNumber(123456789012L)).thenReturn(pensionerDetail);
		PensionerDetail actual = controller.getPensionerDetailByAadhaar(123456789012L);
		assertNotNull(actual);
		assertEquals(actual, pensionerDetail);

	}

	@Test
	public void testForAadharNumberNotInCsvFile() {

		PensionerDetail actual = controller.getPensionerDetailByAadhaar(12345678888L);
		assertNull(actual);
	}

}
