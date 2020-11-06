package com.revature.model;



public class Customer  {
	
	private String firstName;
	private String lastName;
	private int Id;
	private String password;
	private String username;  
	private CheckingAccount checkingAccount;
	private SavingsAccount savings;
	
	
	
	public Customer(int Id, String firstName, String lastName, String password, String username,CheckingAccount checkingAccount, SavingsAccount savings) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.Id = Id;
		this.password = password;
		this.username = username;
		this.checkingAccount = checkingAccount;
		this.savings = savings;
	}
	
	public Customer() {
		
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

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", Id=" + Id + ", password=" + password
				+ ", username=" + username + ", checkingAccount=" + checkingAccount + ", savings=" + savings + "]";
	}


	
	
	
	
	
}



	