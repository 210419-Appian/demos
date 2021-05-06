package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

	public void getAvenger(HttpServletResponse resp, int id) throws IOException {

		Avenger a = avService.getOneAvenger(id);

		// Convert Java object into a JSON string that can be written to the body of an
		// HTTP response
		String json = om.writeValueAsString(a);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}

	public void addAvenger(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		Avenger a = om.readValue(body, Avenger.class);

		if (avService.addAvenger(a)) {
			resp.setStatus(201);
		} else {
			resp.setStatus(406);
		}

	}

	public void putAvenger(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		Avenger a = om.readValue(body, Avenger.class);

		if(avService.updateFullAvenger(a)) {
			resp.setStatus(200);
		}else {
			resp.setStatus(400);
		}
	}
	
	public void patchAvenger(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		Avenger a = om.readValue(body, Avenger.class);

		if(avService.updatePartialAvenger(a)) {
			resp.setStatus(200);
		}else {
			resp.setStatus(400);
		}
	}
	
	public void killAvenger(HttpServletResponse resp, String mark) {
		try {
			int id = Integer.parseInt(mark);
			if(avService.killAvenger(id)) {
				resp.setStatus(204);
			}else {
				resp.setStatus(400);
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
			resp.setStatus(418);
		}
	}

}
