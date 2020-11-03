package BankingApp;


public abstract class Account  {
	
	// Account class
	
//	Customer customer = new Customer();
	
	
	
	// Abstract Methods

	
	public abstract void deposit(double amount);
	public abstract void transfer(double x);	
	public abstract void withdraw(double amount); // *** Added customer as a parameter
	
	
	

}
