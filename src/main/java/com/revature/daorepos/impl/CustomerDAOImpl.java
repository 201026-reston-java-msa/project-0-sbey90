package com.revature.daorepos.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.connectionutil.ConnectionUtil;
import com.revature.daorepos.CustomerDAO;
import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;
import com.sun.tools.sjavac.Log;

public class CustomerDAOImpl extends CheckingAccount implements CustomerDAO {

	private static String url = "jdbc:postgresql://localhost:5432/public";
	private static String username = "postgres";
	private static String password = "Barata20";

	Logger log = Logger.getLogger(CustomerDAOImpl.class);
	ArrayList<Customer> customers = new ArrayList<Customer>();

	public CustomerDAOImpl(ArrayList<Customer> customers) {
		super();
		this.customers = customers;
	}

	@Override
	public boolean insert(Customer c) {

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "INSERT INTO bankingapp.customers_ (first_name, last_name, customer_username, customer_password, checking, savings)"
					+ "VALUES (?, ? ,? ,?, ?, ?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getPassword());
			ps.setDouble(5, c.getCheckingAccount());
			ps.setDouble(6, c.getSavings());
			log.info("Connectivity Successful.");
		} catch (SQLException e) {

			log.warn("Unable to insert into the database.");
			return false;
		}
		return true;
	}

	@Override
	public boolean updateCredentials(String username, String password) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE public.bankingapp.credentials SET username = ? WHERE password = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ps.setString(1, username);
				ps.setString(2, password);
				ps.executeUpdate();
			}
			rs.close();

		} catch (SQLException e) {
			log.warn("Unable to update password in the database.");
			return false;
		}
		return true;
	}

	@Override
	public boolean updateChecking(int id, double checking) {
		CheckingAccount account = new CheckingAccount();

		try (Connection conn = ConnectionUtil.getConnection();) {

			String sql = "UPDATE bankingapp.accounts_ SET checking = ? WHERE account_id = ?;"; 
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(2, id); 
			ps.setDouble(1, checking); 

			ps.executeUpdate();

			log.info("Executed update to the database.");
			return true;

		} catch (SQLException e) {
			log.warn("Unable to connect to Checking Account");
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateSavings(int id, double savings) { 

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE bankingapp.accounts_ SET savings = ? WHERE account_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, savings);  
			ps.setInt(2, id);  
			ps.executeUpdate(); 

			log.info("Executed update to the database.");
			return true;

		} catch (SQLException e) {
			log.warn("Unable to connect to Savings Account");
			e.printStackTrace();
		}
		return false;
	}

}
