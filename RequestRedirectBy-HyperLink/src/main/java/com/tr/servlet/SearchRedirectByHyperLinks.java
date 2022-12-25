package com.tr.servlet;
//both hyperlinks and res,sendRedirect() method
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchRedirectByHyperLinks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();//create a print writer object
		//set content type
		res.setContentType("text/html");
		//read request
		String custs=req.getParameter("search");// read customer query
		String engine = req.getParameter("ss"); // read selected search platform
		String url=null;
			if(engine.equalsIgnoreCase("gs")) {
				//pw.println("<h3 style='text-align:center'><a href='https://www.google.co.in/search?q="+custs+"'>Click for search in Google</a></h3>");
				url="https://www.google.co.in/search?q="+custs;
			 // pw.println("<br><br><h2 style='text-align:center'><a href=search.html>Home</a></h2>");
		}else if(engine.equalsIgnoreCase("bs")) {
			//pw.println("<h3 style='text-align:center'><a href='https://www.bing.com/search?q="+custs+"'>Click for search in Bing</a></h3>");
			 // pw.println("<br><br><h2 style='text-align:center'><a href=search.html>Home</a></h2>");
			url="https://www.bing.com/search?q="+custs;
		}else if(engine.equalsIgnoreCase("bs")) {
			//pw.println("<h3 style='text-align:center'><a href='https://in.search.yahoo.com/search?p="+custs+"'>Click for search in Yahhoo!</a></h3>");
			 // pw.println("<br><br><h2 style='text-align:center'><a href=search.html>Home</a></h2>");
			url="https://in.search.yahoo.com/search?p="+custs;
		}//if
			//sent url to res obj
			res.sendRedirect(url);
			pw.close();// close  IO stream object

	}//doGet

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
 
	}//dopost

}//class
