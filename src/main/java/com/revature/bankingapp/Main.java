package com.revature.bankingapp;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.model.Customer;
import com.revature.service.AdminServiceImpl;
import com.revature.service.CredentialServiceImpl;
import com.revature.service.CustomerServiceImpl;
import com.revature.service.EmployeeServiceImpl;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import jdk.internal.org.jline.utils.Log;

public class Main {
	private static ArrayList<Customer> customers = new ArrayList<Customer>();

	private static Scanner scan = new Scanner(System.in);

	private static final Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		run();

	}

	public static void run() {
		log.info("Starting program.");

		System.out.println("WELCOME TO NETTE'S BANK!!!");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		System.out.println("Please enter the number of your role below:\n" + "1. - Customer\n" + "2. - Employee\n"
				+ "3. - Administrator\n");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
		int choice = scan.nextInt();

		while (choice != 4) {

			switch (choice) {

			case 1:
				CredentialServiceImpl credentialService = new CredentialServiceImpl(customers);
				CustomerServiceImpl customerService = new CustomerServiceImpl(customers);
				break;

			case 2:
				EmployeeServiceImpl employeeService = new EmployeeServiceImpl(customers);
				break;

			case 3:
				AdminServiceImpl adminService = new AdminServiceImpl(customers);
				break;

			default:
				System.out.println("Thank you for choosing Nette's Bank.\n" + "Have a Great Day!");
				log.info("Ending program.");
			}
		}
	}

}
