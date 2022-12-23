package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MairageElgibilityCheck extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// set content type
		res.setContentType("text/html");
		// get printwriter
		PrintWriter pw = res.getWriter();
		String csv = req.getParameter("vflag");
		String name = req.getParameter("pname");
		String age = req.getParameter("page");
		String add = req.getParameter("paddrs");
		// int age1 = Integer.parseInt(age);
		String gender = req.getParameter("pgender");
		int age1 = 0;
		if (csv.equals("no")) {
			List<String> errMsg = new ArrayList();
			// form verification logic
			if (name == null || name.length() == 0 || name.equalsIgnoreCase(""))
				errMsg.add("Name Must required");
			try {
				if (age == null || age.length() == 0 || age.equalsIgnoreCase(""))
					errMsg.add("Age number required");
				else {
					age1 = Integer.parseInt(age);
					if (age1 <= 18 && gender.equals("Female"))
						errMsg.add("You are too younger for mairage");
					else if (age1 <= 21 && gender.equals("Male"))
						errMsg.add("You are too younger for mairage");
				}
			} catch (NumberFormatException nfe) {
				errMsg.add("Enter age in number");
			}
			if (add == null || add.length() == 0 || add.equalsIgnoreCase(""))
				errMsg.add("Kindly enter your address");
			else if (add.length() <= 10)
				errMsg.add("Enter address more then 10 letter");
			if (errMsg.size() > 0) {
				pw.println("<ul styl='color:red;text-align:center'>");
				for (String errmsg1 : errMsg)
					pw.println("<li>" + errmsg1 + "<li>");
				pw.println("</ul>");
				return;
			}
		}
		age1 = Integer.parseInt(age);
		// write business logic
		if (age1 >= 21 && gender.equals("Male")) {
			pw.println("<h2 style='color:green;text-align:center'>Congratulation....! Mr." + name
					+ "you are elgible for Mairage</h2> ");
		} else if (age1 >= 18 && gender.equals("Female")) {
			pw.println("<h2 style='color:green;text-align:center'>Congratulation......! Miss." + name
					+ " you are elgible for Mairage</h2> ");
		} else {
			pw.println(
					"<h2 style='color:green;text-align:center'>" + name + " you are not elgible for Mairage yet</h2> ");
		} // else
		pw.println("<h1 style='color:green;text-align:center'><a href='mairage_elgbility.html'>Home</a></h1>");
		pw.close();// close IO object
	}// doget

}// class
