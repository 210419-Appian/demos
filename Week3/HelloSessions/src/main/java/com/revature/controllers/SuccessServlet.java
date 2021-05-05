package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuccessServlet extends HttpServlet{
	
	//This is bad practice but possible.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		//gets a currently active session if one exists.
		HttpSession ses = req.getSession(false);
		
		if (ses == null) {
			out.print("<h1>YOU ARE NOT LOGGED IN!!!!!!!!</h1>");
		} else {
			String name = (String) ses.getAttribute("username");
			out.print("<h2>Welcome "+name+", you are successfully logged in.</h2>");
			out.print("<a href='logout'>Click here to log out.</a>");
		}
		
		
		
	}
	
	

}
