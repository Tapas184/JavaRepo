package com.nt.servlet;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;


public class ExcelServlet extends HttpServlet
 {
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
     {
        //set the document type
         res.setContentType("application/vnd.ms-excel");
         // Create a printwriter obj
         PrintWriter pw = res.getWriter();
         
         pw.println("<table border='1'align='center'>");
         pw.println("<tr><th>Name</th> <th>Number</th> <th>City</th></tr>");
         pw.println("<tr><td>Tapas</td> <td>9668204639</td> <td>BLS</td></tr>"); 
         pw.println("<tr><td>Subha</td> <td>9937151064</td> <td>BDRK</td></tr>");
         pw.println("<tr><td>Biswa</td> <td>9558964733</td> <td>SORO</td></tr>"); 
         pw.println("</table>");
         
        //close pw object
        pw.close();
    }//service
}//class
