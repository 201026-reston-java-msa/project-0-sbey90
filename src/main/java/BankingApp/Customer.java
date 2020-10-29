package BankingApp;

public class Customer extends FundAutomation implements JointAccount {
	
	private String name; // may need to adjust implementation
	private long accountNumber;
	private long routingNumber;
	private String password;
	private String username;
	
	// private double balance (can possibly be included in an ArrayList)
	
	
	
	public Customer(long accountNumber, long routingNumber, String password, String username, String name) {
		
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.password = password;
		this.username = username;
		this.name = name;
	}



	// Instance Methods
	
	
	
	
	// Getters
	public long getAccountNumber() {
		return accountNumber;
	}



	public long getRoutingNumber() {
		return routingNumber;
	}



	public String getPassword() {
		return password;
	}



	public String getUsername() {
		return username;
	}


	
	// Setters
	public void setPassword(String password) {
		this.password = password;
	}


	public void setUsername(String username) {
		this.username = username;
	}



	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void transfer() {
		// TODO Auto-generated method stub
		
	}



	public void accountJoin() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	// Note: employeeNumber may been to be converted to a Customer ID or Account Number
	
	
	
	

}
