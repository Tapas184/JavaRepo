//Write a JDBC program to retrive images from Data base
package com.java.jdbc.oracle;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;


public class PsBlobRetriveTest {
	// Write a query for prepared statement
	private static final String ORACLE_RETRIVE_QUERY = "SELECT ENAME,JOB,EPHOTO FROM EMP WHERE EMPNO=?";

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {// try-1
			System.out.println("Enter Employee Number");
			int Empno = sc.nextInt();
			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "c##tapasrout",
					"routtapas1")) {// try-2
				if (con != null)
					// create a prepared statement object for squery
					try (PreparedStatement ps = con.prepareStatement(ORACLE_RETRIVE_QUERY)) {// try-3
						if (ps != null)
							// set query Param
							ps.setInt(1, Empno);
						try (ResultSet rs = ps.executeQuery()) {// try-4
							if (rs != null)
								if (rs.next()) {
									String Ename = rs.getString(1);
									String job = rs.getString(2);
									System.out.println(Ename + " " + job);
									// set input stream pointing to Bolb value
									try (InputStream is = rs.getBinaryStream(3);
											OutputStream os = new FileOutputStream("retrive.jpg")) {// try-5
										IOUtils.copy(is, os);
										System.out.println("Record retrived");

									} // try-5
								} // if
						} // try-4

					} // try-3

			} // try-2

		} // try-1
		catch (SQLException se) {
			se.printStackTrace();
		} // catch
		catch (Exception e) {
			e.printStackTrace();
		} // catch
	}// main

}// class
