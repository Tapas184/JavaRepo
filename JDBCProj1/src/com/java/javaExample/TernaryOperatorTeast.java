package com.java.javaExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TernaryOperatorTeast {

	public static void main(String[] args) {
		 ArrayList<Integer> l = new ArrayList<Integer>();
		 // add value to array list
		 l.add(18);
		 l.add(28);
		 l.add(15);
		 l.add(07);
		 l.add(24);
		 l.add(35);
		 l.add(17);
		 l.add(19);
		 l.add(26);
		 l.add(34);
		 System.out.println(l);
		 //By ternary operator (?) use we can avoid if block
		 Comparator<Integer> c  =(i1,i2)->(i1>i2)?1:(i1<i2)?-1:0;
		 //sort Array list
		 Collections.sort(l,c);
		 //print Sorted Array list
		 System.out.println(l);
		 

	}

}
