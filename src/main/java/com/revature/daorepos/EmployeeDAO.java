package com.revature.daorepos;

import java.util.List;

import com.revature.model.Customer;

public interface EmployeeDAO {
	
	public List<Customer> findAll();
	public Customer findById(int Id);
	public boolean approveOrDeny();

}
