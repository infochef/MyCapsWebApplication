package com.caps.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/get")
public class GetCookie extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Cookie [] cookie = req.getCookies();
		
		
		for(Cookie cookies:cookie) 
		{
			out.print("<h1>"+cookies.getName()+"</h1>");
			out.print("<h1>"+cookies.getValue()+"</h1>");
		}
	}
	
	
	}


