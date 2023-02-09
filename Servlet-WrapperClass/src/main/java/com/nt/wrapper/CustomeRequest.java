package com.nt.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomeRequest extends HttpServletRequestWrapper {

    private HttpServletRequest request;
    public CustomeRequest(HttpServletRequest request) {
	super(request);
	this.request=request;
    }
@Override
public String getParameter(String name) {
    String paramValue = request.getParameter(name);
    if(name.equals("user"))
	if(!paramValue.endsWith("@gmail.com")) {
	    paramValue +="@gmail.com";
	}//if
    return paramValue;
}

}
