package com.authorizationMicroservice;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.authorizationMicroservice.model.User;
import com.authorizationMicroservice.service.CustomUserDetailsService;
import com.authorizationMicroservice.util.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
class AuthorizationMicroserviceApplicationTests {

	/*MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext context;
	
	@Mock
	JWTUtil jwtUtil;
	
	@Mock
	CustomUserDetailsService customUserDetailsService;
	
	ObjectMapper objectMapper;	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		jwtUtil.setSecret("pensionSecret");
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testGenerateTokenController() throws Exception {
		User user = new User(1, "admin", "admin");
		
		mockMvc.perform(post("/authenticate").content(asJsonString(user))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		//String responseString = result.getResponse().getContentAsString();
		//ResponseEntity<?> response = objectMapper.readValue(responseString, ResponseEntity<JWTResponse.class>);
		
		//assertNotNull(responseString);
		assertTrue(true);
		
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
