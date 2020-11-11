package com.revature.service;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bankingapp.Main;
import com.revature.daorepos.AdminDAO;
import com.revature.daorepos.impl.AdminDaoImpl;
import com.revature.exception.OverdraftException;
import com.revature.model.AccountStatus;
import com.revature.model.Admin;
import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;

public class AdminServiceImpl extends AdminDaoImpl {

	private static Logger log = Logger.getLogger(AdminServiceImpl.class);

	AdminDAO adminDao;
	CheckingAccount checking = new CheckingAccount();
	SavingsAccount savingsAccount = new SavingsAccount();
	Customer c = new Customer();

	public AdminServiceImpl(List<Customer> customers) {
		super(customers);

		Scanner scan = new Scanner(System.in);
		System.out.println("Please choose a number from the options listed below: \n" + "1. - Create New Account\n"
				+ "2. - View customer accounts\n" + "3. - Customer Checking Withdraw\n"
				+ "4. - Customer Checking Deposit\n" + "5. - Customer Tranfer Funds\n"
				+ "6. - Remove Customer Account\n" + "7. - Approve or Deny Account");
		int option = scan.nextInt();

		while (option != 8) {

			double amount = 0;
			double savings = 0;
			double balance = 0;
			int id = 0;
			String u = "";
			String name = "";
			String verdict = "";

			switch (option) {

			case 1:
				newAccount(checking, u);
			case 2:
				searchCustomer(c, id);
				break;
			case 3:
				withdraw(amount);
				break;
			case 4:
				deposit(amount, id);
				break;
			case 5:
				transfer(savings, amount);
				break;
			case 6:
				removeCustomer(c, id); // FIX
				break;
			case 7:
				approveOrDeny(c, verdict);
			default:
				Main.run();
			}
			System.out.println("Thank you for choosing Nette's Bank!");
			if (option != 8) {
				System.out.println(
						"Please choose a number from the options listed below: \n" + "1. - Create New Account\n"
								+ "2. - View customer accounts\n" + "3. - Customer Checking Withdraw\n"
								+ "4. - Customer Checking Deposit\n" + "5. - Customer Tranfer Funds\n"
								+ "6. - Remove Customer Account\n" + "7. - Approve or Deny Account");
				option = scan.nextInt();
			}
		}

	}

	public void newAccount(CheckingAccount account, String username) {
		System.out.println("Please press enter to create new user account.");
		insert(account, username);
		log.info("Account created.");
		System.out.println("User's account has been created.");
	}

	public double deposit(double amount, int account_id) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an amount to deposit:\n");
		amount = scan.nextInt();

		if (amount > 0) {
			super.setBalance(super.getBalance() + amount);
			super.getBalance();
			updateChecking(1, super.getBalance());
		} else {
			throw new OverdraftException("Insufficient funds.");
		}

		return super.getBalance();
	}

	@Override
	public double withdraw(double amount) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an amount to withdraw:\n");
		amount = scan.nextInt();

		if (amount > super.getBalance()) {

			throw new OverdraftException("Attempted to withdraw too many funds.");

		} else if (super.getBalance() >= 0) {
			super.setBalance(super.getBalance() - amount);
			System.out.println(super.getBalance());
			updateChecking(1, super.getBalance());
		} else {
			System.out.println("Unable to fulfill your request.");
		}

		return super.getBalance();
	}

	@Override
	public double transfer(double savings, double amount) {
		System.out.println("You must enter a number here. If you wish to bypass the next prompt enter 0.");
		Scanner scan = new Scanner(System.in);
		amount = scan.nextDouble();

		if (amount < 0) {
			throw new OverdraftException("Insufficient Funds.");
		} else {
			double transfer = super.transfer(savings, amount);
			updateChecking(1, super.getBalance());
			updateSavings(1, savingsAccount.getBalance() + amount); // CHECK
			return transfer;
		}
	}

	public void removeCustomer(Customer c, int id) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the id of the user you would like to remove.");
		id = scan.nextInt();
		findById(id);
		if (c != null) {
			remove(c);
			log.info("Removed customer from database.");
		}
	}

	public void searchCustomer(Customer c, int id) {
		System.out.println("List of customers: \n" + findAll());
	}

	public boolean approveOrDeny(Customer c, String verdict) {
		Scanner scan = new Scanner(System.in);
		System.out
				.println("Customer has sent a request to open a new account!\n" + "type yes to approve, or no to deny");
		verdict = scan.nextLine();

		if (verdict.equals("YES".toLowerCase())) {
			System.out.println("Customers request has been approved.");
			return true;
		} else if (verdict.equals("NO".toLowerCase())) {
			System.out.println("Customers request has been denied.");
			return false;
		} else {
			System.out.println("Incorrect entry.");
			return false;
		}
	}

}
