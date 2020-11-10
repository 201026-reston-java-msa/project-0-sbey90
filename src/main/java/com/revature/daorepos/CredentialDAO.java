package com.revature.daorepos;

import java.util.List;

import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;

public interface CredentialDAO<Customer> {
	
	public List<Customer> findAll();
	public Customer findById(int id);
	public com.revature.model.Customer insert(Customer c);
	public boolean getPassword(String password);
	public boolean getUsername(String username);
	
	

}
