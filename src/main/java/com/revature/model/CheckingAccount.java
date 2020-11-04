package com.revature.model;

public class CheckingAccount {
	
	private double amount;
	private AccountStatus status;
	
	
	
	public CheckingAccount(double amount, AccountStatus status) {
		this.amount = amount;
		this.status = status;
	}



	
	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public AccountStatus getStatus() {
		return status;
	}



	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	
	
	
	

}
