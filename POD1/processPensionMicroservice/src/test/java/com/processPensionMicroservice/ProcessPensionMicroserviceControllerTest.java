package com.processPensionMicroservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.processPensionMicroservice.controller.processPensionController;

@SpringBootTest
class ProcessPensionMicroserviceControllerTest {

	MockMvc mockMvc;

	@Autowired
	processPensionController processpensionController;

	@Autowired
	WebApplicationContext context;

	@Test
	void contextLoads() {
		assertNotNull(processpensionController);
	}

	@Before(value = "")
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testPost() throws Exception {
		String json = "{\n" + "  \"title\": \"Greetings\",\n" + "  \"value\": \"Hello World\"\n" + "}";
//	        mockMvc.perform(post("/ProcessPension")
//	                .contentType(MediaType.APPLICATION_JSON)
//	                .content(json))
//	                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
//	                .andExpect(jsonPath("$.value", Matchers.is("Hello World")));
	}

}
