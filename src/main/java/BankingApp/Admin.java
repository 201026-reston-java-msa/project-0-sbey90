package BankingApp;

public class Admin implements AccountAdjustment {
	
	private String name;
	private long employeeNumber;
	
	
	// Constructor
	public Admin(String name, long employeeNumber) {
		this.name = name;
		this.employeeNumber = employeeNumber;
	}


	
	// Instance Methods
	
	
	// Getters and Setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getEmployeeNumber() {
		return employeeNumber;
	}


	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}



	
	
	public void viewAndEdit() {
		// TODO Auto-generated method stub
		
	}



	public void approveAndDeny() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
