package com.revature.daorepos.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.daorepos.EmployeeDAO;
import com.revature.model.Customer;

public class EmployeeDAOImpl implements EmployeeDAO {

	
	public EmployeeDAOImpl(List<Customer> customers) {
		this.customers = new ArrayList<Customer>();
	}
	
	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);
	
	List<Customer> customers;

	public List<Customer> findAll() {
		return customers;
	}

	public Customer findById(int Id) {
		return customers.get(Id);
	}

	public boolean approveOrDeny() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
