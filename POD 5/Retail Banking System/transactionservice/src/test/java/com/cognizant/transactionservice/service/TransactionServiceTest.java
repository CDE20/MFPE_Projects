package com.cognizant.transactionservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.transactionservice.exception.MinimumBalanceException;
import com.cognizant.transactionservice.feign.AccountFeign;
import com.cognizant.transactionservice.feign.RulesFeign;
import com.cognizant.transactionservice.models.Transaction;
import com.cognizant.transactionservice.repository.TransactionRepository;
import com.cognizant.transactionservice.util.AccountInput;
import com.cognizant.transactionservice.util.TransactionInput;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TransactionServiceTest {

	
	
	@InjectMocks
	TransactionService consumerService;
	
	@Mock
	private AccountFeign accountFeign;

	@Mock
	private TransactionRepository transactionRepository;

	@Mock
	private RulesFeign ruleFeign;


	
	@Test
	 public void getConsumerBusinessTest1() throws Exception {
		//Optional<Consumer> consumer=Optional.of(new Consumer(10, "Akash Kumar Soni", new Date(1997,07,01), "ABC123", "akashconsumer@mail.com", true, "akash@mail.com", "New Business"));
		TransactionInput inp=new TransactionInput();
		inp.setSourceAccount(new AccountInput(10054546,1000.0));
		inp.setTargetAccount(new AccountInput(10054546,1000.0));
		inp.setAmount(1000.0);
		inp.setReference("TRANSFER");
		//when(transactionRepository.findBySourceAccountIdOrderByInitiationDate(1)).thenReturn((List<Transaction>) inp);
		
		assertThrows( Exception.class, ()->consumerService.makeTransfer("tokrn", inp));
		
//		assertEquals(true, makeTransfer);
	}
	
//	@Test
//	void getConsumerBusinessTest2() {
//		
//		when(consumerRepository.findById(10)).thenThrow(new ConsumerNotFoundException());
//		assertThrows( ConsumerNotFoundException.class, ()->consumerService.getConsumerBusiness(10));
//	}
//	
//	@Test
//	void getConsumerBusinessTest3() {
//		Optional<Consumer> consumer=Optional.of(new Consumer(10, "Akash Kumar Soni", new Date(1997,07,01), "ABC123", "akashconsumer@mail.com", true, "akash@mail.com", "New Business"));
//		when(consumerRepository.findById(10)).thenReturn(consumer);
//		when(businessRepository.findByConsumerId(10)).thenReturn(null);
//		assertThrows( BusinessNotFoundException.class, ()->consumerService.getConsumerBusiness(10));
//	}
//	
//	@Test
//	void getConsumerTest() {
//		Optional<Consumer> consumer=Optional.of(new Consumer(10, "Akash Kumar Soni", new Date(1997,07,01), "ABC123", "akashconsumer@mail.com", true, "akash@mail.com", "New Business"));
//		when(consumerRepository.findById(10)).thenReturn(consumer);
//		assertEquals("Akash Kumar Soni", consumerService.getConsumer(10).getName());
//	}
//	
//	@Test
//	void getConsumerFailTest() {
//		Optional<Consumer> consumer=Optional.empty();
//		when(consumerRepository.findById(10)).thenReturn(consumer);
//		assertThrows(ConsumerNotFoundException.class, ()->consumerService.getConsumer(10));
//	}
//	
//	
//	@Test
//	void getBusinessTest() {
//		Optional<Business> business=Optional.of(new Business(10, 10, "My Business", "Owned", 1000, 900, 10));
//		when(businessRepository.findById(10)).thenReturn(business);
//		assertEquals("Owned",consumerService.getBusiness(10).getBusinessType());
//	}
//	
//	@Test
//	void getBusinessFailTest() {
//		Optional<Business> business=Optional.empty();
//		when(businessRepository.findById(10)).thenReturn(business);
//		assertThrows(BusinessNotFoundException.class, ()->consumerService.getBusiness(10));
//	}
//	
//	@Test
//	void getPropertyTest() {
//		Optional<Property> property=Optional.of(new Property(10, 10, 10, 500, "Building", 10, 5, 2350, 100));
//		when(propertyRepository.findById(10)).thenReturn(property);
//		assertEquals("Building",consumerService.getProperty(10).getPropertyType());
//	}
//	
//	@Test
//	void getPropertyFailTest() {
//		Optional<Property> property = Optional.empty();
//		when(propertyRepository.findById(10)).thenReturn(property);
//		assertThrows(PropertyNotFoundException.class,()-> consumerService.getProperty(10));
//	}
//	
//	@Test
//	void saveConsumerBusinessTest1() {
//		Consumer consumer=new Consumer(10, "Akash Kumar Soni", new Date(1997,07,01), "ABC123", "akashconsumer@mail.com", true, "akash@mail.com", "New Business");
//		Business business=new Business();
//		when(consumerRepository.findByEmail("akashconsumer@mail.com")).thenReturn(consumer);
//		assertThrows(ConsumerAlreadyExistException.class, ()->consumerService.saveConsumerBusiness(consumer, business));
//	}
//	
//	@Test
//	void updateConsumerBusinessTest1() {
//		Consumer consumer=new Consumer(10, "Akash Kumar Soni", new Date(1997,07,01), "ABC123", "akashconsumer@mail.com", true, "akash@mail.com", "New Business");
//		Business business=new Business(10, 10, "My Business", "Owned", 1000, 900, 10);
//		when(consumerRepository.findById(10)).thenReturn(Optional.of(consumer));
//		when(businessRepository.findById(10)).thenReturn(Optional.of(new Business()));
//		//assertThrows(ConsumerAlreadyExistException.class, ()->consumerService.saveConsumerBusiness(consumer, business));
//		assertEquals("Consumer Business details updated successfully",consumerService.updateConsumerBusiness(consumer, business));
//	}
//	
//	@Test
//	void getConsumerBusinessByEmailTest1() {
//		Consumer consumer=new Consumer(10, "Akash Kumar Soni", new Date(1997,07,01), "ABC123", "akashconsumer@mail.com", true, "akash@mail.com", "New Business");
//		Business business=new Business();
//		when(consumerRepository.findByEmail("akashconsumer@mail.com")).thenReturn(consumer);
//		when(businessRepository.findByConsumerId(10)).thenReturn(business);
//		assertEquals("Akash Kumar Soni",consumerService.getConsumerBusiness("akashconsumer@mail.com").getConsumer().getName());
//	}
//	
//	@Test
//	void getConsumerBusinessByEmailTest2() {
//		Consumer consumer=new Consumer(10, "Akash Kumar Soni", new Date(1997,07,01), "ABC123", "akashconsumer@mail.com", true, "akash@mail.com", "New Business");
//		Business business=null;
//		when(consumerRepository.findByEmail("akashconsumer@mail.com")).thenReturn(consumer);
//		when(businessRepository.findByConsumerId(10)).thenReturn(business);
//		assertThrows(BusinessNotFoundException.class, ()->consumerService.getConsumerBusiness("akashconsumer@mail.com"));
//	}
//	
//	@Test
//	void getConsumerBusinessByEmailTest3() {
//		Consumer consumer=null;
//		Business business=new Business();
//		when(consumerRepository.findByEmail("akashconsumer@mail.com")).thenReturn(consumer);
//		when(businessRepository.findByConsumerId(10)).thenReturn(business);
//		assertThrows(ConsumerNotFoundException.class, ()->consumerService.getConsumerBusiness("akashconsumer@mail.com"));
//	}
//	
//	@Test
//	void getBusinessByConsumerIdTest1() {
//		when(businessRepository.findByConsumerId(10)).thenReturn(null);
//		assertThrows(BusinessNotFoundException.class, ()->consumerService.getBusinessByConsumerId(10));
//	}
//	
//	@Test
//	void getBusinessByConsumerIdTest2() {
//		Business business=new Business(10, 10, "My Business", "Owned", 1000, 900, 10);
//		when(businessRepository.findByConsumerId(10)).thenReturn(business);
//		assertEquals("Owned",consumerService.getBusinessByConsumerId(10).getBusinessType());
//	}
//	
//	@Test
//	void getConsumerBusinessListTest() {
//		List<Consumer> consumerList=new ArrayList();
//		consumerList.add(new Consumer(10, "Akash Kumar Soni", new Date(1997,07,01), "ABC123", "akashconsumer@mail.com", true, "akash@mail.com", "New Business"));
//		
//		when(consumerRepository.findByAgentId("akash@mail.com")).thenReturn(consumerList);
//		when(businessRepository.findByConsumerId(10)).thenReturn(new Business());
//		assertEquals(1,consumerService.getConsumerBusinessList("akash@mail.com").size());
//		
//	}
//	
//	
//	@Test
//	void getConsumerProperty() {
//		Property property=new Property(10, 10, 10, 500, "Building", 10, 5, 2350, 100);
//		when(consumerRepository.findById(10)).thenReturn(Optional.of(new Consumer()));
//		when(propertyRepository.findByConsumerId(10)).thenReturn(property);
//		assertEquals("Building", consumerService.getConsumerProperty(10).getPropertyType());
//	}
//	
//	@Test
//	void getConsumerProperty2() {
//		Property property=null;
//		when(consumerRepository.findById(10)).thenReturn(Optional.of(new Consumer()));
//		when(propertyRepository.findByConsumerId(10)).thenReturn(property);
//		assertThrows(PropertyNotFoundException.class,()->consumerService.getConsumerProperty(10));
//	}
//	
//	@Test
//	void saveBusinessPropertyTest() {
//		assertEquals("Property Details saved successfully", consumerService.saveBusinessProperty(new Property()));
//	}
//	
//	@Test
//	void updateBusinessPropertyTest1() {
//		Property property=new Property(10, 10, 10, 500, "Building", 10, 5, 2350, 100);
//		when(propertyRepository.findById(10)).thenReturn(Optional.of(property));
//		assertEquals("Property updated successfully", consumerService.updateBusinessProperty(10, property));
//	}
//	
//	@Test
//	void updateBusinessPropertyTest2() {
//		Property property=new Property(10, 10, 10, 500, "Building", 10, 5, 2350, 100);
//		when(propertyRepository.findById(10)).thenReturn(Optional.of(property));
//		assertEquals("You do not own this property", consumerService.updateBusinessProperty(11, property));
//	}
//	
//	@Test
//	void updateBusinessPropertyFailTest() {
//		Optional<Property> property=Optional.empty();
//		when(propertyRepository.findById(10)).thenReturn(property);
//		assertThrows(PropertyNotFoundException.class, ()->consumerService.updateBusinessProperty(10, new Property(10, 10, 10, 500, "Building", 10, 5, 2350, 100)));
//	}
//	
//	@Test
//	void hasPermissionTest() {
//		when(authClient.getValidity("token")).thenReturn(new ResponseEntity<AuthResponse>(new AuthResponse(true),HttpStatus.OK));
//		assertTrue(consumerService.hasPermission("token").isValid());
//	}
//	
//	@Test
//	void hasPermissionFalseTest() {
//		when(authClient.getValidity("token")).thenReturn(new ResponseEntity<AuthResponse>(new AuthResponse(false),HttpStatus.OK));
//		assertThrows(AccessDeniedException.class, ()->consumerService.hasPermission("token"));
//	}

}
