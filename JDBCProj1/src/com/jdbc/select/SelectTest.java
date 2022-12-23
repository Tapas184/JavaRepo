//Write a JDBC app find who are geting lowest salary 
package com.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) 
	{
		Connection con=null;
		Statement st= null;
		ResultSet rs =null;
       try {
    	   //establish connection with JDBC Driver
    	   con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "c##tapasrout", "tapas1");
    	   if(con!=null)
    		   st = con.createStatement(); //create statement update.
    	   String query = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL=(SELECT MIN(SAL) FROM EMP)";
    	   if(st!=null)
    		   rs=st.executeQuery(query); //execute query
    	   boolean flg=false;
    	   System.out.println("The employee details are");
    	   if(rs!=null)
    	   while(rs.next()) {
    		   flg =true;
    		   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
    	   }//while
    	   
    	   if(flg==false)
    		   System.out.println("No Record Found");
	}//try
       catch(SQLException se) {
    	   se.printStackTrace();
       }//catch
       catch(Exception e) {
    	   e.printStackTrace();
       }//catch
       
       finally {
    	   try {
    		   if(rs!=null)
    			   rs.close();
    	   }//try
    	   catch(SQLException se) {
    		   se.printStackTrace();
    	   }
    	   try {
    		   if(st!=null)
    			   st.close();
    	   }//try
    	   catch(SQLException se) {
    		   se.printStackTrace();
    	   }
    	   try {
    		   if(con!=null)
    			   con.close();
    	   }//try
    	   catch(SQLException se) {
    		   se.printStackTrace();
    	   }
       }//finally

   }//main
}//class
