package com.revature.service;

import java.util.Scanner;

import com.revature.model.AccountStatus;
import com.revature.serviceinterfaces.AdminService;

public class AdminServiceImpl implements AdminService {
	
	public AdminServiceImpl() {
		// Create menu here
	}

	public void withdraw(double amount) {
		CustomerServiceImpl customerTransaction = new CustomerServiceImpl();
		customerTransaction.withdraw(amount);
		
	}

	public void deposit(double amount) {
		CustomerServiceImpl customerTransaction = new CustomerServiceImpl();
		customerTransaction.deposit(amount);
		
	}

	public void transfer(double amount) {
		CustomerServiceImpl customerTransaction = new CustomerServiceImpl();
		customerTransaction.transfer(amount);
		
	}

	// TEST
	public boolean approveOrDeny(boolean status) {
		AccountStatus accountStatus = new AccountStatus();
		Scanner scan = new Scanner(System.in);
		String verdict = scan.nextLine();
//		String standing = accountStatus.getStatus();
		System.out.println("Please type approve or deny for pending account.");
		if(verdict.equals("Approve".toLowerCase())) {
			status = true;
			accountStatus.setStatus(status);
			System.out.println("Account has been approved.");
			return status;
		} else if(verdict.equals("Deny".toLowerCase())){
			status = false;
			accountStatus.setStatus(status);
			System.out.println("Account has been denied.");
			return status;
		}
		return status;
	}

	

}
