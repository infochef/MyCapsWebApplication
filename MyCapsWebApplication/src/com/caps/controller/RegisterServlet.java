package com.caps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		Connection con = null;
		PreparedStatement pstmt = null;
		String id = req.getParameter("empid");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String mail = req.getParameter("mail");
		String sal = req.getParameter("sal");
		String department = req.getParameter("dept");
		String City = req.getParameter("city");
		String number = req.getParameter("num");

		int empid = Integer.parseInt(id);
		int salary = Integer.parseInt(sal);
		double contact = Double.parseDouble(number);
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String dburl = "jdbc:mysql://localhost:3306/captain_marvel?user=root&password=root";
		con = DriverManager.getConnection(dburl);
		
		String query = "insert into Employee_table values(?,?,?,?,?,?,?,?)";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1,empid);
		pstmt.setString(2,name);
		pstmt.setString(3,mail);
		pstmt.setInt(4,salary);
		pstmt.setString(5,pass);
		pstmt.setString(6,department);
		pstmt.setString(7,City );
		pstmt.setDouble(8,contact);
		
		int count = pstmt.executeUpdate();
		
		if(count>0)
		{
			out.print("<h1>"+"Employee Registerd"+"</h1>");
		}
		else
		{
			out.print("<h1>"+"Failed"+"</h1>");
		}
		
		}
		catch(Exception e)
		{
		   e.printStackTrace();
		   out.print("<h1>"+"Failed"+"</h1>");
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
			
		}
	
	}
}