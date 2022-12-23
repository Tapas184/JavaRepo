package com.java.Examples;
//write a java program to count the total number of characters in a string, space(''),comma(,) should not be 
//counted as a character
public class CountString {

	public static void main(String[] args) {
		String str= "abc, tye, tyue"; // define a string
		int count=0; //initialization the count value
		//loop for traverse till the length of the string
		for(int i=0; i<str.length(); i++) {
			//logic for check the char at index is character or not
			if(str.charAt(i)==' '|| str.charAt(i)==',') {
			continue;//continue next
			}
			count++;
		}
		System.out.println("The character count is ::" +count);

	}

}
