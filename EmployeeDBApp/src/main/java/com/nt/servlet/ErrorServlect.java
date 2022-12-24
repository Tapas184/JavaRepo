package com.nt.servlet;
//Error showing in browser by forword(req,res) method
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/errorurl")
public class ErrorServlect extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter object
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		pw.println("<h3 style='color:red;text-align:center'>Error:: Error in given data, Kindly try again..</h3>");
		pw.println("<br><br><h4 style='text-align:center'><a href='Search.html'>Home</a></h4>");
		pw.close();
	}//doget
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req,res);
	}

}
