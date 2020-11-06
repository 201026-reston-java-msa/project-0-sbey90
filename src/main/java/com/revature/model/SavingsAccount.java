package com.revature.model;

public class SavingsAccount {
	
	private double balance;
	private double interest = 2.9;
	
	
	
	public SavingsAccount(double balance, double interest) {
		this.balance = balance;
		this.interest = interest;
	}
	
	public SavingsAccount() {
		
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public double getInterest() {
		return interest;
	}



	public void setInterest(double interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "SavingsAccount [balance=" + balance + ", interest=" + interest + "]";
	}

	
	
}
