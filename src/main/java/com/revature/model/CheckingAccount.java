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

	public double checkBalance(double balance) {
		return this.balance;

	}

	public double transfer(double savings, double amount) {
		SavingsAccount savingsAccount = new SavingsAccount(); // testing

		if (amount > balance) {
			System.out.println("Insufficient funds.");
		} else {
			balance -= amount;
			this.withdraw(amount);
			savings = amount;
			savingsAccount.deposit(amount);
			System.out.println("Savings Balance: " + (savings + amount)); // See what happens
		}
		return savings;
	}

	public double deposit(double amount) {
		if (amount > 0) {
			System.out.println("You have deposited: " + amount);
			this.balance += amount;

		}
		System.out.println("Current Balance: " + this.balance);
		return balance;
	}

	public double withdraw(double amount) {
		if (amount > this.balance) {
			System.out.println("Insufficent funds.");
		} else {
			balance -= amount;
			System.out.println("You have withdrawn: " + amount);
			System.out.println("Current balance: " + this.balance);
		}
		return balance;
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
