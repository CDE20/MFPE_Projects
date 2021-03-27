package com.cognizant.transactionservice.controller;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cognizant.transactionservice.exception.GlobalExceptionHandler;
import com.cognizant.transactionservice.exception.MinimumBalanceException;
import com.cognizant.transactionservice.models.Transaction;
import com.cognizant.transactionservice.repository.TransactionRepository;
import com.cognizant.transactionservice.service.TransactionService;
import com.cognizant.transactionservice.util.AccountInput;
import com.cognizant.transactionservice.util.TransactionInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionControllerTest {
	MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wc;

	static ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() throws JsonProcessingException, Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
	}
	
	@Autowired
	TransactionRepository transRepo;

	@Autowired
	TransactionService transactionService;
	String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJFTVBMT1lFRTEwMSIsImV4cCI6MTYxNjQxODk0OCwiaWF0IjoxNjE2NDE3MTQ4fQ.ln-8ceskNQJuKQWPygb9bbM89fiJ-lJphoem2-_Eulk";


	@Test
	public void getAllTransactionById() throws Exception {
		Transaction trans=new Transaction();
		MvcResult andReturn = mockMvc.perform(get("/getAllTransByAccId/10054546").header("Authorization", token)).andExpect(status().isOk()).andReturn();
		String contentAsString = andReturn.getResponse().getContentAsString();
//		List<Transaction> res = transRepo.findBySourceAccountIdOrderByInitiationDate(10054546);
//		System.err.println(contentAsString);
//		assertEquals(res.get(0).getSourceAccountId(), 10054546);
	}
	
	@Test
	public void getAllTransaction() throws Exception {
		TransactionInput trans=new TransactionInput();
		trans.setSourceAccount(new AccountInput(10054546,1000.0));
		trans.setTargetAccount(new AccountInput(10054546,1000.0));
		trans.setAmount(1000.0);
		trans.setReference("TRANSFER");
		MvcResult andReturn = mockMvc.perform(post("/transactions")
				.content(asJsonString(trans))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization", token))
				.andExpect(status().is(406)).andReturn();
		String contentAsString = andReturn.getResponse().getContentAsString();
	}
	
	@Test
	public void withdraw() throws Exception {
		AccountInput trans=new AccountInput(10054546, 100.0);
		 MvcResult andReturn = mockMvc.perform(post("/withdraw")
				.content(asJsonString(trans))
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", token))
				.andExpect(status().is(406)).andReturn();
		 String contentAsString = andReturn.getResponse().getContentAsString();
		 System.err.println(contentAsString);
	}
	
	@Test
	public void servicecharge() throws Exception {
		AccountInput trans=new AccountInput(10054546, 100.0);
		 MvcResult andReturn = mockMvc.perform(post("/servicecharge")
				.content(asJsonString(trans))
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", token))
				.andExpect(status().isOk()).andReturn();
		 String contentAsString = andReturn.getResponse().getContentAsString();
		 System.err.println(contentAsString);
	}
	
	@Test
	public void deposit() throws Exception {
		AccountInput trans=new AccountInput(10054546, 100.0);
		MvcResult andReturn = mockMvc.perform(post("/deposit")
				.content(asJsonString(trans))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization", token))
				.andExpect(status().isOk()).andReturn();
		String contentAsString = andReturn.getResponse().getContentAsString();
	}
	
	@Test
	public void minimumBal() throws MinimumBalanceException,Exception {
		MinimumBalanceException minimumBalanceException = new MinimumBalanceException();
		MinimumBalanceException minimumBalanceException2 = new MinimumBalanceException("Hi");
		assertNotEquals(minimumBalanceException, minimumBalanceException2);
		GlobalExceptionHandler handler = new GlobalExceptionHandler();

		
	}
	

	
	
	public static String asJsonString(final Object obj) throws JsonProcessingException {
		
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		
	}
	
}
