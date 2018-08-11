package com.method.override17;

class A{
	static void method(){
		System.out.println("Class A method");
	}
	
	void methodObj(){
		System.out.println("Class A methodObj");
	}
}
class B extends A{
	static void method(){
		System.out.println("Class B method");
	}
	void methodObj(){
		System.out.println("Class B methodObj");
	}
}
public class Test{
	public static void main(String args[]){
		A a = new B();
		a.method();
		a.methodObj();
		a=null;
		a.method();
		a.methodObj();
	}
}
