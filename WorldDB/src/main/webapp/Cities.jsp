<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cities</title>
	<link href="cssfiles/CitiesStyle.css" type="text/css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Patrick+Hand&display=swap" rel="stylesheet">
</head>
<body>
	<p id="main-title">
		<%
			String stateName = (String) request.getAttribute("district");
			out.println("Cities of " + stateName);
		%>
	</p>
	<div id="cities-region">
		<%
		String[] cities = (String[]) request.getAttribute("city");
		for(int ind = 0; ind < cities.length; ind++){
			out.println("<p class='city'>" + cities[ind] + "</p>");
		}
		%>
	</div>
</body>
</html>