package com.returnordermanag.paymentService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.returnordermanag.paymentService.controller.CardController;
import com.returnordermanag.paymentService.service.CardService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = CardController.class)
class TestController {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CardService cardService;
	
	@Test
	void testGetCallPositive() throws Exception {
		when(cardService.processPayment(Mockito.anyLong(), Mockito.anyDouble())).thenReturn(2000.0);
		long cardnumber=1234567890;
		Double amt=5000.0;
		
		mockMvc.perform(get("/card/{cardNumber}/{charge}",cardnumber,amt)).andExpect(status().isOk());
		
		
		
	}
	
	@Test
	void testGetCallNegative() throws Exception {
		when(cardService.processPayment(Mockito.anyLong(), Mockito.anyDouble())).thenThrow(new IllegalArgumentException("in test Call"));
		long cardnumber=1234567890;
		Double amt=5000.0;
		mockMvc.perform(get("/card/{cardNumber}/{charge}",cardnumber,amt)).andExpect(status().isInternalServerError());
	}
	
	
	
}
