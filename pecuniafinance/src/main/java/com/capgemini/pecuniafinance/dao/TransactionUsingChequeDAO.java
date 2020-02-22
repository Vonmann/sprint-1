package com.capgemini.pecuniafinance.dao;

import java.time.LocalDate;

import com.capgemini.pecuniafinance.bean.TransactionModel;



public interface TransactionUsingChequeDAO {
	public boolean addAccountDetails(TransactionModel accountDetails );
	
	 
	public boolean creditUsingCheque(String accountNumber,String payeeAccountNumber,String chequeNumber,String chequeBankName,String chequeIFSC,LocalDate chequeIssueDate,int amount);
	public boolean debitUsingCheque( String accountNumber,String chequeNumber,String chequeIFSC,LocalDate chequeIssueDate,int amount);
	 
	public double getBalanceByID(String accountNumber);
	  
	 public boolean addAmount(String accountNumber,int amount) ;
	 public boolean deductAmount(String accountNumber,int amount) ;
	 	public void addSomeAccountDetails();
	 
}
