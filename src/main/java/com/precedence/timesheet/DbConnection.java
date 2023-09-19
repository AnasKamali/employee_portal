package com.precedence.timesheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/TIMESHEET";
		String username = "root";
		String password = "root";
		return DriverManager.getConnection(url, username, password);
	}
	
}
