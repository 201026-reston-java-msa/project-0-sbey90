package BankingApp;

public class Admin extends FundAutomation implements AccountAdjustment {

	private String name;
	private long employeeNumber;
	private double balance;

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

	
	
	public void view() {
		// TODO Auto-generated method stub

	}

	public void edit() {
		// TODO Auto-generated method stub
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

	
	// Refactor
	@Override
	public double deposit(double amount) {
		balance += amount;
		return balance;

	}

	
	// Refactor
	@Override
	public void transfer(Customer customer, double x) {
		if (x <= balance) {
			withdraw(x);
			customer.deposit(x);
			System.out.println("Transfer successful. Transferred: $" + x);
		} else {
			System.out.println("Unable to complete transfer.");
		}

	}

	
	// Refactor
	@Override
	public double withdraw(double amount) {
		if(amount > balance) {
			System.out.println("Insufficient funds.");
		} else {
			balance -= amount;
		}
		
		return balance;

	}

}
