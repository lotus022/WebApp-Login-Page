package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<h1>Entered Information</h1>");
		String fname=request.getParameter("fname");
		out.println("</br>Your first name is " +fname);
		String lname=request.getParameter("lname");
		out.println("</br>Your Last name is " +lname);
		String email=request.getParameter("email");
		out.println("</br>Your email is " +email);
		String gender=request.getParameter("gender");
		out.println("</br>Your gender is " +gender);
		String country=request.getParameter("country");
		out.println("</br>Your country is " +country);
		String password=request.getParameter("PassCode");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee_db","root","root");
			conn.setAutoCommit(true);
			PreparedStatement ps= conn.prepareStatement("insert into employee values(?,?,?,?,?,?)");
 			ps.setString(1,fname);
			ps.setString(2,lname);
			ps.setString(3,email);
			ps.setString(4,gender);
			ps.setString(5,country);
			ps.setString(6, password);
			boolean isInserted=ps.execute();
			if(!isInserted) {
				out.println("</br>Successfully inserted to database!!");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				
			} else {
				out.println("</br>Not inserted!");
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
