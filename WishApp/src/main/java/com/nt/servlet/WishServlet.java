package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class WishServlet extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	  //set content type
		res.setContentType("text/html");
		//create printwriter object
		PrintWriter pw = res.getWriter();
		// create loacal date and time object
		LocalDateTime ldt = LocalDateTime.now();
	   int hour = ldt.getHour();
	   int minute=ldt.getMinute();
	   SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
	   if(hour<12)
	   {
		   pw.println("<h1 style='color:brown;text-align:center'>Good Morning</h1>");
	   }
	   else if(hour<16) {
		   pw.println("<h1 style='color:green;text-align:center'>Good Afternoon</h1>");
	   }else if(hour<19) {
		   pw.println("<h1 style='color:red;text-align:center'>Good Evening</h1>");
	   }else {
		   pw.println("<h1 style='color:yellow;text-align:center'>Good Night</h1>");
	   }
	   pw.println("<br><h1 style='color:green;text-align:center'>Time is ::"+hour+":"+minute+"</h1>");
	   //add home ancore tag to redirect to home page
	   pw.println("<br><h1 style='text-align:center'><a href='page.html'>Home</a></h1>");
	   //close the stream obj
	   pw.close();
	}

}
