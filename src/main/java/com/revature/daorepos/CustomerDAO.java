package com.revature.daorepos;



import java.util.List;

import com.revature.model.Customer;

// Implemented by DB


/*
 * This will define the standard operations to be performed on model objects.
 */
public interface CustomerDAO {
	
	public List<Customer> findAll(); // may remove later
	/*
	 * May want to move the methods below into interfaces and place those interfaces into an interface folder within the Service Package
	 */
	public void withdraw(double amount);
	public void deposit(double amount);
	public void transfer(double amount);
	public void jointAccount();
}
