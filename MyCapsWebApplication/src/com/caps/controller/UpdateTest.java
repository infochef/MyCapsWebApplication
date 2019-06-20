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

	public class UpdateTest  extends HttpServlet {


		@Override
		protected void doPost(HttpServletRequest req, 
				HttpServletResponse resp) throws ServletException, IOException {

			PrintWriter out = resp.getWriter();
			Connection con = null;
			PreparedStatement pstmt = null;
			
			String pass = req.getParameter("pass");
			String sall=req.getParameter("salary");
				int sal=Integer.parseInt(sall);	
			
			
			
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dburl = "jdbc:mysql://localhost:3306/captain_marvel?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			
			String query = "UPDATE Employee_table SET Empsal=? WHERE Emp_password=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sal);
			pstmt.setString(2,pass);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				out.print("<h1>"+"Salary Updated"+"</h1>");
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



	

