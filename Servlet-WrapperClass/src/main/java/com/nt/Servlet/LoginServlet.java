package com.nt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	System.out.println("LoginServlet.doGet(_,_)");
	//create a print writer object
	PrintWriter pw = res.getWriter();
	//set content type in response object
	res.setContentType("text/html");
	//gather data from form
	String userName = req.getParameter("user");
	String password = req.getParameter("pswd");
	System.out.println(userName+" "+password);
	if(userName.equalsIgnoreCase("tapas@gmail.com") && password.equalsIgnoreCase("tapasrout")) {
	    pw.println("<h3 style='color:green;text-align:center'>Login Sucessfully</h3>");
	}else {
	    pw.println("<h3 style='color:red;text-align:center'>Login faild..Try again </h3>");
	}
	pw.println("<h4 style='text-align:center'><a href='login.html'>HOME</a></h4>");
	pw.close();//Close IO Stream Object
    }//do get

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	doGet(req, res);
    }//do post
}
