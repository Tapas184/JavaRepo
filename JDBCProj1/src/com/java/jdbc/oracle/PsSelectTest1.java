//Write a JDBC app to get person Details whose DOB in between given startDate and EndDate value.
package com.java.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PsSelectTest1 {

	private static final String RETREVE_DATE_QUERY="SELECT EMPNO,ENAME,SAL,HIREDATE FROM EMP WHERE HIREDATE BETWEEN ? AND ?";
	public static void main(String[] args) {
            Scanner sc= null; //read input from end user 
            String sdate=null,edate=null;
            Connection con =null;
            PreparedStatement  ps = null;
            ResultSet rs =null;
		try {
			sc= new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Start Date(dd-MM-YYYY) ::");
				sdate = sc.next();
				System.out.println("Enter End Date(dd-MM-YYYY) ::");
				edate = sc.next();
			}
			//convert string date to java.util.Date class obj
			 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
			 java.sql.Date ssdate = new java.sql.Date(sdf.parse(sdate).getTime());
			 java.sql.Date sedate = new java.sql.Date(sdf.parse(edate).getTime());
			
			//establish connection with Data base
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "c##tapasrout", "routtapas1");
			// create prepared statement
			if(con!=null) {
				ps= con.prepareStatement(RETREVE_DATE_QUERY);
			}
			if(ps!=null)
				ps.setDate(1, ssdate);
			    ps.setDate(2, sedate);
			    //execute query
			if(ps!=null)
				rs=ps.executeQuery();
			// process the result set
			if(rs!=null)
                   while(rs.next()) {
                	int empno = rs.getInt(1);
                	   String name =rs.getString(2);
                	   float sal = rs.getFloat(3);
                	   //java.sql.Date hiredate = rs.getDate(3);
                	   
                	   // convert java.sql.Date value to String value
                	   SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-YYYY");
                	   String hdate = sdf1.format(rs.getDate(4));
                	   System.out.println(empno+" "+name+" "+sal+" "+hdate);
                	   
                   }//while
		
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
			}//catch
			
			try {
				if(ps!=null)
					ps.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}//catch
			
			try {
				if(sc!=null)
					sc.close();
			}//try
			catch(Exception e) {
				e.printStackTrace();
			}//catch
			
		}//finally
		
	}//main 

}//class
