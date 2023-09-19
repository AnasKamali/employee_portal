package com.precedence.timesheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {
	public static boolean insertUser(User user)
	{
		
		Boolean result = null;
		

        // User data to insert
        String user_name = user.getUserName();
        String user_Email = user.getUserEmail();
        String Password = user.getUserPassword();
        int userId = user.getUserId(); 

        try {
            // Establish a database connection
            Connection connection = DbConnection.getConnection();

            // SQL query to insert data into the user table
            String insertQuery = "INSERT INTO user (NAME, EMAIL ,PASSWORD,userId) VALUES (?, ?, ?,?)";

            // Create a PreparedStatement to safely execute the query
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, user_Email);
            preparedStatement.setString(3, Password);
            preparedStatement.setInt(4,userId);


            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                
                
                result = true;
            } else {
                
                result = false;
            }

            // Close the resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }
	
	
	public static boolean deleteUser(int userId)
	{
		
		Boolean result = null;
		
        try {
            // Establish a database connection
            Connection connection = DbConnection.getConnection();

            // SQL query to insert data into the user table
            String insertQuery = "Delete from user where userId = "+ userId;

            // Create a PreparedStatement to safely execute the query
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            


            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                
                
                result = true;
            } else {
                
                result = false;
            }

            // Close the resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }
}

