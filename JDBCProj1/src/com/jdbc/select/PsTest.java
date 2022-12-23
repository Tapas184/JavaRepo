//write a program using prepared statement
package com.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PsTest {

	private final static String query = "SELECT EMPNO,ENAME,SAL FROM EMP WHERE EMPNO>=? AND EMPNO<=?";
	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sc= new Scanner(System.in);// read data from end user
			int startId =0,endId = 0;  // assign value
			if(sc!=null) {
				System.out.println("Enter Start Employee Id");
				startId = sc.nextInt(); // this is the 1st "?"
				System.out.println("Enter End Employee Id");
				endId = sc.nextInt();  // this is the 2nd value "?"
			}
			
			//establish the connection with DB
			  // Class.forName("JDBC.ORACLE.driver.OracleDriver");
			
			// as it is support auto loading 
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "c##tapasrout", "tapas1");
			if(con!=null)
				 //prepaer a statement using prepared statement
			    ps = con.prepareStatement(query);
			if(ps!=null) {
				ps.setInt(1, startId);
				ps.setInt(2, endId);
			}
			if(ps!=null)
				rs=ps.executeQuery();
			boolean flg = false;
			if(rs!=null)
			while(rs.next()){
				flg=true;
			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
				
			}// end while
			if(flg==false)
				System.out.println("No Recored are Found");
			
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
				if(con!=null)
					con.close();
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

}// class
