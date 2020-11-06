package com.revature.model;


public class Admin {

	private String firstName;
	private String lastName;
	private int adminId;
	
	
	
	
	public Admin(String firstName, String lastName, int adminId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adminId = adminId;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public int getAdminId() {
		return adminId;
	}




	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}




	@Override
	public String toString() {
		return "Admin [firstName=" + firstName + ", lastName=" + lastName + ", adminId=" + adminId + "]";
	}
	
	
	
	
	
	



	


}
