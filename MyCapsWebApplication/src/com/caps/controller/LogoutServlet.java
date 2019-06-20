package com.caps.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      PrintWriter out = resp.getWriter();
      HttpSession session = req.getSession(false);
      if(session!=null)
      {
    	  session.invalidate();
    	  Cookie[] cookie = req.getCookies();
    	  for(Cookie c:cookie)
    	  {
    		  if(c.getName().equalsIgnoreCase("JSESSIONID"))
    		  {
    			  c.setMaxAge(0);
    			  resp.addCookie(c);
    		  }
    	  }
    	  
  		
      }
      else
      {
    	  out.print("<h1>"+"logged out"+"</h1>");
      }
      
	}

}
