package com.cognizant.accountservice.controller;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.accountservice.feignclient.AuthFeignClient;
import com.cognizant.accountservice.feignclient.TransactionFeign;
import com.cognizant.accountservice.model.Account;
import com.cognizant.accountservice.model.AccountCreationStatus;
import com.cognizant.accountservice.model.AccountInput;
import com.cognizant.accountservice.model.AuthenticationResponse;
import com.cognizant.accountservice.model.Transaction;
import com.cognizant.accountservice.repository.AccountRepository;
import com.cognizant.accountservice.service.AccountServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AuthFeignClient authFeign;

	@MockBean
	private AccountServiceImpl accountServiceImpl;

	@MockBean
	private AccountRepository accountRepository;

	@MockBean
	private TransactionFeign transactionFeign;

	@Test
	void getAccountTest() throws Exception {
		when(accountServiceImpl.hasPermission("token")).thenReturn(new AuthenticationResponse("", "", true));
		Account account = new Account();
		when(accountServiceImpl.getAccount(1)).thenReturn(account);
		mockMvc.perform(get("/getAccount/1").header("Authorization", "token")).andExpect(status().isOk());
		verify(accountServiceImpl, timeout(1)).getAccount(1);
	}

	@Test
	void getCustomerAccountTest() throws Exception {
		when(accountServiceImpl.hasPermission("token")).thenReturn(new AuthenticationResponse("", "", true));
		when(accountServiceImpl.getCustomerAccount("token", "Cust101")).thenReturn(new ArrayList<>());
		mockMvc.perform(get("/getAccounts/Cust101").header("Authorization", "token")).andExpect(status().isOk());
		verify(accountServiceImpl, timeout(1)).getCustomerAccount("token", "Cust101");
	}

	@Test
	void createAccountTest() throws Exception {
		when(accountServiceImpl.hasEmployeePermission("token"))
				.thenReturn(new AuthenticationResponse("Emp101", "emp", true));
		Account account = new Account(1l, "CUST101", 3000.0, "Savings", "Samuel F", null);
		when(accountServiceImpl.createAccount("Cust101", account))
				.thenReturn(new AccountCreationStatus(1, "Sucessfully Created"));
		mockMvc.perform(MockMvcRequestBuilders.post("/createAccount/Cust101").content(asJsonString(account))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "token")).andExpect(status().isNotAcceptable());
		verify(accountServiceImpl, timeout(1)).hasEmployeePermission("token");
	}

	public static String asJsonString(final Object obj) throws Exception{
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;	
	}
}
