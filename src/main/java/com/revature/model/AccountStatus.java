package com.revature.model;

public class AccountStatus {
	
	private boolean status;

	public AccountStatus(boolean status) {
		this.status = status;
	}
	
	public AccountStatus() {
		
	}

	
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AccountStatus [status=" + status + "]";
	}
	
	
	
	

}
