package com.revature.connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionUtil {
	
	private static Logger log = Logger.getLogger(ConnectionUtil.class);
	
	// Creates connection to DB
	public static Connection getConnection() {
		
		// JDBC String (Connection String)
		String url = "jdbc:postgresql://localhost:5432/";
		String username = "postgres";
		String password = "Barat20";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			log.warn("Unable to obtain connection to database", e);
		}
		
		return conn;
	}
	
	// add logger file

}
