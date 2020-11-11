package com.revature.service;

import java.util.ArrayList;
import java.util.List;
// CHECK METHODS
import java.util.Scanner;

import com.revature.bankingapp.Main;
import com.revature.daorepos.AdminDAO;
import com.revature.daorepos.CredentialDAO;
import com.revature.daorepos.CustomerDAO;
import com.revature.daorepos.impl.CustomerDAOImpl;
import com.revature.exception.OverdraftException;
import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;

public class CustomerServiceImpl extends CustomerDAOImpl {

	CheckingAccount checking = new CheckingAccount();
	SavingsAccount savingsAccount = new SavingsAccount();

	public CustomerServiceImpl(ArrayList<Customer> customers) {
		super(customers);

		Scanner scan = new Scanner(System.in);

		System.out.println("Please choose a number option from the list below: \n" + "1. - Checking Withdraw\n"
				+ "2. - Checking Deposit\n" + "3. - Transfer Funds\n");
		int option = scan.nextInt();

		while (option != 5) {

			double amount = 0;
			double savings = 0;
			double balance = 0;
			int id = 0;

			switch (option) {

			case 1:
				withdraw(amount);
				break;
			case 2:
				deposit(amount, id);
				break;
			case 3:
				transfer(savings, amount);
				break;
			default:
				Main.run();
			}
			System.out.println("Thank you for choosing Nette's Bank!");
			if (option != 5) {
				System.out.println("Please choose a number option from the list below: \n" + "1. - Checking Withdraw\n"
						+ "2. - Checking Deposit\n" + "3. - Transfer Funds\n");
				option = scan.nextInt();
			}

		}

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

	public void checkBalance() {
		System.out.println("Current Balance: " + super.getBalance());
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
			updateSavings(1, savingsAccount.getBalance() + amount);
			return transfer;
		}
	}

}
