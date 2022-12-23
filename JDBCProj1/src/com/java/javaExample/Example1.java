package com.java.javaExample;

public class Example1 {

	public static void main(String[] args) {
// create a new buffer obj(becoz we can perform multiple operation which we can't do on string)
		StringBuffer  str = new StringBuffer("Tapas Rout");
		int len = str.length(); //Find the length of the string
		/*for(int i=0;i<len;i++) { //iterate over sting
			Character c =str.charAt(i);//Assign character to c
			if(Character.isLowerCase(c)) { // check the character at i is lower or upper
				str.setCharAt(i, Character.toUpperCase(c)); // set character at i if character at i is lower then that will set upper
			}
			else {
				str.setCharAt(i, Character.toLowerCase(c));// set character at i if character at i is Upper then that will set lower
			}
		}
		System.out.println(str);*/
		//by aschi key value
		for(int i =0;i<len;i++) {
			Character c = str.charAt(i);
			if(Character.isLowerCase(c)) {
				char toUpperCase = (char)(c-32);
				str.setCharAt(i, toUpperCase);
			}//if
			else {
				char toLowerCase = (char)(c+32);
				str.setCharAt(i, toLowerCase);
			}//else
		}//for
		System.out.println(str);
       
		
	}

}
