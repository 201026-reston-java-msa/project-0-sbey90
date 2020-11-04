package com.revature.daorepos.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.daorepos.CustomerDAO;
import com.revature.model.Customer;

/*
 * This class implements above interface. 
 * This class is responsible to get data from a data source which can be database / xml or any other storage mechanism.
 */

public class CustomerDAOImpl implements CustomerDAO {
	
	
	
	public CustomerDAOImpl(List<Customer> customers) {
		this.customers = new ArrayList<Customer>();
	}

	private static Logger log = Logger.getLogger(CustomerDAOImpl.class);
	
	List<Customer> customers;
	
	
	

	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		
	}

	public void deposit(double amount) {
		// TODO Auto-generated method stub
		
	}

	public void transfer(double amount) {
		// TODO Auto-generated method stub
		
	}

	public void jointAccount() {
		// TODO Auto-generated method stub
		
	}

	public List<Customer> findAll() {   // may remove later
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
