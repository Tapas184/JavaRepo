package com.java.Examples;

//swiping 2 numbers without using third variable
public class SwipTwoNumbers {

	public static void main(String[] args) {
		int a = 0, b = 12,c=0;
		// 1st method

		/*
		 * System.out.println("Before the swap a ::"+a);
		 * System.out.println("Before the swap b::"+b); a=a+b;//a:30 b=a-b;//30-20=b:10
		 * a=a-b;//30-10=a:20 System.out.println("After the swap a::"+a);
		 * System.out.println("After the swap b::"+b);
		 */
		// 2nd method

	if(a==0 || b==0) {
		System.out.println("Kindly provide number which is greater than 0");
	}//if
	else {
		System.out.println("Before the swap a ::" + a);
		System.out.println("Before the swap b::" + b); 
		a = a * b;// a=200 
		b = a /b;// 200/20=b:10 
		a = a / b;// 200/10=a:20
		System.out.println("After the swap a::" + a);
		System.out.println("After the swap b::" + b);
	}//else
		// 3rd Method using 3rd variable

		/*			  System.out.println("Before the swap a ::" + a);
					  System.out.println("Before the swap b::" + b); 
		    c=a;//c=10;
		    a=b;//a=20;
		    b=c;//b=10;
					  System.out.println("After the swap a::" + a);
					 System.out.println("After the swap b::" + b);*/
	}

}
