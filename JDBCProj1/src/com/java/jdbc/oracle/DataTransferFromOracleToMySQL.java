/*Data Transfer from oracle to Mysql.
  oracle-Select operation
  Mysql - Insert Operation*/

package com.java.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTransferFromOracleToMySQL {

	 private final static String ORACLE_SELECT_QUERY="SELECT ENAME,HIREDATE,SAL,JOB FROM EMP";
	 private final static String MYSQL_INSERT_QUERY ="INSERT INTO EMP(ENAME,hiredate,sal,job) VALUes(?,?,?,?)";
	public static void main(String[] args) {
		//establish connection with ORACLE Driver
		try(Connection ocon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","c##tapasrout","routtapas1");
			 Connection mcon =DriverManager.getConnection("jdbc:mysql:///mysqldb", "root", "rootmysql")){
          if(mcon!=null)
        	  //create a preparedStatement 
        	  try(PreparedStatement ps = mcon.prepareStatement(MYSQL_INSERT_QUERY)){
        		  if(ocon!=null)
        			  try(Statement st= ocon.createStatement()) {
        		  if(ps!=null)
        			  // execute select query the result 
        			  try(ResultSet rs = st.executeQuery(ORACLE_SELECT_QUERY)){
        				while(rs.next()) {
        					//gather recored from rs
        					String name = rs.getString(1);
        					java.sql.Date hireDate = rs.getDate(2);
        					int sal =rs.getInt(3);
        					String job =rs.getString(4);
        					//set each record value as INSERT Query param values into mySQL Db table
        					ps.setString(1, name);
        					ps.setDate(2, hireDate);
        					ps.setInt(3, sal);
        					ps.setString(4, job);
        					//execute insert query
        					int cont = ps.executeUpdate();
        				}//while
        				System.out.println("Records are sucessfully copied"); 
        			  }//try-4
        	  }//try-3
         }//try-2
			
		}//try-1
		catch(SQLException se) {
			se.printStackTrace();
		}//catch
		catch(Exception e) {
			e.printStackTrace();
		}//catch

	}//main
}//class
