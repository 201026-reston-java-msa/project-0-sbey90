package com.revature.model;



public class Customer  {
	
	private String firstName;
	private String lastName;
	private int Id;
	private String password;
	private String username;
	private double balance;  
	private CheckingAccount checkingAccount;
	private SavingsAccount savings;
	
	
	
	public Customer(String firstName, String lastName, int Id, String password, String username, double balance, CheckingAccount checkingAccount, SavingsAccount savings) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.Id = Id;
		this.password = password;
		this.username = username;
		this.balance = balance;
		this.checkingAccount = checkingAccount;
		this.savings = savings;
	}

	
	
	
	

	public SavingsAccount getSavings() {
		return savings;
	}

	

	public void setSavings(SavingsAccount savings) {
		this.savings = savings;
	}



	public CheckingAccount getCheckingAccount() {
		return checkingAccount;
	}



	public void setCheckingAccount(CheckingAccount checkingAccount) {
		this.checkingAccount = checkingAccount;
	}





	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	
	
	
	
}



	