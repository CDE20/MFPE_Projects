package com.rulesservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rulesservice.exception.AccessDeniedException;
import com.rulesservice.feign.AuthorizationFeign;
import com.rulesservice.model.AuthenticationResponse;
import com.rulesservice.model.RulesInput;
import com.rulesservice.model.ServiceResponse;
import com.rulesservice.service.RulesServiceImpl;


@ExtendWith(SpringExtension.class)
class RulesServiceImplTest {

	@InjectMocks
	RulesServiceImpl serviceImpl;
	
	@Mock
	AuthorizationFeign authFeignClient;
	
	@Before(value = "")
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	 @Test
	    void evaluateTest() {
	        RulesServiceImpl service = new RulesServiceImpl();
	        RulesInput in=new RulesInput(1000,10000,10);
	        assertEquals(true,service.evaluate(in));
	    }
	 
	 @Test
	 void evaluateTest2() {
	        RulesServiceImpl service = new RulesServiceImpl();
	        RulesInput in=new RulesInput(1000,100,10);
	        assertEquals(false,service.evaluate(in));
	    }
	 
	 @Test
	 void evaluateTest3() {
	        RulesServiceImpl service = new RulesServiceImpl();
	        RulesInput in=new RulesInput(1000,1000,100);
	        assertEquals(false,service.evaluate(in));
	    }
	 @Test
		void hasPermissionTest1() {
			when(authFeignClient.getValidity("token")).thenReturn(new AuthenticationResponse("EMP101", "emp", true));
			when(authFeignClient.getRole("EMP101")).thenReturn("EMPLOYEE");
			assertTrue(serviceImpl.hasPermission("token").isValid());
		}
		
		@Test
		void hasPermissionTest2() {
			when(authFeignClient.getValidity("token")).thenThrow(new AccessDeniedException("NOT ALLOWED"));
			assertThrows(AccessDeniedException.class, ()->serviceImpl.hasPermission("token"));
		}
		
		@Test
		void servicechargeTest1()
		{
		        RulesInput in=new RulesInput(1000,10000,10);
		        ServiceResponse get= serviceImpl.serviceCharges(in);
		        ServiceResponse res=new ServiceResponse("No Detection",1000,(double) 10000);
		        assertEquals(get.getMessage(),res.getMessage());
		}
		
		@Test
		void servicechargeTest3()
		{
			RulesInput inp=new RulesInput(101,100,100);
			ServiceResponse get= serviceImpl.serviceCharges(inp);
			String str="Your Balance is lesser than the minimum balance so 10.0 is detected from your account";
			ServiceResponse res= new ServiceResponse(str,101,(double) 90);
		    assertEquals(get.getBalance(),res.getBalance());
		}
		
	 

	}
	
