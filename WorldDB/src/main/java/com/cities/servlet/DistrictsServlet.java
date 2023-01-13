package com.cities.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cities.classes.JDBCHandling;

public class DistrictsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		JDBCHandling jdbcObject = new JDBCHandling();
		response.getWriter().println(jdbcObject.getDistrict());
	}
}
