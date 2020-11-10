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

	// Instance Methods

	public double checkBalance() {
		return this.balance;

	}

	public void transfer(CheckingAccount checking, double amount) {

		if (amount > balance) {
			System.out.println("Insufficient funds.");
		} else {
			balance -= amount;
			checking.deposit(amount);
		}

	}

	public double deposit(double amount) {
		if (amount > 0) {
			System.out.println("You have deposited: " + amount);
			this.balance += (amount + this.interest);
		} 
		return balance;
	}

	public double withdraw(double amount) {
		if (amount > this.balance) {
			System.out.println("Insufficent funds.");
		} else {
			System.out.println("You have withdrawn: " + amount);
			System.out.println("Current balance: " + this.balance);
		}
		return balance -= amount;
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
