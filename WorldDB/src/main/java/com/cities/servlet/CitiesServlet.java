package com.cities.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cities.classes.JDBCHandling;

public class CitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String district =  request.getParameter("state-name");
		JDBCHandling jdbcObject = new JDBCHandling();
		String[] cities = jdbcObject.getCorrespondingCities(district);
		
		request.setAttribute("city", cities);
		request.setAttribute("district", district);
		
		RequestDispatcher rd = request.getRequestDispatcher("Cities.jsp");
		rd.forward(request, response);
	}

}
