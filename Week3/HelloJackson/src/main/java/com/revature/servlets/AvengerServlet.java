package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Avenger;
import com.revature.services.AvengerService;

public class AvengerServlet extends HttpServlet{
	
	private AvengerService avService = new AvengerService();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		//Gets my avengers from the db. 
		List<Avenger> list = avService.avengersAssemble();
		
		//Convert Java object into a JSON string that can be written to the body of an HTTP response
		String json = om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
		resp.setContentType("application/json");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		StringBuilder sb = new StringBuilder();
		
		//The request object has a built in method to return an object that can read the body line by line. 
		BufferedReader reader = req.getReader();
		
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			//advance to the next line
			line = reader.readLine();
		}
		
		String body = new String(sb);
		
		//The above is all so that the object mapper can read the body. 
		
		//Jackson will convert the json that is in the body to a java object we tell it to. 
		Avenger a = om.readValue(body, Avenger.class);
		
		if (avService.addAvenger(a)) {
			resp.setStatus(201);
		}else {
			resp.setStatus(400);
		}
		
	}
	

}
