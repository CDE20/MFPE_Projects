package com.cognizant.pharmacysupply.model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MedicineStockTest {

	@Mock
	MedicineStock medicineStock;

	@Before
	public void setUp() throws Exception {
		medicineStock = new MedicineStock();
		medicineStock.setId(1);
		medicineStock.setName("Crocin");
		medicineStock.setChemicalComposition("digoxin");
		medicineStock.setPharmacyName("Healthy Pharmacy");
		medicineStock.setTargetAilment("Cardiac Arrest");
		medicineStock.setNumberOfTabletsInStock(10);
		medicineStock.setDateOfExpiry(new Date(2022 - 9 - 12));
	}

	@Test
	public void testSetters() {
		medicineStock.setId(1);
		medicineStock.setName("Orthoherb");
		assertEquals("Orthoherb", medicineStock.getName());
	}

	@Test
	public void testGetters() {
		assertEquals("Crocin", medicineStock.getName());
	}

	@Test
	public void NoArgsConstructorTest() {
		MedicineStock medicineStock = new MedicineStock();
		assertEquals(null, medicineStock.getPharmacyName());
	}

	@Test
	public void AllArgConstTest() {
		MedicineStock stock = new MedicineStock(1, "Crocin", "digoxin", "General", "Healthy Pharmacy",
				new Date(2022 - 9 - 12), 10);
		assertEquals("Crocin", stock.getName());
		assertEquals(medicineStock.getNumberOfTabletsInStock(), stock.getNumberOfTabletsInStock());
	}

	@Test
	public void testToString() {
		assertEquals("MedicineStock(id=" + 1 + ", name=" + medicineStock.getName() + ", chemicalComposition=" + medicineStock.getChemicalComposition()
				+ ", targetAilment=" + medicineStock.getTargetAilment() + ", pharmacyName=" + medicineStock.getPharmacyName() + ", dateOfExpiry="
				+ medicineStock.getDateOfExpiry() + ", numberOfTabletsInStock=" + medicineStock.getNumberOfTabletsInStock() + ")", medicineStock.toString());
	}

}
