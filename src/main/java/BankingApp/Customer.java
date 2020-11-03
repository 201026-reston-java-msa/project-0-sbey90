package BankingApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Account implements JointAccount {
	
	private String name; // may need to adjust implementation -- should be handled by our getter and setter
	private int accountNumber;
	private String password;
	private String username;
	private double balance;  
	
	
	public Customer(int accountNumber, String password, String username, String name, double initialAmount) {
		
		this.accountNumber = accountNumber;
		this.password = password;
		this.username = username;
		this.name = name;
		this.balance = balance;
		deposit(initialAmount);
		
	}
	
	
	public Customer() {
		
		// May need to include this particular in the main class and keep all other constructor lists (admin and employee) in their seperate classes
		// Since this constructor will be called in Admin in order to take care of method functionality 
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Please choose from the options below: \n"
//				+ "1. Register Account\n"
//				+ "2. Log in:\n");
//		String option = scan.nextLine();
//		if(option.toLowerCase().equals("Log in")) {
//			System.out.println("Enter username:\n");
//			this.username = scan.nextLine();
//			System.out.println("Enter Password:\n");
//			this.password = scan.nextLine();
//		} else {
//			// register account here and generate the account number once user is registered
//			generateAccountNumber();
//		}
		// Will also need to add a list to withdraw, deposit, transfer funds, or join an account after log in.
		
		
	}
	


	// Instance Methods
	
	// Generates an account number for the customer -- may need to adjust based off of student DB example
	private void generateAccountNumber() {
		this.accountNumber = (int) (10000000 + (Math.random() * 90000000));
	}
	
	
	
	// Inherited Instance Methods -- Inherited from Account Abstract Class
	
		@Override
		public void withdraw(double amount) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter amount to withdraw: ");
			amount = scan.nextDouble();
				if(amount > balance) {
					// Create custom OverdraftException to be thrown here
					System.out.println("Insufficient funds."); 
				} else {
					balance -= amount;
					System.out.println("You have withdrawn: "+ amount +"\nCurrent Balance: "+ balance);
				}
		}
		

		@Override
		public void deposit(double amount) { 
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter deposit amount: ");
			amount = scan.nextDouble();
			balance += amount;
			System.out.println("You have successfully deposited: "+ amount);
			System.out.println("Your current balance is: "+ balance);
			
		} 


		@Override
		public void transfer(double x) {
			Scanner scan = new Scanner(System.in);
			SavingsAccount savings = new SavingsAccount();
			System.out.println("Please enter amount to be transferred");
			x = scan.nextDouble();
			if (x <= balance) {
				balance -= x;
//				withdraw(x);
				savings.getBalance(x);  
				System.out.println("Transfer successful. Transferred: $" + x);
			} else {
				System.out.println("Unable to complete transfer.");
			}

		}




		public void accountJoin() {
			// TODO Auto-generated method stub
			
		}
	
	
	// Getters
	
	
	public long getAccountNumber() {
		return accountNumber;
	}

	

	

	public double getBalance() {
		return balance;
	}

	// May still need setBalance method, will know later

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
	

	
	
	

}
