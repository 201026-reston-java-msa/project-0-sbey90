package com.revature.service;

import java.util.List;
import java.util.Scanner;

import com.revature.bankingapp.Main;
import com.revature.daorepos.EmployeeDAO;
import com.revature.daorepos.impl.EmployeeDAOImpl;
import com.revature.model.Customer;

public class EmployeeServiceImpl extends EmployeeDAOImpl {
	Customer c = new Customer();

	public EmployeeServiceImpl(List<Customer> customers) {
		super(customers);
		Scanner scan = new Scanner(System.in);
		// create menu here
		System.out.println("Please choose the number of an option listed below: \n" + "1. - Print a list of Customers\n"
				+ "2. - Approve or Deny Customer Request\n");

		int option = scan.nextInt();

		while (option != 4) {
			String verdict = "";
			int id = 0;

			switch (option) {

			case 1:
				searchCustomer(c, id);
				break;
			case 2:
				approveOrDeny(c, verdict);
				break;
			default:
				Main.run();
			}
			if (option != 4) {
				System.out.println(
						"Please choose the number of an option listed below: \n" + "1. - Print a list of Customers\n"
								+"2. - Approve or Deny Account");

				option = scan.nextInt();
			}
		}

	}

	public void searchCustomer(Customer c, int id) {
		System.out.println("List of customers: \n" + findAll());
	}

	public boolean approveOrDeny(Customer c, String verdict) {
		Scanner scan = new Scanner(System.in);
		System.out
				.println("Customer has sent a request to open a new account!\n" + "type yes to approve, or no to deny");
		verdict = scan.nextLine();

		if (verdict.equals("YES".toLowerCase())) {
			System.out.println("Customers request has been approved.");
			return true;
		} else if (verdict.equals("NO".toLowerCase())) {
			System.out.println("Customers request has been denied.");
			return false;
		} else {
			System.out.println("Incorrect entry.");
			return false;
		}
	}

}
