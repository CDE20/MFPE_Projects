package com.returnordermanag.componentProcessModule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.returnordermanag.componentProcessModule.client.PaymentFeignClient;
import com.returnordermanag.componentProcessModule.repository.PaymentRepository;
import com.returnordermanag.componentProcessModule.service.PaymentService;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	PaymentService paymentService;
	@MockBean
	private PaymentRepository paymentRepository;
	@MockBean
	private PaymentFeignClient paymentFeignClient;

	/*@Test
	void testCompleteProcessing() {
		String expectedOutput = "Your Payment is successful. Thank you for using our service";
		when(paymentFeignClient.getCurrentBalance(Mockito.anyLong(), Mockito.anyDouble())).thenReturn(100.0);
		paymentService.completeProcessing(0, 0, 0, 0);
		//assertEquals(expectedOutput, actualOutput);
	}*/
}
