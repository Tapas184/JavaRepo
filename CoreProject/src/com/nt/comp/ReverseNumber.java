package com.nt.comp;
//reverse a number
public class ReverseNumber {

	public static void main(String[] args) {
		int number = 1234;
		int reverse=0;
		//1st method
		/*StringBuilder sb=new StringBuilder(String.valueOf(number));//Provided the value of string argument
		
		 reverse=Integer.valueOf(sb.reverse().toString());// reverse the string and convert into integer
		 System.out.println("The reverse number ::"+reverse);*/ // print the value;
        //2nd Method
		 while(number!=0) {
			 int reminder;//local variable
			 reminder=number%10;//1234%10=4
			    reverse=reverse*10+reminder;//(4*10)+0=40
			    number=number/10;//1234/10=123
		 }//while
		 System.out.println("The reverse number is ::"+reverse);
	}

}
