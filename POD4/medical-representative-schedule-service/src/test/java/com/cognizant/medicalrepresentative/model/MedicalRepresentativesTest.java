package com.cognizant.medicalrepresentative.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.medicalrepresentativeschedule.model.MedicalRepresentative;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@Slf4j
public class MedicalRepresentativesTest {

	@Mock
	private MedicalRepresentative medicalRepresentative;


	@Before
	public void setup() {
		log.info("Start");
		medicalRepresentative = new MedicalRepresentative();
		medicalRepresentative.setId(1);
		medicalRepresentative.setName("R1");
		medicalRepresentative.setPhoneNumber("8877779292");
		log.info("End");
	}


	@Test
	public void testMedicineStockDetails() throws Exception {
		log.info("Start");
		assertEquals(1, medicalRepresentative.getId());
		assertEquals("R1", medicalRepresentative.getName());
		assertEquals("8877779292", medicalRepresentative.getPhoneNumber());

		log.info("End");

	}


	@Test
	public void testAllArgsConstructor() {

		MedicalRepresentative medicalRepresentatives = new MedicalRepresentative(1, "R1", "8877779292");
		assertEquals("R1", medicalRepresentatives.getName());
	}


	@Test
	public void testToStringMethod() {
		log.info("Start");
		assertEquals(medicalRepresentative.toString(), medicalRepresentative.toString());
		log.info("End");
	}


	@Test
	public void testSetters() {
		medicalRepresentative.setId(1);
		assertEquals(1, medicalRepresentative.getId());
	}


	@Test
	public void testEqualsMethod() {
		boolean equals = medicalRepresentative.equals(medicalRepresentative);
		assertTrue(equals);
	}

	/**
	 * Tests the hashCode() method
	 */
	@Test
	public void testHashCodeMethod() {
		int hashCode = medicalRepresentative.hashCode();
		assertEquals(hashCode, medicalRepresentative.hashCode());
	}
}