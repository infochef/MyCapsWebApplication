//Show Details of Employees

package com.caps.mttproject;

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

  @WebServlet("/show")
	public class DataEmp  extends HttpServlet {
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			PrintWriter out=resp.getWriter();
			String pass=req.getParameter("pass");
			
			int id=Integer.parseInt(req.getParameter("empid"));
			
			
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			
			
			try
			{
				//1. Load The Driver Class
				
				Class.forName("com.mysql.jdbc.Driver");
				
				//2. Get DB Connection via Driver
				
				String dburl="jdbc:mysql://localhost:3306/Captain_marvel?user=root&password=root";
				con = DriverManager.getConnection(dburl);
				
				//3. Issue Sql Query via Connection
				
				String query = "Select * From Emp_table Where Empid=? AND Emp_password=?";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, id);
				pstmt.setString(2, pass);
				rs = pstmt.executeQuery();
				
				//4. Showing the result
				
				while(rs.next())
				{
					int Employee_id=rs.getInt("Empid");
					String First_name=rs.getString("F_name");
					String Last_name=rs.getString("L_name");
					String Employee_mail=rs.getString("Emp_mail");
					String Employee_password=rs.getString("Emp_password");
					
					
					out.println("<h1><em>"+Employee_id+"</em></h1>");
					out.println("<h1><em>"+First_name+"</em></h1>");
					out.println("<h1><em>"+Last_name+"</em></h1>");
					out.println("<h1><em>"+Employee_mail+"</em></h1>");
					out.println("<h1><em>"+Employee_password+"</em></h1>");
					
					
				}
				
				
				
				
				
			}catch(Exception e)
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
				
			}
			
		}

	}


