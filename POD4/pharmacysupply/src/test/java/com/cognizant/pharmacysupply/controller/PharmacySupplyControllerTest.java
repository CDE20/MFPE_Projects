package com.cognizant.pharmacysupply.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.pharmacysupply.exception.TokenValidationFailedException;
import com.cognizant.pharmacysupply.feignclient.AuthenticationFeignClient;
import com.cognizant.pharmacysupply.model.JwtResponse;
import com.cognizant.pharmacysupply.model.MedicineDemand;
import com.cognizant.pharmacysupply.model.PharmacyMedicineSupply;
import com.cognizant.pharmacysupply.service.PharmacyServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class PharmacySupplyControllerTest {

	@Mock
	private AuthenticationFeignClient authFeignClient;

	@InjectMocks
	private PharmacyController pharmacyController;

	@Mock
	private MedicineDemand medicineDemand;

	@Mock
	private PharmacyMedicineSupply pharmacyMedicineSupply;

	@Mock
	private List<MedicineDemand> medicineDemandList;
	
	@Mock
	private PharmacyServiceImpl pharmacyService;
	/**
	 * Before running test cases this method should run to set the value for fields
	 */
	@Before
	public void setup() {
		log.info("Start");
		medicineDemand = new MedicineDemand();
		medicineDemand.setDemandCount(200);
		medicineDemand.setId(1);
		medicineDemand.setMedicineName("Crocin");
		pharmacyMedicineSupply = new PharmacyMedicineSupply();
		pharmacyMedicineSupply.setId(1);
		pharmacyMedicineSupply.setMedicineName("Crocin");
		pharmacyMedicineSupply.setPharmacyName("Healthy pharmacy");
		pharmacyMedicineSupply.setSupplyCount(200);
		log.info("End");
	}
	
	@Test
	public void testGetPharmacySupply() throws Exception {
		log.info("Start");
		when(pharmacyService.validateToken("token")).thenReturn(true);
		ResponseEntity<?> responseEntity = pharmacyController.getPharmacySupply("token", medicineDemandList);
		log.info("Response Entity {}",responseEntity);
		HttpStatus statusCode = responseEntity.getStatusCode();
		assertNotNull(statusCode);
		assertEquals(HttpStatus.OK, statusCode);
		log.info("End");
	}
	
	@Test
	public void testGetMedicineSupply() throws Exception {
		log.info("Start");
		when(pharmacyService.validateToken("token")).thenReturn(true);
		ResponseEntity<?> responseEntity = pharmacyController.getMedicineSupply("token");
		log.info("Response Entity {}",responseEntity);
		HttpStatus statusCode = responseEntity.getStatusCode();
		assertNotNull(statusCode);
		assertEquals(HttpStatus.OK, statusCode);
		log.info("End");
	}
	
	@Test(expected = TokenValidationFailedException.class)
	public void testGetMedicineSupplyFail() throws TokenValidationFailedException {
		log.info("Start");
		when(pharmacyService.validateToken("token")).thenReturn(false);
		ResponseEntity<?> responseEntity = pharmacyController.getMedicineSupply("token");
		log.info("End");
	}
	
	@Test
	public void testGetMedicineDemand() throws Exception {
		log.info("Start");
		when(pharmacyService.validateToken("token")).thenReturn(true);
		ResponseEntity<?> responseEntity = pharmacyController.getMedicineDemand("token");
		log.info("Response Entity {}",responseEntity);
		HttpStatus statusCode = responseEntity.getStatusCode();
		assertNotNull(statusCode);
		assertEquals(HttpStatus.OK, statusCode);
		log.info("End");
	}
	
	@Test(expected = TokenValidationFailedException.class)
	public void testGetMedicineDemandFail() throws Exception {
		log.info("Start");
		when(pharmacyService.validateToken("token")).thenReturn(false);
		ResponseEntity<?> responseEntity = pharmacyController.getMedicineDemand("token");
		log.info("End");
	}
	
	@Test(expected = TokenValidationFailedException.class)
	public void testGetPharmacySupplyWhenTokenNotValid() throws Exception {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("root", "root", false));
		ResponseEntity<?> allMedicineStockInformation = pharmacyController.getPharmacySupply("token",
				medicineDemandList);
		log.info("Response Entity {}",allMedicineStockInformation);
		assertNotNull(allMedicineStockInformation);
		log.info("End");
	}

}
