package com.authorizationMicroservice;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.authorizationMicroservice.service.CustomUserDetailsService;
import com.authorizationMicroservice.util.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class JWTControllerTest {

	/*@Autowired
	MockMvc mockMvc;

	@MockBean
	JWTUtil jwtUtil;

	@MockBean
	CustomUserDetailsService customUserDetailsService;

	@Test
	void getTokenTest() throws Exception {

		com.authorizationMicroservice.model.User user = new com.authorizationMicroservice.model.User(1, "admin",
				"admin");
		UserDetails loadUserByUsername = customUserDetailsService.loadUserByUsername("admin");
		UserDetails value = new User(user.getUsername(), user.getPassword(), new ArrayList<>());

		when(customUserDetailsService.loadUserByUsername("admin")).thenReturn(value);
		when(jwtUtil.generateToken(loadUserByUsername)).thenReturn("token");

		mockMvc.perform(MockMvcRequestBuilders.post("/getToken").content(asJsonString(user))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
*/
}
