package BankingApp;

public class Employee extends Admin implements AccountAdjustment {
	
	// We'll need to be able find a customer and add a customer to a list in this class
	// We'll also need to be able to view a list of customers and all of their information
	
	
	// Constructor
	public Employee(String name, long employeeNumber) {
		super(name, employeeNumber);
	}

	
	// print either a list of customers and a list of a particular customers info or just the particular
	// customers info (both would be ideal)
	public void view() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void edit() {
		// TODO Auto-generated method stub
	}

	// if approved we need to add customer to the list -- if not then deny the addition and alert customer 
	public void approveAndDeny() {
		// TODO Auto-generated method stub
		
	}

	
}
