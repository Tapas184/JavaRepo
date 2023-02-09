package com.nt.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class TimeFilters extends HttpFilter {
 @Override
protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
        throws IOException, ServletException {
     //create locatDateTime object
     LocalDateTime ldt = LocalDateTime.now();
     //create Printwriter object
     PrintWriter pw = res.getWriter();
     //set content type
     res.setContentType("text/html");
     int hour=ldt.getHour();
     if(hour>=11 && hour<=16)
	 chain.doFilter(req, res);
     else
     {
	 pw.println("<h3 style='color:red;text-align:center'>Kindly access the link in between 11 am to 4 Pm</h3>");
     }
pw.close();
}

}
