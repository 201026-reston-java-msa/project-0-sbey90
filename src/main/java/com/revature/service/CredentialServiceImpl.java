package com.revature.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bankingapp.Main;
import com.revature.daorepos.CredentialDAO;
import com.revature.daorepos.impl.CredentialDAOImpl;
import com.revature.model.Customer;

public class CredentialServiceImpl extends CredentialDAOImpl {
	static List<Customer> customers = new ArrayList<Customer>();

	public CredentialServiceImpl(ArrayList<Customer> customers) {
		super(customers);
		Scanner scan = new Scanner(System.in);

		System.out.println("Please choose a number from the options below:\n" + "1. - Register New User\n"
				+ "2. - Apply for an Account \n" + "3. - Login\n");
		int option = scan.nextInt();
		scan.nextLine();

		while (option != 4) {
			Customer c = new Customer();
			String p = "";
			String u = "";

			switch (option) {
			case 1:
				register(c);
				break;
			case 2:
				apply(c);
				break;
			case 3:
				getUsername(u);
				getPassword(p);
				CustomerServiceImpl customerService = new CustomerServiceImpl(customers);
			default:
				System.out.println("Thank you for choosing Nette's Bank.");
				Main.run();

			}
			if (option != 4) {
				System.out.println("Please choose a number from the options below:\n" + "1. - Register New User\n"
						+ "2. - Apply for an Account \n" + "3. - Login\n");

				option = scan.nextInt();
			}

		}
	}

	public boolean register(Customer c) { // @SuppressWWarning used here as it should be fine during execution
		Scanner scan = new Scanner(System.in);

		System.out.println("Thank you for choosing Nette's Bank!\n"
				+ "In order to setup your account we will need to get a little information from you.\n"
				+ "Please enter your first name: ");
		String first = scan.nextLine();
		c.setFirstName(first);

		System.out.println("Please enter your last name: ");
		String last = scan.nextLine();
		c.setLastName(last);
		System.out.println("Please enter a username: ");

		String u = scan.nextLine();
		System.out.println("Your username has been set to:  " + u);
		c.setUsername(u);

		System.out.println("Please enter a password: ");
		String p = scan.nextLine();
		System.out.println("Your password has been set to " + p);
		c.setPassword(p);
		c = new Customer(0, first, last, u, p, 5.0, 25.0);

		insert(c);

		System.out.println("Your registration is all set!");
		return true;
	}

	@Override
	public boolean getUsername(String username) {
		Customer c = new Customer();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your username: ");
		username = scan.nextLine();

		if (username.equals(c.getUsername())) {
			return true;
		}

		return false;
	}

	@Override
	public boolean getPassword(String password) {
		Customer c = new Customer();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your password: ");
		password = scan.nextLine();

		if (password.equals(password)) {
			System.out.println("You have successfully logged into your account");
			return true;
		}

		return super.getPassword(password);
	}

	public boolean apply(Customer c) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Thank you for choosing Nette's Bank!\n" + "Would you like to apply for a new account?\n"
				+ "Please type yes or no:\n");

		String option = scan.nextLine();
		if (option.equals("YES".toLowerCase())) {
			System.out.println(
					"Your application has been sent for approval. Please attempt to register your account to complete the application process.");
		} else if (c != null) {
			System.out.println("You are unable to register under this account.");
			return false;
		} else {
			System.out.println("You will be redirected to register your account.");

		}

		return true;
	}

}
