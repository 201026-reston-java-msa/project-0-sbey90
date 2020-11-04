package com.revature.daorepos.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.daorepos.AdminDAO;

import com.revature.model.Customer;

public class AdminDaoImpl implements AdminDAO{
	
	public AdminDaoImpl(List<Customer> customers) {
		this.customers = new ArrayList<Customer>();
	}

	private static Logger log = Logger.getLogger(AdminDaoImpl.class);
	
	List<Customer> customers;
	
	

	public Customer findById(int Id) {
		return customers.get(Id);
		
	}

	public boolean insert(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void update(Customer c) {
		customers.get(c.getId()).setFirstName(c.getFirstName());
		customers.get(c.getId()).setLastName(c.getLastName());
		System.out.println("Customer: ID: " + c.getId() + ", has been updated in the Database.");
	}

	public void remove(Customer c) {
		customers.remove(c.getId());
		System.out.println("Customer Account Id: "+ c.getId() +" has been removed from the Database.");
		
	}

	public List<Customer> findAll() {
		return customers;
	}

	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		
	}

	public void deposit(double amount) {
		// TODO Auto-generated method stub
		
	}

	public void transfer(double amount) {
		// TODO Auto-generated method stub
		
	}

	public boolean approveOrDeny() {
		// TODO Auto-generated method stub
		return false;
	}

}
