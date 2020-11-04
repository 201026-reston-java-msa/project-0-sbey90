package com.revature.daorepos;

import java.util.List;

import com.revature.model.Customer;

public interface AdminDAO {

	public List<Customer> findAll();
	public Customer findById(int Id);
	public boolean insert(Customer c);
	public void update(Customer c);
	public void remove(Customer c);
	public void withdraw(double amount);
	public void deposit(double amount);
	public void transfer(double amount);
	public boolean approveOrDeny();

	
	
}
