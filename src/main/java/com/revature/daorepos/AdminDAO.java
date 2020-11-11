package com.revature.daorepos;

import java.util.List;

import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;

public interface AdminDAO {

	public List<Customer> findAll();

	public int findById(int id);  

	public boolean insert(CheckingAccount checking, String username);

	public void remove(Customer c); 

	public void updateCustomerName(Customer c);

	public boolean updateChecking(int id, double checkingBalance);

	boolean updateSavings(int id, double savings);

}
