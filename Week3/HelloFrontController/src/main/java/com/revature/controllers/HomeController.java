package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Home;
import com.revature.services.HomeService;

public class HomeController {

	private HomeService homeServ = new HomeService();
	private ObjectMapper om = new ObjectMapper();

	public void getHome(HttpServletResponse resp, String string) throws IOException {
		Home h = homeServ.findHomeByName(string);

		// Convert Java object into a JSON string that can be written to the body of an
		// HTTP response
		String json = om.writeValueAsString(h);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);

	}

	public void getAllHomes(HttpServletResponse resp) throws IOException {
		List<Home> list = homeServ.getAllHomes();
		String json = om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}

	public void addHome(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		Home home = om.readValue(body, Home.class);
		
		if(homeServ.createHome(home)) {
			resp.setStatus(201);
		}else {
			resp.setStatus(406);
		}
	}

}
