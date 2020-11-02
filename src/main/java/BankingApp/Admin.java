package BankingApp;

import java.util.ArrayList;

public class Admin extends FundAutomation implements AccountAdjustment {

	private String name;
	private long employeeNumber;
	private double balance;
	
	private static ArrayList<Customer> customer1 = new ArrayList<Customer>();

	// Constructor
	public Admin(String name, long employeeNumber, double balance) {
		this.name = name;
		this.employeeNumber = employeeNumber;
		this.balance = balance;
	}

	// Second Constructor
	public Admin(String name, long employeeNumber) {
		this.name = name;
		this.employeeNumber = employeeNumber;
	}

	
	
	// Instance Methods
	
	
	// Adds new customer account and adds accountNumber for customer
	@SuppressWarnings("null")
	public boolean addCustomer(String customerName, double initialAmount) {
		Customer existingCustomer = findCustomer(customerName);
		if(existingCustomer == null) {
			existingCustomer.deposit(initialAmount);
			existingCustomer.generateAccountNumber(customerName);
			return true;
		} else {
			System.out.println("Customer already exsists.");
			return false;
		}
	}
	
	// Used inside of this class in order to locate customer
	private Customer findCustomer(String customerName) {
		for(int i = 0; i < customer1.size(); i++) {
			Customer cust = customer1.get(i);
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
		if(customer1.contains(customerName)) {
			System.out.println("Customer information: " 
			+ customer.getName()+"\n"
			+ customer.getUsername()+"\n"
			+ customer.getPassword()+"\n"
//			+ customer.getBalance()  // ArrayList is static and will not allow me to call the method here due to this
			); 
		} else {
			System.out.println("Customer is not on file.");
		}

	}

	public void edit() {
		// replace();
	}

	public void approveAndDeny() {
		// TODO Auto-generated method stub

	}

	// Logic is liable to change
	// Possibly incorporate a list of customer accounts and remove customer from list
	public double cancel() {
		balance = 0.0;
		return balance;
	}

	
	// Re-factor -- May still need
	/*public void deposit(String customerName, double amount) {
		Customer customerExsists = findCustomer(customerName);
		if(customerExsists != null) {
			customerExsists.deposit(amount);
		}
	}*/
	
	
	// Test
	@Override
	public void deposit(double amount) {
		Customer cust = new Customer();
		if(customer1.contains(cust)) {
			balance = customer1.indexOf(cust); // test
			balance += amount;
		}
		
	}

	
	// Test
	@Override
	public void transfer(Customer customer, double x) {
//		Customer customer1.balance = new Customer();
		if (x <= customer1.indexOf(balance)) {
			withdraw(x);
			customer.deposit(x);
			System.out.println("Transfer successful. Transferred: $" + x);
		} else {
			System.out.println("Unable to complete transfer.");
		}

	}

	
	// Test
	@Override
	public void withdraw(double amount) {
		balance = customer1.indexOf(balance); // test
		if(amount > balance) {
			System.out.println("Insufficient funds.");
		} else {
			balance -= amount;
		}
		
	//	return balance;

	}

}
