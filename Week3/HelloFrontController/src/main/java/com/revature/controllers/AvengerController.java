package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Avenger;
import com.revature.services.AvengerService;

public class AvengerController {

	private AvengerService avService = new AvengerService();
	private ObjectMapper om = new ObjectMapper();

	public void getAllAvengers(HttpServletResponse resp) throws IOException {
		// Gets my avengers from the db.
		List<Avenger> list = avService.avengersAssemble();

		// Convert Java object into a JSON string that can be written to the body of an
		// HTTP response
		String json = om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}
	
	public void getAvenger(HttpServletResponse resp, int id) throws IOException{
		
		Avenger a = avService.getOneAvenger(id);

		// Convert Java object into a JSON string that can be written to the body of an
		// HTTP response
		String json = om.writeValueAsString(a);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}

}
