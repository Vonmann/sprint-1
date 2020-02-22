package com.capgemini.pecuniafinance.bean;

import java.util.List;
import java.sql.Date;

public class TransactionModel {
	 
	String accountNumber;
	String accountHolderName;
	double balance;
	
	
	List<Transaction> transaction;


	public TransactionModel(String accountNumber, String accountHolderName, double balance,
			List<Transaction> transaction) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.transaction = transaction;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountHolderName() {
		return accountHolderName;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public List<Transaction> getTransaction() {
		return transaction;
	}


	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountHolderName == null) ? 0 : accountHolderName.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transaction == null) ? 0 : transaction.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionModel other = (TransactionModel) obj;
		if (accountHolderName == null) {
			if (other.accountHolderName != null)
				return false;
		} else if (!accountHolderName.equals(other.accountHolderName))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (transaction == null) {
			if (other.transaction != null)
				return false;
		} else if (!transaction.equals(other.transaction))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TransactionModel [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", balance=" + balance + ", transaction=" + transaction + "]";
	}


 	 


	 	
}