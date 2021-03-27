package com.cognizant.medicinestock.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.medicinestock.model.MedicineStock;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MedicineStokeServiceImplTest {

	@Autowired
	private MedicineStockServiceImpl medicineStockService;

	@Mock
	private MedicineStock medicineStock;

	@Test
	public void testGetMedicineStockInformation() {
		log.info("Start");
		List<MedicineStock> medicineList = medicineStockService.getMedicineStockInformation();
		assertNotNull(medicineList);
		log.info("End");
	}

	@Test
	public void testGetMedicineStockInformationFail() {
		log.info("Start");
		List<MedicineStock> medicineList = medicineStockService.getMedicineStockInformation();
		assertNotNull(medicineList);
		log.info("End");
	}

	@Test
	public void testGetStockCountForMedicineFail() {
		log.info("Start");
		List<MedicineStock> numberOfTabletsInStockByName = medicineStockService
				.getMedicineByTargetAilment("Crocin");
		assertNotNull(numberOfTabletsInStockByName);
		log.info("End");
	}

	@Test
	public void testGetNumberOfTabletsInStockByName() {
		log.info("Start");
		MedicineStock numberOfTabletsInStockByName = medicineStockService.getNumberOfTabletsInStockByName("Crocin");
		assertNotNull(numberOfTabletsInStockByName);
		log.info("End");
	}
}
