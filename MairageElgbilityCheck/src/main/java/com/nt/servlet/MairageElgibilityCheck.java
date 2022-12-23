package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MairageElgibilityCheck extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// set content type
		res.setContentType("text/html");
		// get printwriter
		PrintWriter pw = res.getWriter();
		String name = req.getParameter("pname");
		String age = req.getParameter("page");
		int age1 = Integer.parseInt(age);
		String gender = req.getParameter("pgender");
		// write business logic
		if (age1 >= 21 && gender.equals("Male")) {
			pw.println("<h2 style='color:green;text-align:center'>Congratulation....! Mr." + name
					+ "you are elgible for Mairage</h2> ");
		} else if (age1 >= 18 && gender.equals("Female")) {
			pw.println("<h2 style='color:green;text-align:center'>Congratulation......! Miss." + name
					+ " you are elgible for Mairage</h2> ");
		}else {
			pw.println("<h2 style='color:green;text-align:center'>" + name
					+ " you are not elgible for Mairage yet</h2> ");
		}//else
		pw.println("<h1 style='color:green;text-align:center'><a href='mairage_elgbility.html'/>Home</a></h1>");
		pw.close();//close IO object
	}//doget

}//class
