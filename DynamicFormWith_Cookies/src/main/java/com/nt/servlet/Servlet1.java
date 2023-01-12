package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print writer
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read request data
		String name = req.getParameter("pname");
		String status = req.getParameter("ms");
		String padd = req.getParameter("padd");
		//create cookie with name and value
		Cookie c1 = new Cookie("name",name);
		Cookie c2 = new Cookie("status",status);
		Cookie c3 = new Cookie("padd",padd);
		//set max time
		c1.setMaxAge(5*60);
		c2.setMaxAge(3*60);
		c3.setMaxAge(4*60);
		//add cookie to the response
		res.addCookie(c1);
		res.addCookie(c2);
		res.addCookie(c3);
		
			if(status.equalsIgnoreCase("single")) {
			
			
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr>");
			pw.println("<td>Your Age::<td><td><input type='text' name='page' placeholder='Enter Age'/><td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Occupation::<td><td><input type='text' name='pocc' placeholder='Enter Your Profesion'/><td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td><input type='submit' value='Register'/><td><td><input type='Reset' value='Cancel'/><input type='hidden' name='hv' value='1'/><td>");
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
			
		}//if
		else {
			
			
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr>");
			pw.println("<td>Your Wife Name:<td><td><input type='text' name='page' placeholder='Enter Age'/><td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Children:<td><td><input type='text' name='pocc' placeholder='Enter Children Count'/><td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td><input type='submit' value='Register'/><td><td><input type='Reset' value='Cancel'/><input type='hidden' name='hv' value='0'/><td>");
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
			
		}//else
	}//get


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
