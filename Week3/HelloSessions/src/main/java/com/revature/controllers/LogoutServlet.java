package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.UserDTO;

public class LogoutServlet extends HttpServlet {

	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses = req.getSession(false);

		if (ses != null) {
			ses.invalidate();
		}
		// resp.sendRedirect(""); //sends back to the base url of my application.
		resp.sendRedirect("http://www.google.com");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	// This is the absolute wrong place to do this. This is a demo.
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses = req.getSession(false);

		if (ses != null) {
			StringBuilder sb = new StringBuilder();

			BufferedReader reader = req.getReader();

			String line = reader.readLine();

			while (line != null) {
				sb.append(line);
				// advance to the next line
				line = reader.readLine();
			}

			String body = new String(sb);

			UserDTO user = om.readValue(body, UserDTO.class);

			ses.setAttribute("username", user.username);
			System.out.println(user.password);
			resp.setStatus(202);
		} else {
			resp.sendRedirect("");
		}
	}

}
