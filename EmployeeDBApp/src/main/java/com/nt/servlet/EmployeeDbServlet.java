package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class EmployeeDbServlet extends HttpServlet {
	
	private static final String emp_Querry ="SELECT EMPNO,ENAME,HIREDATE,SAL FROM EMP WHERE EMPNO=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("/errorurl");
		 PrintWriter pw = res.getWriter(); //create a print writer object
		 //set content 
		 res.setContentType("text/html");
		 ServletConfig sc =getServletConfig();
		 String driver = sc.getInitParameter("driverclass");
		 String url = sc.getInitParameter("url");
		 String user = sc.getInitParameter("user");
		 String pass = sc.getInitParameter("pass");
		 int no=0;
		 try {
		 no = Integer.parseInt(req.getParameter("eno"));
		 }
		 catch(NumberFormatException nfe) {
			 nfe.printStackTrace();
			 rd.forward(req, res);
		 }
		 try{
			 Class.forName(driver);
		 }
		 catch(ClassNotFoundException cnf) {
			 cnf.printStackTrace();
			 rd.forward(req, res);
		 }
		 try(Connection con = DriverManager.getConnection(url,user,pass);
				 PreparedStatement ps = con.prepareStatement(emp_Querry)){
			 if(ps!=null);
			 ps.setInt(1, no);
			 try(ResultSet  rs=ps.executeQuery()){
				 if(rs!=null)
					 if(rs.next()) {
						 pw.println("<h2 style='color:red;text-align:center'>Employee Details</h2>");
						 pw.println("<table bgcolor=\"pink\" align=\"center\" border=\"1px\">");
						    pw.println("<tr>");
						       pw.println("<td>Employee ID :-</td>");
						       pw.println("<td>"+rs.getInt(1)+"</d>");
						    pw.println("</tr>");
						    pw.println("<tr>");
						       pw.println("<td>Employee Name :-</td>");
						       pw.println("<td>"+rs.getString(2)+"</d>");
						    pw.println("</tr>");
						    pw.println("<tr>");
						       pw.println("<td>Employee Hiredate :-</td>");
						       pw.println("<td>"+rs.getString(3)+"</d>");
						    pw.println("</tr>");
						    pw.println("<tr>");
						       pw.println("<td>Employee Sal :-</td>");
						       pw.println("<td>"+rs.getFloat(4)+"</d>");
						    pw.println("</tr>");
						 pw.println("</table>");
					 }//if
					 else {
						 pw.println("<h1 style='color:red;text-align:center'>Sorry...! No record found..</h1>");
					 }
			 }//try-2
			 
		 }//try-1
		 catch(Exception e) {
			 e.printStackTrace();
			 rd.forward(req, res);
		 }//catch
		 pw.println("<h4 style='text-align:center'><a href='Search.html'>Home</a></h4>");
		 
	}//post

}//class
