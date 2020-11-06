package BankingApp;

// TEST log4j


import org.apache.log4j.Logger;

import com.revature.service.CustomerServiceImpl;

import jdk.internal.org.jline.utils.Log;

public class Main {

	
	private static final Logger log = Logger.getLogger(Main.class);
	
	
	
	public static void main(String[] args) {

		
		Log.info("Start Program.");
		try {
			int x = 1/0;
			log.info("Computation successful.");
			
		} catch (ArithmeticException e) {
			log.warn("Warning: Division by zero occurred", e);
		}
		
		log.info("PROGRAM END");
		
		
		
		
		
		
		
//		CustomerServiceImpl customer = new CustomerServiceImpl();
//		
//		customer.deposit(0);
//		customer.withdraw(0);
//		customer.transfer(0);
		


	}

}
