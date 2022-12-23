package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultipleLinkApp extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get printwriter object
		PrintWriter pw = res.getWriter();
		// set content type
		res.setContentType("text/html");
		String status = req.getParameter("vflag");
		String s1val = req.getParameter("s1");
		// initiate value if val1 and val2
		int val1 = 0, val2 = 0;
			if (!s1val.equalsIgnoreCase("link1") && !s1val.equalsIgnoreCase("link2")) {
				val1 = Integer.parseInt(req.getParameter("t1"));
				val2 = Integer.parseInt(req.getParameter("t2"));
			} // if
			if (s1val.equalsIgnoreCase("Add")) {
				pw.println("<h3>The sum of" + val1 + " and " + val2 + " is" + (val1 + val2) + "</h3>");
			}
			if (s1val.equalsIgnoreCase("Sub")) {
				pw.println("<h3>The sub of " + val1 + " and" + val2 + " is" + (val1 - val2) + "<h3>");
			}
			if (s1val.equalsIgnoreCase("Mul")) {
				pw.println("<h3>The Mul of " + val1 + " and" + val2 + " is" + ((float) val1 * val2) + "<h3>");
			}
			if (s1val.equalsIgnoreCase("Div")) {
				pw.println("<h3>The remain of " + val1 + " and" + val2 + " is" + ((float) val1 / val2) + "<h3>");
			}
			if (s1val.equalsIgnoreCase("link1")) {
				pw.println("<h2>The Syetrm properties is :</h2>");
				pw.println(System.getProperties());
			}
			if (s1val.equalsIgnoreCase("link2")) {
				pw.println("<h2 style='color:green;text-align:center'>" + LocalDateTime.now() + "</h2>");
			}
			pw.println("<h3><a href='link.html'>Home</a></h3>");
		}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
