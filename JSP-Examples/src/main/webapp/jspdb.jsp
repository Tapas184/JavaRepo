<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="oracle.jdbc.proxy.annotation.Pre"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%!

Connection con=null;
PreparedStatement ps1 = null;
PreparedStatement ps2 = null;
private static final String INSERT_QUERY = "INSERT INTO JSP_CUST VALUES(SE1.NEXTVAL,?,?,?)";
private static final String SELECT_QUERY = " SELECT (SL_NO,NAME,AGE,EMAILID) FROM JSP_CUST";
 public void jspInit(){
     //get servlect config object
     ServletConfig cfg = getServletConfig();
     //read init param value from xml files
     String driver = cfg.getInitParameter("driver");
     String url = cfg.getInitParameter("url");
     String userName = cfg.getInitParameter("username");
     String passWord = cfg.getInitParameter("password");
    
     try{
	 //load the driver
     Class.forName(driver);
	 //establish the connection
	 con =DriverManager.getConnection(url,userName,passWord);
	 //execute the query
	 ps1=con.prepareStatement(INSERT_QUERY);
	 ps2=con.prepareStatement(SELECT_QUERY);
	 
     }
    catch(Exception e){
	e.printStackTrace();
    }
    
}
%>
