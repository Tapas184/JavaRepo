package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoronaServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// create print writer object
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String name = req.getParameter("pname");
		String address = req.getParameter("padd");
		String age = req.getParameter("page");
		int age1 = Integer.parseInt(age);
		if (age1 >= 18) {
			pw.println("<h1 style='color:green; text-align:center'>Congratulation " + name
					+ " you are Eligible for vacination</h1>");
		} else {
			pw.println("<h1 style='color:green; text-align:center'>Sorry..! " + name
					+ " you are not Eligible for vacination</h1>");
		}
		pw.println("<br><br><form action='corona_vacine.html' method='get'><input type='submit' value='Home'></form>");
		// closed the stream object
		pw.close();
	}
}
