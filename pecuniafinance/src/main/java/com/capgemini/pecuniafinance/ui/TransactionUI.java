package com.capgemini.pecuniafinance.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

import com.capgemini.pecuniafinance.bean.ChequeDetails;
import com.capgemini.pecuniafinance.dao.TransactionUsingChequeDAO;
import com.capgemini.pecuniafinance.dao.TransactionUsingChequeDAOImpl;
import com.capgemini.pecuniafinance.exception.AccountException;
import com.capgemini.pecuniafinance.exception.AmountLessException;
import com.capgemini.pecuniafinance.service.TransactionService;
import com.capgemini.pecuniafinance.service.TransactionServiceImpl;

public class TransactionUI {
	static TransactionService ts = new TransactionServiceImpl();
	static ChequeDetails cd = new ChequeDetails();
	static TransactionUsingChequeDAO transactionService = new TransactionUsingChequeDAOImpl();
	static Random random = new Random();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		for (;;) {
			int choice;
			System.out.println("Ent");
			System.out.println("1-Credit Using Cheque");
			System.out.println("2-Debit Using Cheque");
			System.out.println("3-Exit");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				try {
					creditUsingChequeInfo();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					debitUsingChequeInfo();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
				break;

			}
		}
	}

	private static void creditUsingChequeInfo() throws AccountException, AmountLessException {
		System.out.println("Enter payeeAccountNumber ");
		String payeeAccountNumber = "123456789012";//scan.next();
		//cd.setPayeeAccountNumber(payeeAccountNumber);
		System.out.println("Enter account number");
		String accountNumber = "123456789012";//scan.next();
		cd.setAccountNumber(accountNumber);
		System.out.println("Enter cheque number");
		String chequeNumber = "123456";//scan.next();
		cd.setChequeNumber(chequeNumber);
		System.out.println("Enter  cheque IFSC code");
		String chequeIFSC = "SBIN012345";//scan.next();
		cd.setChequeIFSC(chequeIFSC);
		System.out.println("Enter amount to be credited");
		int amount = 2000;//scan.nextInt();
		cd.setAmount(amount);
		System.out.println("Enter Bank name");
		String chequeBankName = scan.next();
		cd.setChequeBankName(chequeBankName);
		System.out.println("Enter Date");
		String date = "20-02-2020";//scan.next();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate chequeIssueDate = LocalDate.parse(date, format);
		cd.setChequeIssueDate(chequeIssueDate);
		boolean isValid = ((TransactionServiceImpl) ts).isValid(cd);

		if (isValid) {

			if (transactionService.creditUsingCheque(accountNumber, payeeAccountNumber, chequeNumber, chequeBankName,
					chequeIFSC, chequeIssueDate, amount) == true) {
				System.out.println("TRANSACTION ID: " + random.nextInt(100000000) + " Deposited " + amount
						+ ".RS to accountNumber " + accountNumber + " using cheque " + chequeNumber
						+ " Successfully total amount = " + transactionService.getBalanceByID(accountNumber) + "\n"
						+ " BankName - " + chequeBankName);

			} else {

				throw new AmountLessException("please enter the amount in the valid range");
			}
		}

		else {

			throw new AccountException("Please enter valid input details");
		}

	}

	private static void debitUsingChequeInfo() throws AmountLessException, AccountException {
		System.out.println("Enter account number");
		String accountNumber = scan.next();
		cd.setAccountNumber(accountNumber);
		System.out.println("Enter cheque number");
		String chequeNumber = scan.next();
		cd.setChequeNumber(chequeNumber);
		System.out.println("Enter  cheque IFSC code");
		String chequeIFSC = scan.next();
		cd.setChequeIFSC(chequeIFSC);
		System.out.println("Enter amount to be debited");
		int amount = scan.nextInt();
		cd.setAmount(amount);
		System.out.println("Enter Date");
		String date = scan.next();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate chequeIssueDate = LocalDate.parse(date, format);
		cd.setChequeIssueDate(chequeIssueDate);
		boolean isValidd = ((TransactionServiceImpl) ts).isValidd(cd);

		if (isValidd) {

			if (transactionService.debitUsingCheque(accountNumber, chequeNumber, chequeIFSC, chequeIssueDate,
					amount) == true) {
				System.out.println("Your Amount is debited with " + "TRANSACTION ID:" + random.nextInt(100000000)
						+ " using " + amount + " .rs from " + accountNumber + " and chequeNo " + chequeNumber
						+ " to Account Number = " + accountNumber);
			} else {

				throw new AmountLessException("Insufficient balance");
			}

		} else {

			throw new AccountException("Please enter valid input details");
		}

	}
}
