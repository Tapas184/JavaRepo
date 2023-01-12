package com.TR.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;
@WebServlet("/uploadurl")
public class EmployeeUpload extends HttpServlet {
	private static final String QUERRY = "INSERT INTO EMP_DETAILS VALUES(SE1.NEXTVAL,?,?,?,?)";
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
		Vector<UploadParameters> vector = upb.getHistory();
		ArrayList<String> fileList = new ArrayList<String>();
		vector.forEach(up->{
			fileList.add("E:/store/"+up.getFilename());
		});
		Cookie c1 = new Cookie("Name",name);
		Cookie c2 = new Cookie("Address",add);
		c1.setMaxAge(6000);
		c2.setMaxAge(5000);
		res.addCookie(c1);
		res.addCookie(c2);
		
		// Write jdbc code to form data and  file location to db table as record
		// load jdbc
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","c##tapasrout","routtapas1");
				PreparedStatement ps = con.prepareStatement(QUERRY)){
			if(ps!=null) {
				ps.setString(1, name);
				ps.setString(2, add);
				ps.setString(3,fileList.get(0));
				ps.setString(4, fileList.get(1));
			}
			try {
				int rs = ps.executeUpdate();
				if(rs==1) 
					pw.println("<b>Successfully File uploaded</b>");
				else
					pw.println("<b>File uploading failed</b>");
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
			pw.println("<h3 style='color:red;text-align:center'>Error in DB connection</h3>");
			}
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
