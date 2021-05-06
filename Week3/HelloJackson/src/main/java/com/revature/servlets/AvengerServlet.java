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

public class AvengerServlet extends HttpServlet {

	private AvengerService avService = new AvengerService();
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();

		String[] sections = url.split("/");
		System.out.println(sections.length);
		System.out.println(url);
		String json = null;
		
		if (sections.length == 3) {
			// Gets my avengers from the db.
			List<Avenger> list = avService.avengersAssemble();

			// Convert Java object into a JSON string that can be written to the body of an
			// HTTP response
			json = om.writeValueAsString(list);
			
		} else if (sections.length == 4) {
			
			int id = Integer.parseInt(sections[3]);
			System.out.println(id);
			Avenger a = avService.getOneAvenger(id);

			// Convert Java object into a JSON string that can be written to the body of an
			// HTTP response
			json = om.writeValueAsString(a);
			
		}
		
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
		resp.setContentType("application/json");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StringBuilder sb = new StringBuilder();

		// The request object has a built in method to return an object that can read
		// the body line by line.
		BufferedReader reader = req.getReader();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			// advance to the next line
			line = reader.readLine();
		}

		String body = new String(sb);

		// The above is all so that the object mapper can read the body.

		// Jackson will convert the json that is in the body to a java object we tell it
		// to.
		Avenger a = om.readValue(body, Avenger.class);

		if (avService.addAvenger(a)) {
			resp.setStatus(201);
		} else {
			resp.setStatus(400);
		}

	}

}
