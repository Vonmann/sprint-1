package com.capgemini.pecuniafinance.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class TransactionServiceImplTest {
	static TransactionServiceImpl service;

	@BeforeAll
	public  void getObject() {
		service = new TransactionServiceImpl();
	}

	@Test
	public void isValidAccountNumber() {

		// String value= c.getAccountNumber();
		boolean flag= service.isValidAccountNumber("123456789012");
		assertEquals(true, flag);

	}
	@Test
	
	public void isValidChequeNumber() {
		boolean flag=service.isValidChequeNumber("123456");
		assertEquals(true, flag);
		
	}
	
	public void isValidChequeIFSC() {
		boolean flag=service.isValidChequeIFSC("SBIN012345");
		assertEquals(true, flag);
		
	}

}
