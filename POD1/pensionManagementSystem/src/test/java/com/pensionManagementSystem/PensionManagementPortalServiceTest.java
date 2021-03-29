package com.pensionManagementSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pensionManagementSystem.client.AuthorizationMicroserviceClient;
import com.pensionManagementSystem.model.ProcessPensionInput;
import com.pensionManagementSystem.model.User;

@SpringBootTest
public class PensionManagementPortalServiceTest {

	@Mock
	User user;
	@Mock
	AuthorizationMicroserviceClient authorizationMicroserviceClient;
	ResponseEntity<String> resultString;
	Long aaddharNum;
	Map<String, String> resultMap = new HashMap<String, String>();
	Optional<ProcessPensionInput> processInput;

	@BeforeEach
	void init() {
		aaddharNum = Long.parseLong("123465789123");
		resultString = new ResponseEntity<String>(
				"{\"name\":\"Shubham\",\"dateOfBirth\":\"29-01-1999\",\"pan\":\"PCASD1234Q\",\"aadharNumber\":\"123456789012\"\"pensionType\":\"self\"}",
				HttpStatus.OK);
		resultMap = new HashMap<String, String>();
		System.out.println("resultString is :" + resultString);
		System.out.println("resultMap is:" + resultMap);

	}

	@Test
	void resultTokenGenrationMethodTest() {
		resultMap.put("name", "aakash");
		resultMap.put("pensionAmount", "25000.0");
		resultMap.put("dateOfBirth", "26/10/1967");
		resultMap.put("type", "private");
		// System.out.println("2
		// is"+authorizationMicroserviceClient.generateToken(user));
	}

//	@Test
//	void processErrorMessageTest() {
//		
//		 processInput = Optional.ofNullable(new ProcessPensionInput());
//		 when(pensionManagementRepository.findById(aaddharNum)).thenReturn(processInput);
//		resultMap.put("name","aakash");
//		resultMap.put("pensionAmount","25000.0");
//		resultMap.put("type","private");
//		Assertions.assertEquals(processInput, pensionManagementPortalServiceImpl.processErrorMessage(aaddharNum));
//	}

}
