package com.revature.serviceinterfaces;

public interface AdminService {
	
	public void withdraw(double amount);
	public void deposit(double amount);
	public void transfer(double amount);
	public boolean approveOrDeny(boolean status);

}
