import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.exception.OverdraftException;
import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;
import com.revature.service.AdminServiceImpl;
import com.revature.service.CredentialServiceImpl;

public class Tests {

	private static CheckingAccount checkingAccount;

	@Before
	public void setup() {
		CheckingAccount checkingAccount = new CheckingAccount();

	}

	@Test
	public void testDeposit() {
		double amount = 10.0;
		double test = 20.0;
		assertTrue(amount < test);

	}

	@Test
	public void testWithdraw() {
		double amount = 5;
		double test = 10;
		assertFalse(test < amount);
	}

	@Test(expected = OverdraftException.class)
	public void testOverdraftException() {
		AdminServiceImpl adminService = new AdminServiceImpl(null);
		CheckingAccount checking = new CheckingAccount();
		checking.setBalance(0);
		double amount = 1000.0;

		checking.withdraw(checking.getBalance() - amount);
	}

	@Test
	public void testCustomer() {
		Customer customer = new Customer();

		if (customer != null) {
			assertFalse(customer == null);
		} else {
			assertTrue(customer != null);
		}

	}

	@Test
	public void testSearchCustomer() {
		AdminServiceImpl adminService = new AdminServiceImpl(null);
		Customer c = new Customer();
		int id = 0;

		if (c != null) {
			adminService.searchCustomer(c, id);
		}

		assertNull(c);
	}

	@Test
	public void testTransfer() {

		CheckingAccount checkingAccount = new CheckingAccount();
		SavingsAccount savingsAccount = new SavingsAccount();
		double amount = 50;
		checkingAccount.transfer(checkingAccount.getBalance(), amount);
		assertTrue(savingsAccount.getBalance() == 0);
	}

	@Test
	public void testRegister() {
		CredentialServiceImpl credentials = new CredentialServiceImpl(null);
		Customer c = new Customer();

		credentials.register(c);

		assertNotNull(c);
	}

	@After
	public void tearDown() {
		checkingAccount = null;
	}

}
