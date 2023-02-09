package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String rval = req.getParameter("t1");
		Locale[] locales = Locale.getAvailableLocales();
		if(rval.equalsIgnoreCase("link1")) {
			pw.println("<h3>All cuntries are</h3>");
			for(Locale l:locales)
			pw.println(l.getDisplayCountry()+",");
			
		}else if(rval.equalsIgnoreCase("link2")) {
			pw.println("<h3>All Languages are</h3>");
			for(Locale l:locales)
				pw.println(l.getDisplayLanguage()+",");
		}else {
			pw.println("<h2 style='color:greenyellow;text-align:center'>"+LocalDateTime.now()+"</h2>");
		}
		pw.println("<h5 style='text-align:center'><a href='link.html'>HOME</a></h5>");
		pw.close();//print write object close
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         doGet(req, res);
	}

}
