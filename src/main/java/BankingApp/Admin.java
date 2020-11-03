package BankingApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Account implements AccountAdjustment {

	private String name;
	private String customerName; // may not need
	private long employeeNumber;
	private double balance;
	
	
	
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public Admin(String name, String customerName, long employeeNumber, double balance) {
		this.name = name;
		this.customerName = customerName;
		this.employeeNumber = employeeNumber;
		this.balance = balance; // may need to change
	}
	
	
	public Admin() {
		
		// May need to ask for name and information here so that it is not hard coded.
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose from the options below:\n"
				+"1. View Customer Acccount Information\n"
				+"2. Edit Customer account\n"
				+"3. Approve/Deny customer account\n"
				+"4. Withdraw\n"
				+"5. Deposit\n"
				+"6. Transfer Funds");
		String option = scan.nextLine();
		// Need to complete
	}

	// Constructor
	public Admin(String name, long employeeNumber, double balance) {
		this.name = name;
		this.employeeNumber = employeeNumber;
		this.balance = balance;
	}

	
	// Instance Methods
	
	
	// Adds new customer account
	@SuppressWarnings("null")
	public boolean addCustomer(Customer customer, String customerName, double initialAmount) {
		Customer exisitingcustomer = findCustomer(customerName);
		if(exisitingcustomer == null) {
			customers.add(customer);
			return true;
		} else {
			System.out.println("Customer already exsists.");
			return false;
		} 
	}
	
	// Protected because method is used inside of this class and Employee class in order to locate customer
	protected Customer findCustomer(String customerName) {
		for(int i = 0; i < customers.size(); i++) {
			Customer cust = customers.get(i);
			if(cust.getName().equals(customerName)) {
				return cust;
			} 
		}
		return null;
	}
	
	

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

	
	// Test
	public void view(String customerName) {
		Customer customer = new Customer();
		if(customers.contains(customerName)) {
			System.out.println("Customer information: " 
			+ customer.getName()+"\n"
			+ customer.getUsername()+"\n"
			+ customer.getPassword()+"\n"
			+ customer.getBalance()); 
		} else {
			System.out.println("Customer is not on file.");
		}

	}

	// Inherited from AccountAdjustment Interface
	
	public void edit() {
		// replace();
		// may need to be implemented once the DB is configured
	}

	public void approveAndDeny() {
		// TODO Auto-generated method stub
		// make boolean
		// if customer.register() is true
		// return true;
		// sysout("Customers account has been approved.");
		//else 
		//sysout("Customers account has been denied.");
		// return false;

	}

	// Logic is liable to change
	// Possibly incorporate a list of customer accounts and remove customer from list
	public double cancel() {
		this.balance = 0.0;
		return balance;
	}

	
	// Inherited from Account Abstract Class
	
	// Test
	@Override
	public void deposit(double amount) {
		Customer customer = new Customer();		
		customer.deposit(amount);			
	}

	
	// Test
	@Override
	public void transfer(double x) {
		Customer customer = new Customer();
		customer.transfer(x);
//		SavingsAccount savings = new SavingsAccount();
//		if (x <= customers.indexOf(balance)) {
//		//	withdraw(x);
//			savings.deposit(x);
//			System.out.println("Transfer successful. Transferred: $" + x);
//		} else {
//			System.out.println("Unable to complete transfer.");
//		}

	}

	// Test -- Output = Insufficient funds but works in customer class (Look over)
	@Override
	public void withdraw(double amount) { 
		Customer customer = new Customer(); // This calls the constructor defined in Customer class which is a problem
		customer.withdraw(amount); 		
		}


}
