package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class utility {

	public static boolean validate(String email, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee_db","root","root");
			PreparedStatement ps= conn.prepareStatement("select * from employee where email=? and password=?;");
			ps.setString(1,email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			int count =0;
			while(rs.next()) {
				count++;
			}
			if(count>0) {
				return true;
			} 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return false;
	}
}
