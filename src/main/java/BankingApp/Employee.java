package BankingApp;

import java.util.Scanner;

public class Employee extends Admin implements AccountAdjustment {
	
	// We'll need to be able find a customer and add a customer to a list in this class
	// We'll also need to be able to view a list of customers and all of their information
	
	
	// Constructor
	public Employee() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please choose from the list below\n"
				+"1. View Customer Information:\n"
				+"2. Approve/Deny Customer Account");
		String option = scan.nextLine();
		// if/else logic depending on the chosen option
	}

	
	// print either a list of customers and a list of a particular customers info or just the particular
	// customers info (both would be ideal)
	public void view(String customerName) {
		
		Admin administrator = new Admin();
		Customer customer = new Customer();
		if(administrator.findCustomer(customerName) != null) {
			System.out.println("Customer information: " 
					+ customer.getName()+"\n"
					+ customer.getUsername()+"\n"
					+ customer.getPassword()+"\n"
					+ customer.getBalance()); 
				} else {
					System.out.println("Customer is not on file.");
		}
		
	}
	
	
	public void edit() {
		// TODO Auto-generated method stub
	}

	// if approved we need to add customer to the list -- if not then deny the addition and alert customer 
	public void approveAndDeny() {
		// TODO Auto-generated method stub
		
	}

	
}
