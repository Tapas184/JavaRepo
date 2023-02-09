//BrowerFilteres
package com.nt.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class BrowerFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
//get Printwriter Object
	PrintWriter pw = res.getWriter();
	//set Content Type
	res.setContentType("text/html");
	String browser = req.getHeader("user-agent");
	System.out.println(browser);
	if(browser.contains("chrome"))
	    chain.doFilter(req, res);
	else {
	    pw.println("<h3 style='color:red;text-align:center'>Kindly use Chrome Browser To get this request</h3>");
	return;
	}
	pw.close();//close the IO stream content
    }
}
