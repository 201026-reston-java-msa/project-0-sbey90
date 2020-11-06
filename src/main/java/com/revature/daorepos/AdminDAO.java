package com.revature.daorepos;

import java.util.List;

import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;

public interface AdminDAO {

	public List<Customer> findAll();
	public Customer findById(int Id);
	public boolean insert(Customer c);
	
	public void remove(Customer c);
	public void updateCustomerName(Customer c);
	
	public boolean updateChecking(int id, CheckingAccount checking) ;
	public boolean updateSavings(int id, SavingsAccount savings);
	
	
	/*
	 * May want to move the methods below into interfaces and place those interfaces into an interface folder within the Service Package
	 */


	
	
}
