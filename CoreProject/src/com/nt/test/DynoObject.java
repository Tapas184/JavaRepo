package com.nt.test;

import java.lang.reflect.Constructor;

public class DynoObject {

	public static void main(String[] args) {
		
		try {
			Class c = Class.forName(args[0]); //create object Object obj =
			 //Object obj= c.newInstance(); 
			//System.out.println(obj);
			 
			Constructor cons[] = c.getDeclaredConstructors();
			//object usinh Counstructor 
			Object obj = cons[0].newInstance();
			System.out.println("Object-1 is ::"+obj);
			System.out.println("--------------------");
			Object obj2 = cons[1].newInstance(45,30);
			System.out.println("Object-2 is :: "+obj2);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
