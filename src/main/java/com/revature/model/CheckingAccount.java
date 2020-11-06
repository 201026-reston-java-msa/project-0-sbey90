package com.revature.model;

public class CheckingAccount {
	
	private double balance;
	private AccountStatus status;
	
	
	
	public CheckingAccount(double balance, AccountStatus status) {
		this.balance = balance;
		this.status = status;
	}
	
	
	
	public CheckingAccount() {
		
	}

	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public AccountStatus getStatus() {
		return status;
	}



	public void setStatus(AccountStatus status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "CheckingAccount [balance=" + balance + ", status=" + status + "]";
	}
	
	
	
	

}
