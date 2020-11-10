package com.revature.connectionutil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {

	private static Logger log = Logger.getLogger(ConnectionUtil.class);

	// Creates connection to DB
	public static Connection getConnection() {

		Connection conn = null;
		
		// JDBC String (Connection String)
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "Barata20";

		try {

			conn = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			log.fatal("Primary Connection unable to connect.");


		}
		return conn;


	}
}
