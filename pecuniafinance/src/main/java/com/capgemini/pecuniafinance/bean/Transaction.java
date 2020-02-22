package com.capgemini.pecuniafinance.bean;

import java.time.LocalDate;

public class Transaction {
	 
	LocalDate transactionDate;
	
	public Transaction() {
		 
	}

	public Transaction(LocalDate transactionDate) {
		super();
		this.transactionDate = transactionDate;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
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
		Transaction other = (Transaction) obj;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionDate=" + transactionDate + "]";
	}

	 	
}
