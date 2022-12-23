package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HtmlServlet extends HttpServlet
 {
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
     {
        //set the document type
         res.setContentType("text/html");
         // Create a printwriter obj
         PrintWriter pw = res.getWriter();
         // auto refresh the page
         //res.setHeader("refresh", "1");
         res.setIntHeader("refresh",3);
         pw.println("<table border='1'align='center'>");
         pw.println("<tr><th>Name</th> <th>Number</th> <th>City</th></tr>");
         pw.println("<tr><td>Tapas</td> <td>9668204639</td> <td>BLS</td></tr>"); 
         pw.println("<tr><td>Subha</td> <td>9937151064</td> <td>BDRK</td></tr>");
         pw.println("<tr><td>Biswa</td> <td>9558964733</td> <td>SORO</td></tr>"); 
         pw.println("</table>");
         pw.println("<br><div><b style='color: blue' text-align='400 600'> Date & Time is ::-"+new java.util.Date()+"<b>s</div>");
        //close pw object
        pw.close();
       
    }//service
}//class
