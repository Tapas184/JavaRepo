package com.java.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// count account age from account table by given account number
public class AgeCountOracle {
	//write a prepared statemnt
	private static final String query = "SELECT ROUND((SYSDATE-AOD)/365.25,2) FROM CUSTOMER WHERE ACCOUNTNO = ?";
	
	public static void main(String[] args) {
		Scanner sc = null;
		Connection con= null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		try {
			sc=new Scanner(System.in);
			//read input from end user
			if(sc!=null)
				System.out.println("Enter account number : ");
			long acno=sc.nextLong();
			
			//establish connection with oracle data base
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "c##tapasrout", "routtapas1");
			if(con!=null)
				//create prepared statement for query
				ps=con.prepareStatement(query);
			if(ps!=null)
				//process the prepared statement
				ps.setLong(1, acno);
			if(ps!=null)
				//execute the query
				rs=ps.executeQuery();
			if(rs!=null) {
				double age =0.0;
				if(rs.next()) {
					age = rs.getDouble(1);
					System.out.println("The age of acount is :"+age);
				}
				else
					System.out.println("Enter valid account number");
			}//if

		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}//catch
		catch(Exception e)
		{
			e.printStackTrace();
		}//catch
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
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
			catch(Exception se) {
				se.printStackTrace();
			}//catch
		}

	}//main

}//class
