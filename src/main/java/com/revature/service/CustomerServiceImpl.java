package com.revature.service;

import java.util.Scanner;

import com.revature.model.CheckingAccount;
import com.revature.model.SavingsAccount;
import com.revature.serviceinterfaces.CustomerService;

// We will want to incorporate the customer object in order to create these methods 

public class CustomerServiceImpl implements CustomerService {
	
	
	
	public CustomerServiceImpl() {
		// Create customer menu here
		
		/*
		 * I believe that the input that you put here will stay as the menu option
		 * 
		 */
	}
	
	

	
	public double deposit(double amount) {
		CheckingAccount checking = new CheckingAccount();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter deposit amount: ");
		amount = scan.nextDouble();
		double customerBalance = checking.getBalance();
		if(amount >= customerBalance) {
			checking.setBalance(customerBalance + amount); // Keep going 
			double balance = checking.getBalance(); 
			System.out.println("You have successfully deposited: "+ amount);
			System.out.println("Current Balance: " + balance);
		} else {
			// possibly throw exception heres
			System.out.println("Invalid amount.");
		}
		
		return amount;
	}

	
	
	public void withdraw(double amount) {
		CheckingAccount checking = new CheckingAccount();
		Scanner scan = new Scanner(System.in);
		double customerBalance = checking.getBalance() + amount;
		
				
				//deposit(amount);
		System.out.println("Please enter withdrawal amount: ");
		amount = scan.nextDouble();
		
		if( amount > customerBalance) {
		System.out.println("Insufficient funds.");
		} else {
			checking.setBalance(customerBalance - amount);
			double balance = checking.getBalance(); 
			System.out.println("You have successfully wihdrawn: " + amount);
			System.out.println("Current Balance: " + balance);
			
		}
		
	}

	

	// REFACTOR
	public void transfer(double amount) {
		CheckingAccount checking = new CheckingAccount();
		SavingsAccount savings = new SavingsAccount();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an amount to be transferred: ");
		amount = scan.nextDouble();
		double checkingsBalance = checking.getBalance();
		double savingsBalance = savings.getBalance();
		if(amount < checkingsBalance) {
			withdraw(amount);
			savings.setBalance(savingsBalance + amount);
			System.out.println("You have successfully transferred: " + amount);
			System.out.println("Current Savings Balance: " + savingsBalance);
		} else {
			// throw exception here
		}
		
	}

	
	// TEST
	public void applyForAccount(String choice) {
		Scanner scan = new Scanner(System.in);
		choice = scan.nextLine();
		System.out.println("Would you like to apply for an account?\n"
				+"Type Yes/No");
		if(choice.equals("Yes".toLowerCase())) {
			System.out.println("Your application is pending approval.");
		} else if(choice.equals("No".toLowerCase())) {
			System.out.println("Have a great day.");
		} else {
			System.out.println("Invalid entry.");
		}
		
		AdminServiceImpl adminService = new AdminServiceImpl();
		if(adminService.approveOrDeny(true)) {
			System.out.println("Your account has been approved.");
		} else if(adminService.approveOrDeny(false)) {
			System.out.println("Your account has been denied.");
		} else {
			System.out.println("Your account is still pending.");
		}
	}

	
	// LATER
	public void jointAccount() {
		// TODO Auto-generated method stub
		
	}




	
	
	
	

}
