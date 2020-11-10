package com.revature.daorepos;

import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;

public interface CustomerDAO {

	public boolean updateCredentials(String username, String password);

	public boolean insert(Customer c);

	public boolean updateChecking(int id, double checking);

	public boolean updateSavings(int id, double savings);

}
