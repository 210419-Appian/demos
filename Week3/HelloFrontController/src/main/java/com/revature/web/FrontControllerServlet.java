package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.AvengerController;

public class FrontControllerServlet extends HttpServlet{
	
	private String BaseURL = null;
	private AvengerController avControl = new AvengerController();
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		BaseURL = config.getInitParameter("BaseURL");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("application/json");
		
		resp.setStatus(404); //default if someone sends a malformed request. 
		
		final String URL = req.getRequestURI().replace(BaseURL, "");
		
		System.out.println(URL);
		
		//A path variable is a way to pass information about the request in the URL itself. Generally you have
		//a final / in the url that takes a variable input. i.e. avenger/1 will get you the first avenger while 
		// avenger/2 gets the second etc. 
		
		String[] sections = URL.split("/");
		
		System.out.println(sections);
		
		switch(sections[0]) {
		case "avenger":
			if(sections.length == 2) {
				int id = Integer.parseInt(sections[1]);
				avControl.getAvenger(resp, id);
			}else {
				avControl.getAllAvengers(resp);
			}
		}
		
	}

}
