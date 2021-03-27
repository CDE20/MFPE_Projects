package com.cognizant.pharmacysupply.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PharmacyMedicineSupplyTest {

	@Mock
	PharmacyMedicineSupply supply;

	@Before
	public void Setup() throws Exception {
		supply = new PharmacyMedicineSupply();
		supply.setId(1);
		supply.setMedicineName("Crocin");
		supply.setPharmacyName("Healthy Pharmacy");
		supply.setSupplyCount(10);
	}

	@Test
	public void testSetters() {
		supply.setId(1);
		supply.setMedicineName("Orthoherb");
		assertEquals("Orthoherb", supply.getMedicineName());
	}

	@Test
	public void testGetters() {
		assertEquals("Crocin", supply.getMedicineName());
	}

	@Test
	public void NoArgsConstructorTest() {
		PharmacyMedicineSupply supply = new PharmacyMedicineSupply();
		assertEquals(null, supply.getMedicineName());
	}

	@Test
	public void AllArgConstTest() {
		PharmacyMedicineSupply supply = new PharmacyMedicineSupply(1, "Healthy Pharmacy", "Crocin", 10);
		assertEquals("Crocin", supply.getMedicineName());
		assertEquals("Healthy Pharmacy", supply.getPharmacyName());

	}

	@Test
	public void testToString() {
		assertEquals(
				"PharmacyMedicineSupply(id=" + supply.getId() + ", pharmacyName=" + supply.getPharmacyName()
						+ ", medicineName=" + supply.getMedicineName() + ", supplyCount=" + supply.getSupplyCount() + ")",
				supply.toString());
	}

}
