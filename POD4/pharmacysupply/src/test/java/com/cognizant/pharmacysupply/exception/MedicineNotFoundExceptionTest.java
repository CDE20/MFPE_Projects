package com.cognizant.pharmacysupply.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineNotFoundExceptionTest {

	@Mock
	private MedicineNotFoundException medicineNotFoundException;

	@Test
	public void testOneArgConstructor() {
		MedicineNotFoundException medicineNotFoundException = new MedicineNotFoundException("Medicine not found.");
		assertEquals("Medicine not found.", medicineNotFoundException.getMessage());
	}
	
	@Test
	public void testNoArgsConstructor() {
		MedicineNotFoundException exception = new MedicineNotFoundException();
		assertEquals(null, exception.getMessage());
	}

}
