package com.caps.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class Homepage extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession(false);
		
		if(session==null)
		{
			resp.sendRedirect("./l");
		}
		else
		{
            resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.print("<h1>"+"This is My Homepage"+"</h1>");
		}
		
	}

}
