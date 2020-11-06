package com.revature.daorepos;

import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;

public interface CustomerDAO {

	public boolean updateCredentials(String username, String password);
	public boolean updateChecking(int id, CheckingAccount checking) ;
	public boolean updateSavings(int id, SavingsAccount savings);
	
	
	

}
