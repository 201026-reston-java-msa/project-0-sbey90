package com.revature.daorepos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.connectionutil.ConnectionUtil;
import com.revature.daorepos.AdminDAO;
import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;
import com.sun.tools.sjavac.Log;

// UNABLE TO PERSIST

public class AdminDaoImpl extends CheckingAccount implements AdminDAO {

	public AdminDaoImpl(List<Customer> customers) {
		this.customers = new ArrayList<Customer>();
	}

	private static Logger log = Logger.getLogger(AdminDaoImpl.class);

	List<Customer> customers = new ArrayList<Customer>();

	// REFACTOR
	@Override
	public String findByName(String name) { // Index 0 out of bounds for length 0
		String customerName = "";

		try (Connection conn = ConnectionUtil.getConnection();) {

			String sql = "SELECT * FROM bankingapp.customers_ WHERE first_name = " + name + ";"; // need to figure out a parameter to search for here or refactor to search by name
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {  // was while
				customerName = rs.getString(name);
			}
			rs.close();

		} catch (SQLException e) {
			log.warn("Unable to return customer name from the database.");
			e.printStackTrace();
		}
		return customerName;
	}

	
	@Override
	public boolean insert(CheckingAccount checking, String username) { // FINISHED!
		
		CheckingAccount account = new CheckingAccount();
		SavingsAccount savings = new SavingsAccount();
		int id = 1;
		
		try (Connection conn = ConnectionUtil.getConnection()) { // TESTING

			
			String sql = "INSERT INTO bankingapp.accounts_ (checking, savings) VALUES (?, ?);";
			PreparedStatement ps3 = conn.prepareStatement(sql);
			ps3.setDouble(1, account.getBalance());
			ps3.setDouble(2, savings.getBalance());
			ps3.setInt(1, id); // ADDING THIS ADDED THE WRONG VALUES BUT IT DID PERSIST!
			ps3.executeUpdate();

 
			log.info("Connectivity Successful.");
			log.info("Customer has been inserted.");
		} 
		//rs.close();
		catch (SQLException e) {
			
			log.warn("Unable to insert into the database.");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void updateCustomerName(Customer c) {

		try (Connection conn = ConnectionUtil.getConnection();) {

			String sql = "UPDATE bankingapp.customers_ SET first_name = ? WHERE last_name = ?;"; 
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				customers.get(c.getId()).setFirstName(c.getFirstName());
				customers.get(c.getId()).setLastName(c.getLastName());
				log.info("Customer: ID: " + c.getId() + ", has been updated in the Database.");
			}
			ps.close();

		} catch (SQLException e) {

			log.warn("Unable to update Customer Name.");
		}

	}

	@Override 
	public boolean updateChecking(int id, double checking) {
		CheckingAccount account = new CheckingAccount();

		try (Connection conn = ConnectionUtil.getConnection();) {

			String sql = "UPDATE bankingapp.accounts_ SET checking = ? WHERE account_id = ?;";  // was ?
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(2, id); // was 1
			ps.setDouble(1, checking); // was account.getBalance(); -- CHANGING 2 PARAMTER TO CHECKING ^ FIXED IT!
			
			ps.executeUpdate();

			log.info("Executed update to the database.");
			return true;			

		} catch (SQLException e) {
			log.warn("Unable to connect to Checking Account");
			e.printStackTrace();
		}
		return false;
	}
	
	// NOT PERSISTING
	@Override
	public boolean updateSavings(int id, double savings) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE bankingapp.accounts_ SET savings = ? WHERE account_id = ?;";  
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(2, id);  // was 2, id
			ps.setDouble(1, savings);  // was ps.setDouble(2, savings);
			ps.executeUpdate();
			
			 // SHOULD WORK -- TESTING POINT
			log.info("Executed update to the database.");
			return true;	
		} 
		catch (SQLException e) {
			log.warn("Unable to connect to Savings Account");
			e.printStackTrace();
		}
		return false;
	}

	// DO NEXT
	@Override
	public void remove(Customer c) { // TEST

		try (Connection conn = ConnectionUtil.getConnection();) {

			String sql = "DELETE FROM bankingapp.customers_ WHERE customer_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				customers.remove(c);
				log.info("Customer Account Id: " + c.getId() + " has been removed from the Database.");
			}

		} catch (SQLException e) {
			
			log.warn("Unable to remove from the database.");
		}

	}

	// DONE
	@Override
	public List<Customer> findAll() {  

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM  bankingapp.customers_  ORDER BY customer_id"; // WHERE customer_id = ?

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("customer_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String password = rs.getString("customer_password");
				String username = rs.getString("customer_username");
				double checking = rs.getDouble("checking");
				double savings = rs.getDouble("savings");

				Customer c = new Customer(id, first_name, last_name, username, password, savings, checking);
				customers.add(c);

			}
			rs.close();
			log.info("Obtained customers.");

		} catch (SQLException e) {
			log.warn("Unable to retrieve customer from the Database.");
			e.printStackTrace();
		}
		return customers;
	}

	

}
