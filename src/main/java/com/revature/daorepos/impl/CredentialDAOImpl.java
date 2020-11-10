package com.revature.daorepos.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.connectionutil.ConnectionUtil;
import com.revature.daorepos.CredentialDAO;
import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;

public class CredentialDAOImpl implements CredentialDAO<Customer> {
	
	
	// POSSIBLY DONE
	

	public CredentialDAOImpl(List<Customer> customers) {
		this.customers = customers;
	}
	


	private static Logger log = Logger.getLogger(CredentialDAOImpl.class);

	List<Customer> customers;

	@Override
	public List<Customer> findAll() {
		
		List<Customer> c = new ArrayList<Customer>();
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM customers_;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int rows = 0;
			while (rs.next()) {
				int id = rs.getInt("customer_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String password = rs.getString("customer_password");
				String username = rs.getString("cutomer_username");
				double checking = rs.getDouble("checking");
				double savings = rs.getDouble("savings");
				rows++;

				Customer customer = new Customer(id, first_name, last_name, username, password, checking, savings);
				customers.add(customer);

			}
			rs.close();

		} catch (SQLException e) {
			log.warn("Unable to retrieve customer from the Database.");
		}
		return customers;
	}

	@Override
	public Customer findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT customer_id FROM bankingapp.customers_ WHERE first_name = ? ORDER BY customer_id ;"; 
																											
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				customers.get(id);
			}
			rs.close();

		} catch (SQLException e) {
			log.warn("Unable to return customer ID from the database.");
		}
		return customers.get(id);
	}

	@Override
	public Customer insert(Customer customer) { // FINISHED!
		
		CheckingAccount account = new CheckingAccount();
		SavingsAccount savings = new SavingsAccount();
		
		try (Connection conn = ConnectionUtil.getConnection()) { // TESTING

			String sql = "INSERT INTO bankingapp.customers_(first_name, last_name, customer_username, customer_password, checking, savings) "
					+ "VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());			
			ps.setString(3, customer.getUsername());
			ps.setString(4, customer.getPassword());
			ps.setDouble(5, account.getBalance());
			ps.setDouble(6, savings.getBalance());
			ps.executeUpdate();
				
			// TEST THESE STATEMENTS
			sql = "INSERT INTO bankingapp.credentials WHERE customer_username = ? WHERE customer_password = ?;";
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ps2.setString(1, customer.getUsername());
			ps2.setString(2, customer.getPassword());
			
			
//			// TEST
//		ResultSet rs = ps.executeQuery();
//		while(rs.next()) {
//			ps.setInt(1, customer.getId());
//		}
			
 
			log.info("Connectivity Successful.");
			log.info("Customer has been inserted.");
		} 
		//rs.close();
		catch (SQLException e) {
			
			log.warn("Unable to insert into the database.");
			e.printStackTrace();
			return null;
		}
		return customer;
	}

	@Override
	public boolean getUsername(String username) {
		List<Customer> c = new ArrayList<Customer>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM credentials WHERE customer_username = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				username = rs.getString("customer_username");
				log.info("Successfully connected to the database.");
				log.info("Retrieved information from the database.");
				return true;
			}
			rs.close();
			
		} catch(SQLException e) {
			log.warn("Unable to connect database");
			
		}
		return false;
	}
	
	@Override
	public boolean getPassword(String password) {
		List<Customer> c = new ArrayList<Customer>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM credentials WHERE customer_password = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				password = rs.getString("customer_password");
				log.info("Successfully connected to the database.");
				log.info("Retrieved information from the database.");
				return true;
			}
			rs.close();
			
		} catch(SQLException e) {
			log.warn("Unable to connect database");
		}
		return false;
	}


}
