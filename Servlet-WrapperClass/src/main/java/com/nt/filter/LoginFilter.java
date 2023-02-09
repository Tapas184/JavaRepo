package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrapper.CustomeRequest;
import com.nt.wrapper.CustomeResponse;
@WebFilter("/loginurl")
public class LoginFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
    //create custome request object
CustomeRequest creq = new CustomeRequest(req);
CustomeResponse cres = new CustomeResponse(res);
chain.doFilter(creq, cres);	
//collect content from customer respose obj
String outPut = cres.toString();
//modify the content
outPut+=("<h4>"+LocalDateTime.now()+"</h4>");
//get print writer object pointing to contain created response obj
PrintWriter pw = res.getWriter();
//writes container created reponse obj--->container--->Server--->brower
pw.println(outPut);
//close the stream
pw.close();
    }

}
