package com.capgemini.pecuniafinance.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.capgemini.pecuniafinance.bean.ChequeDetails;
import com.capgemini.pecuniafinance.bean.TransactionModel;
import com.capgemini.pecuniafinance.dao.TransactionUsingChequeDAO;
import com.capgemini.pecuniafinance.dao.TransactionUsingChequeDAOImpl;

//import com.capg.Banking_management.dao.AccountException;


public class TransactionServiceImpl implements TransactionService{
	TransactionUsingChequeDAO transactionDAO=new TransactionUsingChequeDAOImpl();
	public boolean creditUsingCheque(String accountNumber,String payeeAccountNumber, String chequeNumber,
			String chequeBankName, String chequeIFSC, LocalDate chequeIssueDate, int amount) {

		return transactionDAO.creditUsingCheque(accountNumber,payeeAccountNumber,chequeNumber,chequeBankName,chequeIFSC,chequeIssueDate, amount) ;
	}

	public boolean debitUsingCheque(String accountNumber, String chequeNumber, String chequeIFSC, LocalDate chequeIssueDate, int amount) {

		return transactionDAO.debitUsingCheque(accountNumber,chequeNumber,chequeIFSC,chequeIssueDate, amount);
	}
	public static boolean isValidPayeeAccountNumber(String payeeAccountNumber){
		boolean flag;
		 if(payeeAccountNumber.matches("[0-9]{12}")){
			 //System.out.println("pan");
				return true;
		}
		return false; 
	}
	public static boolean isValidChequeBankName(String accountNumber){
		//System.out.println("bankn");
		 		return true;
	}
	public static boolean isValidChequeIssueDate(LocalDate chequeIssueDate){
		LocalDate transactionDate=LocalDate.now();
		 Long months=ChronoUnit.MONTHS.between(chequeIssueDate, transactionDate) ;
		if(months<=3){
		return  true;
		}
		return false;
	}
	public static boolean isValidAccountNumber(String accountNumber){
		boolean flag;
		 if(accountNumber.matches("[0-9]{12}")){
			 //System.out.println("an");
				return true;
		}
	 
		return false; 
	}
 	public static boolean isValidChequeNumber(String chequeNumber){
		//boolean flag;
		 if(chequeNumber.matches("[0-9]{6}")){
			 //System.out.println("cn");
				return true;
		}
		return false; 
	}
 	public static boolean isValidChequeIFSC(String chequeIFSC){
		 
		if(chequeIFSC.matches("^[A-Z]{4}[0][A-Z0-9]{5}$")){    
			//System.out.println("ci");
				return true;
		}
		return false; 
	}

	public static boolean isValidAmount(int amount){
		   
		String str=String.valueOf(amount);
		if(str.matches("[1-9]{1}[0-9]*")){
			 System.out.println("am");
			return true;
		}
		return false; 
	}
	 
	public void addSomeAccountDetails(){
		transactionDAO.addSomeAccountDetails();
	}

	public double getBalanceByID(String accountNumber) {

		return transactionDAO.getBalanceByID( accountNumber) ;
	}

	public boolean addAmount(String accountNumber, int amount) {
		// TODO Auto-generated method stub
		return transactionDAO.addAmount(  accountNumber, amount);
	}

	public boolean deductAmount(String accountNumber, int amount) {
		// TODO Auto-generated method stub
		return transactionDAO.deductAmount(accountNumber,  amount);
	}

	 

	public boolean addAccountDetails(TransactionModel accountDetails) {
 		return transactionDAO.addAccountDetails(accountDetails);
	}

	public boolean isValid(ChequeDetails c){
		 
		if(isValidAccountNumber(c.getAccountNumber())
		&& isValidPayeeAccountNumber(c.getPayeeAccountNumber())&&
		isValidChequeNumber(c.getChequeNumber())&&
		isValidChequeIFSC(c.getChequeIFSC())&&isValidChequeBankName(c.getChequeBankName())&&
		isValidChequeIssueDate(c.getChequeIssueDate())&&
		isValidAmount(c.getAmount())){
			return true;
		}
 
 		return false;
	}

	public boolean isValidd(ChequeDetails c){
		 
		if(isValidAccountNumber(c.getAccountNumber())&&
				isValidChequeNumber(c.getChequeNumber())&&
				isValidChequeIFSC(c.getChequeIFSC())&& 
				isValidChequeIssueDate(c.getChequeIssueDate())&&
				isValidAmount(c.getAmount())){
			return true;
		}
 
 		return false;
	}

	 

}