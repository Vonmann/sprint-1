package com.capgemini.pecuniafinance.bean;

import java.time.LocalDate;
import java.util.Date;

public class ChequeDetails {

	private String accountNumber;
	private String payeeAccountNumber;
	private String chequeNumber;
	private String chequeBankName;
	private String chequeIFSC;
	private LocalDate chequeIssueDate;
	private int amount;
	public ChequeDetails(){
		
	}
	public ChequeDetails(String accountNumber, String payeeAccountNumber, String chequeNumber, String chequeBankName,
			String chequeIFSC, LocalDate chequeIssueDate, int amount) {
		super();
		this.accountNumber = accountNumber;
		this.payeeAccountNumber = payeeAccountNumber;
		this.chequeNumber = chequeNumber;
		this.chequeBankName = chequeBankName;
		this.chequeIFSC = chequeIFSC;
		this.chequeIssueDate = chequeIssueDate;
		this.amount = amount;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPayeeAccountNumber() {
		return payeeAccountNumber;
	}
	public void setPayeeAccountNumber(String payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}
	public String getChequeNumber() {
		return chequeNumber;
	}
	public void setChequeNumber(String i) {
		this.chequeNumber = i;
	}
	public String getChequeBankName() {
		return chequeBankName;
	}
	public void setChequeBankName(String chequeBankName) {
		this.chequeBankName = chequeBankName;
	}
	public String getChequeIFSC() {
		return chequeIFSC;
	}
	public void setChequeIFSC(String chequeIFSC) {
		this.chequeIFSC = chequeIFSC;
	}
	public LocalDate getChequeIssueDate() {
		return chequeIssueDate;
	}
	public void setChequeIssueDate(LocalDate chequeIssueDate) {
		this.chequeIssueDate = chequeIssueDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + amount;
		result = prime * result + ((chequeBankName == null) ? 0 : chequeBankName.hashCode());
		result = prime * result + ((chequeIFSC == null) ? 0 : chequeIFSC.hashCode());
		result = prime * result + ((chequeIssueDate == null) ? 0 : chequeIssueDate.hashCode());
		result = prime * result + ((chequeNumber == null) ? 0 : chequeNumber.hashCode());
		result = prime * result + ((payeeAccountNumber == null) ? 0 : payeeAccountNumber.hashCode());
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
		ChequeDetails other = (ChequeDetails) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (amount != other.amount)
			return false;
		if (chequeBankName == null) {
			if (other.chequeBankName != null)
				return false;
		} else if (!chequeBankName.equals(other.chequeBankName))
			return false;
		if (chequeIFSC == null) {
			if (other.chequeIFSC != null)
				return false;
		} else if (!chequeIFSC.equals(other.chequeIFSC))
			return false;
		if (chequeIssueDate == null) {
			if (other.chequeIssueDate != null)
				return false;
		} else if (!chequeIssueDate.equals(other.chequeIssueDate))
			return false;
		if (chequeNumber == null) {
			if (other.chequeNumber != null)
				return false;
		} else if (!chequeNumber.equals(other.chequeNumber))
			return false;
		if (payeeAccountNumber == null) {
			if (other.payeeAccountNumber != null)
				return false;
		} else if (!payeeAccountNumber.equals(other.payeeAccountNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ChequeDetails [accountNumber=" + accountNumber + ", payeeAccountNumber=" + payeeAccountNumber
				+ ", chequeNumber=" + chequeNumber + ", chequeBankName=" + chequeBankName + ", chequeIFSC=" + chequeIFSC
				+ ", chequeIssueDate=" + chequeIssueDate + ", amount=" + amount + "]";
	}
	 
}
