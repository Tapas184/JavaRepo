package com.java.javaExample;

import java.util.ArrayList;
import java.util.Collections;

public class StringCompairision {

	
	public static void main(String[] args) {
     
		ArrayList<Employee> e = new ArrayList<Employee>();
		e.add(new Employee("Tapas",1005,"HYD",5000));
		e.add(new Employee("Subha",1007,"BBSR",9000));
		e.add(new Employee("Alok",1010,"BLS",3000));
		e.add(new Employee("Jaga",1008,"BLR",2000));
		
		System.out.println(e);
		
		Collections.sort(e, (e1,e2)-> e1.name.compareTo(e2.name));
		System.out.println(e);
		
	}

}
