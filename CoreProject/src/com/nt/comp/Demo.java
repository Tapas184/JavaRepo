package com.nt.comp;

public class Demo {
	private int a=10,b=20;
	//0 pram constructor
	public Demo() {
		System.out.println("0- Param constructor");
	}
	//2 param constructor
	public Demo(int a,int b) {
		this.a=a;
		this.b=b;
		System.out.println("2 param constructor");
	}
	@Override
	public String toString() {
		return "Demo [a=" + a + ", b=" + b +"]";
	}

}
