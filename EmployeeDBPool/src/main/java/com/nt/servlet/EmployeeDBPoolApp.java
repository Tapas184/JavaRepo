package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class EmployeeDBPoolApp extends HttpServlet {
	private static final String Querry="Insert into SERVLET_CUSTOMER VAlues(?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}//do get
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Create a printwriter object
		PrintWriter pw= res.getWriter();
		// set content type
		res.setContentType("text/html");
		//read data from from data
		String ename=req.getParameter("ename");
		String add=req.getParameter("eadd");
		long number = Long.parseLong(req.getParameter("ephn"));
		try(Connection con =getConnectionPool();
			PreparedStatement ps = con.prepareStatement(Querry)){
			if(ps!=null) {
				ps.setString(1, ename);
				ps.setString(2, add);
				ps.setLong(3, number);
			}//
		int result = ps.executeUpdate();
		
		if(result==1) {
			pw.println("<h3 style='color:green;text-align:center'>Sucessfully Registered</h3>");
			pw.println("<h4 style='text-align:center'><a href='emp_reg.html'>New Registration</a></h4>");
			
			}
		else {
			pw.println("<h3 style='color:red;text-align:center'>Registration failed try again</h3>");
			pw.println("<h4 style='text-align:center'><a href='emp_reg.html'>Try Again</a></h4>");
			}
			
		}//try
		
		catch(SQLException se) {
			se.printStackTrace();
		}//catch
		catch(Exception e) {
			e.printStackTrace();
		}//catch
		
		pw.close(); // closing the stream object. .
		
	}//doPost(-,-)
	
	private Connection getConnectionPool() throws Exception {
		
		InitialContext ic = new InitialContext();
		//get dsjndi name from init param
		String jndiName = getServletConfig().getInitParameter("dsjndi");
		//generate Data source object
		DataSource ds = (DataSource)ic.lookup(jndiName);
		//get pooled JDBC connection
		Connection con = ds.getConnection();
		return con;
	}
	

}//class
