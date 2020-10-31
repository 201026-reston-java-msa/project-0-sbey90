package BankingApp;

import java.util.ArrayList;

public class Customer extends FundAutomation implements JointAccount {
	
	private String name; // may need to adjust implementation -- should be handled by our getter and setter
	private long accountNumber;
	private String password;
	private String username;
//	private double balance;
	
	// private double balance (can possibly be included in an ArrayList)
	
	public static ArrayList<Double> balance = new ArrayList<Double>();
	
	
	
	
	
	
	
	public Customer(long accountNumber, String password, String username, String name, double initialAmount) {
		
		this.accountNumber = accountNumber;
		this.password = password;
		this.username = username;
		this.name = name;
		this.balance = new ArrayList<Double>();
		deposit(initialAmount);
		
	}
	
	public Customer() {
		
	}

	/*public Customer(String name, double initialAmount) {
		this.name = name;
		this.transactions = new ArrayList<Double>();
	} */


	// Instance Methods
	/*
	 * register();
	 * isUserNameTaken();
	 * isLoginCorrect();
	 * addTransaction(); -- concrete method (done - withdraw)
	 * 
	 *  All will come from UserDataStore Interface
	 */
	
	
	
	
	// Getters
	
	
	public long getAccountNumber() {
		return accountNumber;
	}

	

	public String getName() {
		return name;
	}


	public String getPassword() {
		return password;
	}



	public String getUsername() {
		return username;
	}


	
	// Setters
	public void setPassword(String password) {
		this.password = password;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	
	// Inherited Instance Methods
	@Override
	public void withdraw(double amount) {
		for(int i = 0; i < balance.size(); i++) {
			Customer customer = new Customer();
			double customerBalance = customer.balance.get(i);
			if(amount > customerBalance) {
				// Create custom OverdraftException to be thrown here
				System.out.println("Insufficient funds."); 
			} else {
				customerBalance -= amount;
			}
		}
//		return customerBalance;	
	}
	

	@Override
	public void deposit(double amount) {
		this.balance.add(amount);
		
	} 


	@Override
	public void transfer(Customer customer, double x) {
		
		for(int i = 0; i < balance.size(); i++) {
			Customer cust = new Customer();
			double customerBalance = cust.balance.get(i);
			if(x < customerBalance) {
				withdraw(x);
				customer.deposit(x);
				System.out.println("Transfer successful. Transferred: $"+ x);
			} else {
				System.out.println("Unable to complete transfer.");
			}
		}
		
	}



	public void accountJoin() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	// Note: employeeNumber may need to be converted to a Customer ID or Account Number
	
	
	
	

}
