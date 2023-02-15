<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%!
Connection con=null;
PreparedStatement ps1 = null;
PreparedStatement ps2 = null;
private static final String INSERT_QUERY = "INSERT INTO JSP_CUST VALUES(SE1.NEXTVAL,?,?,?)";
private static final String SELECT_QUERY = " SELECT SL_NO,NAME,AGE,EMAILID FROM JSP_CUST";
 public void jspInit(){
     //get servlect config object
     ServletConfig cfg = getServletConfig();
     //read init param value from xml files
     String driver = cfg.getInitParameter("driverClass");
     String url = cfg.getInitParameter("url");
     String userName = cfg.getInitParameter("username");
     String passWord = cfg.getInitParameter("password");
    
     try{
	 //load the driver
	 Class.forName(driver);
	 //establish the connection
	 con = DriverManager.getConnection(url, userName, passWord);
	 //execute the query
	 ps1=con.prepareStatement(INSERT_QUERY);
	 ps2=con.prepareStatement(SELECT_QUERY); 
     }//try
    catch(Exception e){
	e.printStackTrace();
    }//catch
}//init
%>
<%
String pval = request.getParameter("p1");
if(pval.equalsIgnoreCase("link1")){
	ResultSet rs = ps2.executeQuery();%>
<table>
	<tr>
		<th>Sl_No</th>
		<th>PName</th>
		<th>PAge</th>
		<th>PMail</th>
	</tr>
	<%
  while(rs.next()){%>
	<tr>
		<td><%= rs.getInt(1) %></td>
		<td><%= rs.getString(2) %></td>
		<td><%= rs.getInt(3) %></td>
		<td><%= rs.getString(4) %></td>
	</tr>
</table>
<%}//while
}//if
  else{
	  String name = request.getParameter("pname");
	  int age = Integer.parseInt(request.getParameter("page"));
	  String email = request.getParameter("mail");
	  //set param to prepared statement
	  ps1.setString(1,name);
	  ps1.setInt(2,age);
	  ps1.setString(3,email);
	  //process the ps1
	  int result = ps1.executeUpdate();
	  if(result==0){%>
<h3 style="color: red; text-align: center;">Error in registration
	try after some time</h3>
<%}
	  else{%>
<h3 style="color: red; text-align: center;">SucessFuly Registered</h3>
<%}
  %>
<center>
	<a href="form.html">Home</a>
</center>
<%}
%>
