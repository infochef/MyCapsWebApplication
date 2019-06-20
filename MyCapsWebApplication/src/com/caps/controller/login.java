package com.caps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")
public class login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{ 
	
		
		//resp.sendRedirect("http://localhost:3306/MyCapsWebApplication/Company.html");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		PrintWriter out=resp.getWriter();
		String pass=req.getParameter("password");
		String s = req.getParameter("user");
		
		try
		{
			
		//1. Load the Driver Class
			
          Class.forName("com.mysql.jdbc.Driver");
          
      //2. Get DB Connection via Driver
          
          String dburl="jdbc:mysql://localhost:3306/Captain_marvel?user=root&password=root";
         con= DriverManager.getConnection(dburl);
			
	  //3. Issue Sql Query via connection		
			 
          String query = "Select * from Login_table where UserName=? AND PassWord=?";
          pstmt = con.prepareStatement(query);
          pstmt.setString(1, s);
          pstmt.setString(2, pass);
          rs = pstmt.executeQuery();
          
          
          if(rs.next()) {
        	  resp.sendRedirect("./Company.html");
          }
          else {
        	  resp.sendRedirect("./login.html");
          }
          
          
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		
	}

}
