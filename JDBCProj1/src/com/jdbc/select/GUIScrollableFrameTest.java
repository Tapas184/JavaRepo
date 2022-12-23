package com.jdbc.select;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIScrollableFrameTest extends JFrame implements ActionListener {
	private JLabel lb1,lb2,lb3,lb4;
	private JTextField tsno,tsname,thire,tavg;
	private JButton b1,b2,b3,b4;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String hdate1;
	private static final String GET_STUDENT_QUERY = "SELECT EMPNO,ENAME,HIREDATE,SAL FROM EMP";
	@SuppressWarnings("deprecation")
	public GUIScrollableFrameTest() {
		 setTitle("Student Information GUI");
		setSize(700,300);
		setLayout(new FlowLayout());
		
		//add component
		lb1= new JLabel("EMPNO");
		add(lb1);
	 tsno = new JTextField("EMP No",10);
		 add(tsno);
		
	 lb2=new JLabel("ENAME");
			add(lb2);
	 tsname = new JTextField("ENAME",10);
			 add(tsname);
			 
	 lb3=new JLabel("HireDate");
				add(lb3);
	 thire = new JTextField("HireDate",10);
				 add(thire);
				 
	lb4=new JLabel("SAL");
					add(lb4);
  tavg = new JTextField("SAL",10);
					 add(tavg);
					 
	// Add Button 
			
			 b1= new JButton("First");
			 b2= new JButton("Next");
			 b3= new JButton("Previous");
			 b4= new JButton("Last");
			add(b1);add(b2);add(b3);add(b4);
			
			// register and activate Actionlistener for all button
			 b1.addActionListener(this);
			 b2.addActionListener(this);
			 b3.addActionListener(this);
			 b4.addActionListener(this);
					 
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// closing the frame window will terminates  the application flow.
       System.out.println("GUIScrollableFrameTest: 0-paramConstructor(Start)");	
       initializeJDBC();
	}
	
	
	private void initializeJDBC() {
		try {
			//establish the connection
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","c##tapasrout","routtapas1" );
			if(con!=null)
				//create prepared statement object
			ps = con.prepareStatement(GET_STUDENT_QUERY,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//prepare Scrollable  RS obj. 
			rs = ps.executeQuery();
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//initializer
	public static void main(String[] args) {
   
	  new GUIScrollableFrameTest(); // Anonymous Object
	  
	  System.out.println("End main Method");// end the main method
	  
	}//main

	   @Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("GUI Action button are performed");
		boolean flag= false;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY");
		if(e.getSource()==b1) {
			System.out.println("FirstButton Is Clicked");
			try {
			rs.first();
			flag=true;
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}//catch
		}
		else if(e.getSource()==b2) {
			System.out.println("Next Button Clicked");
			try {
				if(!rs.isLast())
			rs.next();
			flag=true;
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception ae) {
				ae.printStackTrace();
			}
			
		}
		
		else if(e.getSource()==b3) {
			System.out.println("Previous button clicked");
			try {
				if(!rs.isFirst()) 
			rs.previous();
				flag=true;
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception ae) {
				ae.printStackTrace();
			}
		}
		else {
			System.out.println("Last Button Closed");
			try {
				rs.last();
				flag=true;
	    	}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//else
		if(flag=true) {
			try {
			tsno.setText(rs.getString(1));
			tsname.setText(rs.getString(2));
			thire.setText(sdf.format(rs.getDate(3)));
			tavg.setText(rs.getString(4));
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	   }
	   }//actionformed

