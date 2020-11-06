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

	public List<Customer> findAll() {

		try (Connection conn = ConnectionUtil.getConnection();) {

			String sql = "SELECT * FROM  customer";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("custmer_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String password = rs.getString("customer_password");
				String username = rs.getString("cutomer_username");
				CheckingAccount checking = (CheckingAccount) rs.getObject("checking");
				SavingsAccount savings = (SavingsAccount) rs.getObject("savings");

				Customer c = new Customer(id, first_name, last_name, username, password, checking, savings);
				customers.add(c);

			}
			rs.close();

		} catch (SQLException e) {
			Log.warn("Unable to retrieve customer from the Database.");
		}
		return customers;
	}

	// SHOULD WORK - NEED TO TEST
	public Customer findById(int Id) {

		try (Connection conn = ConnectionUtil.getConnection();) {

			String sql = "SELECT customer_id FROM customers WHERE first_name = ? ORDER BY customer_id "; // TEST - hard
																											// code
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				customers.get(Id);
			}
			rs.close();

		} catch (SQLException e) {
			Log.warn("Unable to return customer Id from the database.");
		}

		return customers.get(Id);

	}

	@Override
	public boolean insert(Customer c) {
		try (Connection conn = ConnectionUtil.getConnection();) {

			String sql = "INSERT INTO customers (first_name, last_name, customer_username, customer_password, checking, savings)"
					+ "VALUES (?, ? ,? ,? ,? ,?)";

			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getPassword());

			CheckingAccount checking = c.getCheckingAccount();
			SavingsAccount savings = c.getSavings();

			if (checking != null) {
				ps.setInt(5, c.getId());
			} else {
				ps.setNull(5, java.sql.Types.NULL);
			}

			if (!ps.execute()) {
				return false;
			}

		} catch (SQLException e) {
			Log.warn("Unable to insert into the database.");
			return false;
		}
		return true;
	}

}
