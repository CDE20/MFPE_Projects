package com.cognizant.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cognizant.accountservice.exceptionhandling.AccessDeniedException;
import com.cognizant.accountservice.exceptionhandling.AccountNotFoundException;
import com.cognizant.accountservice.feignclient.AuthFeignClient;
import com.cognizant.accountservice.feignclient.TransactionFeign;
import com.cognizant.accountservice.model.Account;
import com.cognizant.accountservice.model.AccountCreationStatus;
import com.cognizant.accountservice.model.AccountInput;
import com.cognizant.accountservice.model.AuthenticationResponse;
import com.cognizant.accountservice.repository.AccountRepository;
import com.cognizant.accountservice.service.AccountServiceImpl;

@ExtendWith(SpringExtension.class)
class AccountServiceTest {

	@InjectMocks
	AccountServiceImpl accountServiceImpl;

	@Mock
	AuthFeignClient authFeignClient;

	@Mock
	AccountRepository accountRepository;

	@Mock
	TransactionFeign transactionFeign;

	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
    }

	@Test
	void getAccountTestCorrect() {
		Account account = new Account(1l, "CUST101", 3000.0, "Savings", "Samuel F", null);
		when(accountRepository.findByAccountId(1l)).thenReturn(account);

		assertEquals("Samuel F", accountServiceImpl.getAccount(1l).getOwnerName());
	}

	@Test
	void getAccountTestException() {
		when(accountRepository.findByAccountId(2l)).thenThrow(new AccountNotFoundException());
		assertThrows(AccountNotFoundException.class, () -> accountServiceImpl.getAccount(2));
	}

	@Test
	void getAccountTestExceptionMessage() {
		when(accountRepository.findByAccountId(2l)).thenThrow(new AccountNotFoundException("Account Does Not Exist"));
		assertThrows(AccountNotFoundException.class, () -> accountServiceImpl.getAccount(2));
	}

	@Test
	void getCustomerAccount() {

		List<Account> accountList = new ArrayList<>();
		Account account1 = new Account(1l, "CUST101", 3000.0, "Savings", "Samuel F", null);
		Account account2 = new Account(2l, "CUST101", 5000.0, "Current", "Samuel F", null);

		accountList.add(account1);
		accountList.add(account2);

		when(accountRepository.findByCustomerId("CUST101")).thenReturn(accountList);
		when(transactionFeign.getTransactionsByAccId("token", 1)).thenReturn(null);
		when(transactionFeign.getTransactionsByAccId("token", 2)).thenReturn(null);
		assertEquals(2, accountServiceImpl.getCustomerAccount("token", "CUST101").size());
	}

	@Test
	void createAccount() {
		Account account1 = new Account(1l, "CUST101", 3000.0, "Savings", "Samuel F", null);
		when(accountRepository.save(account1)).thenReturn(account1);
		AccountCreationStatus status = accountServiceImpl.createAccount("CUST101", account1);
		assertEquals("Sucessfully Created", status.getMessage());
	}

	@Test
	void hasPermissionTest1() {
		when(authFeignClient.getValidity("token")).thenReturn(new AuthenticationResponse("CUST101", "Pratik B", true));
		assertTrue(accountServiceImpl.hasPermission("token").isValid());
	}

	@Test
	void hasPermissionTest2() {
		when(authFeignClient.getValidity("token")).thenThrow(new AccessDeniedException());
		assertThrows(AccessDeniedException.class, () -> accountServiceImpl.hasPermission("token"));
	}

	@Test
	void hasCustomerPermissionTest1() {
		when(authFeignClient.getValidity("token")).thenReturn(new AuthenticationResponse("CUST101", "Pratik B", true));
		when(authFeignClient.getRole("CUST101")).thenReturn("CUSTOMER");
		assertTrue(accountServiceImpl.hasCustomerPermission("token").isValid());
	}

	@Test
	void hasCustomerPermissionTest2() {
		when(authFeignClient.getValidity("token")).thenThrow(new AccessDeniedException("NOT ALLOWED"));
		assertThrows(AccessDeniedException.class, () -> accountServiceImpl.hasCustomerPermission("token"));
	}

	@Test
	void hasEmployeePermissionTest1() {
		when(authFeignClient.getValidity("token")).thenReturn(new AuthenticationResponse("EMP101", "Pratik B", true));
		when(authFeignClient.getRole("EMP101")).thenReturn("EMPLOYEE");
		assertTrue(accountServiceImpl.hasEmployeePermission("token").isValid());
	}

	@Test
	void hasEmployeePermissionTest2() {
		when(authFeignClient.getValidity("token")).thenThrow(new AccessDeniedException("NOT ALLOWED"));
		assertThrows(AccessDeniedException.class, () -> accountServiceImpl.hasEmployeePermission("token"));
	}

	@Test
	void updateBalanceTest() {
		Account account1 = new Account(1l, "CUST101", 4000.0, "Savings", "Samuel F", null);
		Account account2 = new Account(1l, "CUST101", 3500.0, "Savings", "Samuel F", null);
		when(accountRepository.findByAccountId(1l)).thenReturn(account1);
		when(accountRepository.save(account1)).thenReturn(account2);
		AccountInput ai = new AccountInput(1, 500);
		Account testAccount = accountServiceImpl.updateBalance(ai);
		assertEquals(3500, testAccount.getCurrentBalance());
	}

	@Test
	void updateDepositBalanceTest() {
		Account account1 = new Account(1l, "CUST101", 3000.0, "Savings", "Samuel F", null);
		Account account2 = new Account(1l, "CUST101", 3500.0, "Savings", "Samuel F", null);
		when(accountRepository.findByAccountId(1l)).thenReturn(account1);
		when(accountRepository.save(account1)).thenReturn(account2);
		AccountInput ai = new AccountInput(1, 500);
		Account testAccount = accountServiceImpl.updateDepositBalance(ai);
		assertEquals(3500, testAccount.getCurrentBalance());
	}
}
