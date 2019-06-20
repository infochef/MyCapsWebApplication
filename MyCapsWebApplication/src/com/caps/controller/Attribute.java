package com.caps.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dto.Employee;

@WebServlet("/attribute")
public class Attribute extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Employee emp =new Employee();
		emp.setId(101);
		emp.setName("Swastika");
		emp.setSal(16000);
		
		req.setAttribute("emp", emp);
		RequestDispatcher dis = req.getRequestDispatcher("./mini");
		dis.forward(req, resp);
		
	}

}
