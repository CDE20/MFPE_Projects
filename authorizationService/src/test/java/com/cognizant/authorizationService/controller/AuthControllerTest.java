package com.cognizant.authorizationService.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.authorizationService.model.UserData;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AuthControllerTest {
	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AuthController authController;

	@Test
	public void contextLoads() {

		assertNotNull(authController);

	}

	@Test
	public void loginTestSuccess() throws Exception {
		UserData admin = new UserData("admin", "admin", "admin", "admin");

		ResultActions actions = mockMvc
				.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(asJsonString(admin)));
		actions.andExpect(status().isOk());
	}

	@Test
	public void loginTestFail() throws Exception {
		UserData admin = new UserData("randomUser", "randomUser", "randomUser", "randomUser");

		ResultActions actions = mockMvc
				.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(asJsonString(admin)));
		actions.andExpect(status().isForbidden());
		actions.andExpect(status().reason("Access Denied"));
	}

	@Test
	public void validateTestSuccess() throws Exception {
		ResultActions actions = mockMvc.perform(get("/validate").header("Authorization", "Bearer " + token));

		actions.andExpect(status().isOk());

	}

	@Test
	public void validateTestFail() throws Exception {
		ResultActions actions = mockMvc.perform(get("/validate").header("Authorization", "randomToken"));

		actions.andExpect(status().isForbidden());

	}

	public static String asJsonString(UserData admin) {
		try {
			return new ObjectMapper().writeValueAsString(admin);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}