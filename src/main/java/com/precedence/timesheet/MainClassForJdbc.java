package com.precedence.timesheet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainClassForJdbc {
    public static void main(String[] args) {
    	
    	User user = new User();
    	user.setUserName("shifa");
    	user.setUserPassword("shifa!123");
    	user.setUserEmail("shif091@gmail.com");
    	user.setUserId(8);
    	
    	//boolean insertUser = UserService.insertUser(user);
    	boolean insertUser = UserService.deleteUser(111);
    	System.out.println(insertUser);
    }
    	
}

