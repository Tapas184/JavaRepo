package com.TR.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
@WebServlet("/uploadurl")
public class EmployeeUpload extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();//create a IO print writer object
		//set content type (txt/html)
		res.setContentType("text/html");
		//read special  request 
		try {
		MultipartFormDataRequest mpfd = new MultipartFormDataRequest(req);
		//read form data
		String name = mpfd.getParameter("ename");
		String add = mpfd.getParameter("eadd");
		//create upload class object
		
		UploadBean upb= new UploadBean();
		upb.setFolderstore("E:/store");
		//when same file came
		upb.setOverwrite(false);
		
		//set file size
		upb.setFilesizelimit(100*1024);
		//complete file uploading
		upb.store(mpfd);
		//display successfully
		pw.println("<b>Successfully File uploaded</b>");
		}//try
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h3 style='color:red;text-align:center'>Error in file upload</h3>");
		}//catch
		pw.println("<h4 style='text-align:center'><a href='index.html'>Home</a></h4>");
		//closing IO stream object
		pw.close();
	}//get
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req,res);
	}//post

}
