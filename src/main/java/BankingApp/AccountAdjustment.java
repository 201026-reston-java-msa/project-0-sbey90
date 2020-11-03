package BankingApp;

public interface AccountAdjustment {
	
	public void view(String customerName);  // implemented in Admin - need to add to Employee class
	public void edit(); // replace();
	public void approveAndDeny();

}
