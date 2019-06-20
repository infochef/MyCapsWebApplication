
// Update Employee Details 

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
	
	
@WebServlet("/up")
	public class UpdateEmp  extends HttpServlet {


		@Override
		protected void doPost(HttpServletRequest req, 
				HttpServletResponse resp) throws ServletException, IOException {

			PrintWriter out = resp.getWriter();
			Connection con = null;
			PreparedStatement pstmt = null;
			
			String id = req.getParameter("empid");
			String emp_mail=req.getParameter("Emp_mail");
				int empid=Integer.parseInt(id);	
			
			
			
			try
			{
				
				//1. Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Get DB connection via Driver
			String dburl = "jdbc:mysql://localhost:3306/captain_marvel?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			
			
			//3. Issue SQL querries via connection
			String query = "UPDATE Emp_table SET Emp_mail=? WHERE Empid=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, emp_mail);
			pstmt.setInt(2,empid);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				out.print("<h1>"+"Employee mail Updated"+"</h1>");
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
				try 
				{
				if(con!=null)
				{
						con.close();
				}
				
				if(pstmt!=null)
				{
						pstmt.close();
				}
				} catch(Exception e1) {
						e1.printStackTrace();
					}
				}

				
				
			}
		
		}
	



	


	
