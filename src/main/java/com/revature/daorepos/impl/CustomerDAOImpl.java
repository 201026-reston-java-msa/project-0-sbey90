package com.revature.daorepos.impl;

import java.sql.Connection;
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

public class CustomerDAOImpl implements CustomerDAO {

	Logger log = Logger.getLogger(CustomerDAOImpl.class);
	ArrayList<Customer> customers = new ArrayList<Customer>();

	public CustomerDAOImpl(ArrayList<Customer> customers) {
		super();
		this.customers = customers;
	}

	@Override
	public boolean updateCredentials(String username, String password) {
		try (Connection conn = ConnectionUtil.getConnection();) {

			String sql = "UPDATE BankingApp.customers WHERE username =? WHERE password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ps.setString(4, username);
				ps.setString(5, password);
				ps.executeUpdate();
			}
			rs.close();

		} catch (SQLException e) {
			Log.warn("Unable to update password in the database.");
		}
		return false;
	}

	@Override
	public boolean updateChecking(int id, CheckingAccount checking) {

		try (Connection conn = ConnectionUtil.getConnection();) {

			String sql = "UPDATE BankingApp.customers WHERE checking = ? WHERE customer_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ps.setObject(1, checking);
				ps.setInt(2, id);
				ps.executeUpdate(sql); // SHOULD WORK -- TESTING POINT
				log.info("Executed update to the database.");
				return true;
			}
			ps.close();

		} catch (SQLException e) {
			Log.warn("Unable to connect to Checking Account");
		}
		return false;
	}

	@Override
	public boolean updateSavings(int id, SavingsAccount savings) {
		try (Connection conn = ConnectionUtil.getConnection();) {

			String sql = "UPDATE BankingApp.customers WHERE savings = ? WHERE customer_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ps.setObject(1, savings);
				ps.setInt(2, id);
				ps.executeUpdate(sql); // SHOULD WORK -- TESTING POINT
				log.info("Executed update to the database.");
				return true;
			}
			ps.close();

		} catch (SQLException e) {
			Log.warn("Unable to connect to Savings Account");
		}
		return false;
	}

}
