package com.cognizant.medicinestock.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.cognizant.medicinestock.feignclient.AuthenticationFeignClient;
import com.cognizant.medicinestock.model.JwtResponse;
import com.cognizant.medicinestock.model.MedicineStock;
import com.cognizant.medicinestock.service.MedicineStockServiceImpl;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class MedicineStockControllerTest {

	@Mock
	private AuthenticationFeignClient authFeignClient;

	@InjectMocks
	private MedicineStockController medicineStockController;

	@Mock
	private MedicineStock medicineStock;

	@Mock
	private List<MedicineStock> medicineStockList;

	@Mock
	private MedicineStockServiceImpl medicineStockService;
	
	@Test
	public void contextLoads() {
		assertNotNull(medicineStockController);
	}


	@Before
	public void setup() {
		log.info("START");
		medicineStock = new MedicineStock();
		medicineStock.setId(1);
		medicineStock.setPharmacyName("Crocin");
		medicineStock.setChemicalComposition("disaccharide gentiobiose, dicarboxylic acid crocetin");
		medicineStock.setTargetAilment("General");
		medicineStock.setPharmacyName("Healthy Pharmacy");
		medicineStock.setDateOfExpiry(new java.util.Date(2022 - 9 - 12));
		medicineStock.setNumberOfTabletsInStock(200);
		log.info("END");
	}


	@Test
	public void testGetMedicineStockInformation() throws Exception {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", "adminpass", true));
		ResponseEntity<?> medicineStockInformation = medicineStockController.getMedicineStockInformation("token");
		HttpStatus statusCode = medicineStockInformation.getStatusCode();
		assertNotNull(statusCode);
		assertEquals(HttpStatus.OK, statusCode);
		log.info("End");
	}


	@Test
	public void testGetMedicineStockInformationWhenTokenNotValid() throws Exception {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", "adminpass", false));
		ResponseEntity<?> allMedicineStockInformation = medicineStockController.getMedicineStockInformation("token");
		assertNotNull(allMedicineStockInformation);
		log.info("End");
	}


	@Test
	public void testGetStockCountForMedicineWhenTokenValidationFails() {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", "adminpass", false));
		ResponseEntity<?> stockCountForMedicine = medicineStockController.getStockCountForMedicine("token", "Crocin");
		assertNotNull(stockCountForMedicine);
		log.info("End");

	}

	@Test
	public void testGetStockCountForMedicine() {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", "admin", true));
		ResponseEntity<?> stockCountForMedicine = medicineStockController.getStockCountForMedicine("token", "Crocin");
		HttpStatus statusCode = stockCountForMedicine.getStatusCode();
		assertEquals(HttpStatus.OK, statusCode);
		log.info("End");
	}

	@Test
	public void getMedicineByTreatingAilment() {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", "adminpass", true));
		ResponseEntity<?> medicineByTreatingAilment = medicineStockController.getMedicineByTreatingAilment("token",
				"Orthopaedics");
		HttpStatus statusCode = medicineByTreatingAilment.getStatusCode();
		assertNotNull(statusCode);
		log.info("End");
	}

	@Test
	public void getMedicineByTreatingAilmentWhenTokenValidationFails() {
		log.info("Start");
		when(authFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", "adminpass", false));
		ResponseEntity<?> medicineByTreatingAilment = medicineStockController.getMedicineByTreatingAilment("token",
				"Orthopaedics");
		assertNotNull(medicineByTreatingAilment);
		log.info("End");
	}

}
