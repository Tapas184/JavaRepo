package com.nt.wrapper;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CustomeResponse extends HttpServletResponseWrapper {
private HttpServletResponse response;
private CharArrayWriter writer;
    public CustomeResponse(HttpServletResponse response) {
	super(response);
	System.out.println("CustomeResponse.CustomeResponse(-)::1- param Constructor");
	this.response=response;
	writer = new CharArrayWriter(); // internally create buffer and takes it destination
    }
@Override
    public PrintWriter getWriter() throws IOException {

    PrintWriter pw = new PrintWriter(writer);// indirectly stream is taken buffer writer as destination
    return pw;
    }
@Override
    public String toString() {
	// TODO Auto-generated method stub
	return writer.toString();// content collected from buffer and returned custome response object content
    }
}
