package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/secondurl")
public class Servlet2 extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String s1 = req.getParameter("page");
		String s2 = req.getParameter("pocc");
		int value = Integer.parseInt(req.getParameter("hv"));
		
		if(value==1) {
			pw.println("<h4 style='color:red;text-align:center'>Person Not Married</h4>");
			pw.println("<br><h4><a href='person_data.html'>HOME</a></h4>");
			
		}//
		if(value==0) {
			pw.println("<h4 style='color:red;text-align:center'>Person Married</h4>");
			pw.println("<br><h4 style='text-align:center'><a href='person_data.html'>HOME</a></h4>");
		}
		
	}//get


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//post

}
