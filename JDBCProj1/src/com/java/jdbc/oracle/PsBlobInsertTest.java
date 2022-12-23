
//Image(Blob) Insert in Oracle Database
package com.java.jdbc.oracle;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PsBlobInsertTest {

	    private static final String ORACLE_BLOB_INSERT_QUERY = "iNSERT INTO EMP VALUES(SE1.NEXTVAL,?,?,?,?,?)";
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){//try-1
			//read input value from end user
			String ename=null,job=null,ePhoto=null,sdate=null;
			double esal=0.0;
			if(sc!=null) {
				System.out.println("Enter Employee Name");
				ename= sc.next();
				System.out.println("Enter HireDate(dd-MM-YYYY))");
				sdate=sc.next();
				System.out.println("Enter employee Salary");
				esal=sc.nextDouble();
				System.out.println("Enter job name");
				job=sc.next();
				System.out.println("Enter photo location");
				ePhoto = sc.next().replace("?","");
			   
			}//if
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
			java.sql.Date ssdf= new java.sql.Date(sdf.parse(sdate).getTime());
			//establish connection with Oracle DB
			try(InputStream is=new FileInputStream(ePhoto)){//try-2
			    try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "c##tapasrout", "routtapas1")){//try-3
                    if(con!=null)
				  try(PreparedStatement ps =con.prepareStatement(ORACLE_BLOB_INSERT_QUERY)){//try-4
					  if(ps!=null) {
						  //set prepared param for prepared statement
						  ps.setString(1, ename);
						  ps.setDate(2, ssdf);
						  ps.setDouble(3, esal);
						  ps.setString(4, job);
						  ps.setBlob(5, is);
						  //create a input steam for insert photo
					  }//if
						  int count=0;
						  if(ps!=null)
							  count=ps.executeUpdate();
						  if(count==0)
							  System.out.println("Record not inserted");
						  else
							  System.out.println("Record Inserted");
						  
						  
				  }//try-4
			}//try-3
			
		}//try-2
	}//try-1
		catch(SQLException se) {
			se.printStackTrace();
			if(se.getErrorCode()==20050)
				System.out.println("Kindly Diseable trigger");
		}//catch

		catch(Exception e){
			e.printStackTrace();
		}//catch
	}//main

}//class
