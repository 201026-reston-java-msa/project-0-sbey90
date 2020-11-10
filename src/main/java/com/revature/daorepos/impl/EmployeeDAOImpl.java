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
import com.revature.daorepos.EmployeeDAO;
import com.revature.model.CheckingAccount;
import com.revature.model.Customer;
import com.revature.model.SavingsAccount;
import com.sun.tools.sjavac.Log;

public class EmployeeDAOImpl implements EmployeeDAO {

	public EmployeeDAOImpl(List<Customer> customers) {

		this.customers = new ArrayList<Customer>();
	}

	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);

	List<Customer> customers;

	@Override
	public List<Customer> findAll() {  

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM  bankingapp.customers_  ORDER BY customer_id"; 

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

	
	public int findById(int Id) {  // UNABLE TO PERSIST

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT customer_id FROM bankingapp.customers_ WHERE customer_id = " + Id + ";"; 
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {  // was while
				rs.getInt(Id);
			}
			rs.close();

		} catch (SQLException e) {
			log.warn("Unable to return customer Id from the database.");
			e.printStackTrace();
		}

		return Id;

	}

	@Override
	public boolean insert(Customer c) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO bankingapp.customers_ (first_name, last_name, customer_username, customer_password)"
					+ " VALUES (?, ? ,? ,?);";

			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getPassword());

		} catch (SQLException e) {
			
			log.warn("Unable to insert into the database.");
			return false;
		}
		return true;
	}

}
