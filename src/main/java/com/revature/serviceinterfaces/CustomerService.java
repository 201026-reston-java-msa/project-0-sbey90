package com.revature.serviceinterfaces;

public interface CustomerService {
	
	public double deposit(double amount);
	public void withdraw(double amount);
	public void transfer(double amount);
	public void applyForAccount(String choice);
	public void jointAccount();

}
