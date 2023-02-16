<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
//read parameter from HTML page
String s = request.getParameter("search");
//send redirect to Google
response.sendRedirect("https://www.google.com/search?q="+s);
%>