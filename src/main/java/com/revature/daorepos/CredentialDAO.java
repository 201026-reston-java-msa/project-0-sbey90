package com.revature.daorepos;

import java.util.List;

import com.revature.model.Customer;

public interface CredentialDAO {
	
	public List<Customer> findAll();
	public void register();
	public void customerLogin();
	public void employeeLogin();
	public void adminLogin();
	public boolean approveOrDeny();

}
