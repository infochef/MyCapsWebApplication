// Register Details Of Employees


package com.caps.mttproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/regis")
public class RegisterEmp extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		Connection con = null;
		PreparedStatement pstmt = null;
		String id = req.getParameter("empid");
		String Fname = req.getParameter("fname");
		String Lname = req.getParameter("lname");
		String password = req.getParameter("pass");
		String mail = req.getParameter("empmail");
	

		int empid = Integer.parseInt(id);
		int pass = Integer.parseInt(password);
		
		
		try
		{
			
			//1. Load the Driver Class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. Get DB conection via Driver
		String dburl = "jdbc:mysql://localhost:3306/captain_marvel?user=root&password=root";
		con = DriverManager.getConnection(dburl);
		
		
		//3. Issue Sql Querries via connection
		String query = "insert into Emp_table values(?,?,?,?,?)";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1,empid);
		pstmt.setString(2,Fname);
		pstmt.setString(3,Lname);
		pstmt.setString(4,mail);
		pstmt.setInt(5,pass);
		
		
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
	

