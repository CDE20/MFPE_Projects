package com.pensionManagementSystem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.pensionManagementSystem.client.AuthorizationMicroserviceClient;
import com.pensionManagementSystem.model.JWTResponse;
import com.pensionManagementSystem.model.User;

@SpringBootTest
public class JwtResponseTest {
	
	@Autowired
	AuthorizationMicroserviceClient authorizationMicroserviceClient;


	@Test
	public void testNotNullJwtResponse() throws Exception {
		ResponseEntity<?> jwtResponse = authorizationMicroserviceClient.generateToken(new User(1,"admin","admin"));
		HashMap<String, String> tokenBodyMap = (LinkedHashMap<String, String>) jwtResponse.getBody();
		JWTResponse response = new JWTResponse(tokenBodyMap.get("token"));
		assertNotNull(response);
	}

//	@Test
//	public void testNotNullJwtResponse() throws Exception {
//		ResponseEntity<?> jwtResponse = authorizationMicroserviceClient.generateToken(new User(1,"admin","admin"));
//		HashMap<String, String> tokenBodyMap = (LinkedHashMap<String, String>) jwtResponse.getBody();
//		JWTResponse response = new JWTResponse(tokenBodyMap.get("token"));
//		assertNotNull(response);
//	}
	
	
	@Test
	public void testGetToken() {
		JWTResponse jwtResponse = new JWTResponse("abc");
		assertEquals(jwtResponse.getToken(), "abc");
	}

}
