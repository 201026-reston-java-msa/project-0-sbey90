package com.revature.model;

public class SavingsAccount {
	
	private double amount;
	private double interest = 2.9;
	
	
	
	public SavingsAccount(double amount, double interest) {
		this.amount = amount;
		this.interest = interest;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public double getInterest() {
		return interest;
	}



	public void setInterest(double interest) {
		this.interest = interest;
	}

	
	
}
