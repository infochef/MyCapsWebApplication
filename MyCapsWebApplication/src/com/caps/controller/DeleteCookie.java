package com.caps.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ka")
public class DeleteCookie extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		PrintWriter out = resp.getWriter();
		
		Cookie [] cookie = req.getCookies();
		for(Cookie c:cookie)
		{
			if(c.getName().equalsIgnoreCase("User"))
			{

				c.setMaxAge(0);
				resp.addCookie(c);
				out.print("Cookie Deleted");
			}
		}
			
	}

}
