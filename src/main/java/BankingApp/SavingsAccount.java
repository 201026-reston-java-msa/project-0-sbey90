package BankingApp;

import java.util.ArrayList;
import java.util.Scanner;

public class SavingsAccount extends Account {
	
	private static double interestAmount = 2.9;
	private double balance;
	
	
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	
	public SavingsAccount(double balance) {
		super();
		this.balance = balance;
	}
	
	public SavingsAccount() {
		
	}
	
	
	
	@Override
	public void deposit(double amount) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter deposit amount: ");
		amount = scan.nextDouble();
		Customer cust = new Customer();
		if(customers.contains(cust)) {
			balance = customers.indexOf(cust); // test
			balance += amount + interestAmount;
		}
		
	}
	
	
	@Override
	public void transfer(double x) {
		Customer customer = new Customer();
		if (x <= customers.indexOf(balance)) {
			withdraw(x); 
			customer.deposit(x);
			System.out.println("Transfer successful. Transferred: $" + x);
		} else {
			System.out.println("Unable to complete transfer.");
		}

	}
	
	@Override
	public void withdraw(double amount) { 
	//	balance = customers.indexOf(balance); // test
		if(amount > balance) {
			System.out.println("Insufficient funds.");
		} else {
			balance -= amount;
		}

	}

	public double getBalance(double x) { // Not sure if this is acceptable
		return balance;
	}
	
	
	

}
