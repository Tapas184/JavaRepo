package com.java.javaExample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class NthHigestSlaryEmployee {
	
	public static void nthSalary(Object[] fa)
	{
		int size=fa.length;
		if(size<2) {
			System.out.println("invalid input");
			return;
		}
		
		for(int i = size-2;i<=0;i--) {
			if(fa[i]!=fa[size-1])
		}
	}
	
	
	public static void main(String[] args) {
		ArrayList<Employee> l = new ArrayList<Employee>();
		l.add(new Employee("Tapas",1007,"BLS",4000));
		l.add(new Employee("Subha",1004,"HYD",7000));
		l.add(new Employee("Hari",1006,"BBSR",9000));
		l.add(new Employee("Raju",1003,"BLR",5000));
		l.add(new Employee("Ram",1005,"CHI",7000));
		
		List<Employee> l1 = l.stream().sorted((s,s1) -> s.getSalary()>s1.getSalary()? -1 :s.getSalary()<s1.getSalary()?1:0).collect(Collectors.toList());
                  
		   List l2=l1.stream().map(e -> e.getSalary()).collect(Collectors.toList());
		   Object[] fa =l2.toArray();
		
	}//main
}// class
