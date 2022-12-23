package com.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest2 {

	public static void main(String[] args) {
		Scanner sc = null;
		int n = 0;
		Connection con = null;
		Statement st = null;
		String query = null;
		ResultSet rs = null;

		try {
			sc = new Scanner(System.in); // Create a scanner object to read value in run time
			System.out.println("Enter the which position salary you want "); // print the statement
			n = sc.nextInt();
			// establish connection with jdbc driver
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "c##tapasrout", "tapas1");

			if (con != null)
				st = con.createStatement();// create a statement object by connection reference
			// writen a select query which gives nth position salary emp name
			query = "SELECT  EMPNO,ENAME,SAL FROM(SELECT EMPNO,ENAME,SAL,DENSE_RANK() OVER(ORDER BY SAL DESC) AS RANK FROM EMP)  WHERE RANK="
					+ n;
			if (st != null)
				rs = st.executeQuery(query);
			boolean flg = false;
			while (rs.next()) {
				flg = true;
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getFloat(3));
			} // while
			if (flg == false)
				System.out.println("No record Found");
		} // try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} // try
			catch (SQLException se) {
				se.printStackTrace();
			} // catch

			try {
				if (st != null)
					st.close();
			} // try
			catch (SQLException se) {
				se.printStackTrace();
			} // catch

			try {
				if (con != null)
					con.close();
			} // try
			catch (SQLException se) {
				se.printStackTrace();
			} // catch

			try {
				if (sc != null)
					sc.close();
			} // try
			catch (Exception e) {
				e.printStackTrace();
			} // catch
		} // finally
	}// main

}// class
