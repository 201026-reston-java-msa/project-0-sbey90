package com.revature.daorepos;

import java.util.List;

import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;

public interface EmployeeDAO {
	
	public List<Customer> findAll();
	public int findById(int Id);
	public boolean insert(Customer c);
	
	
	

	
	
	
	

}
