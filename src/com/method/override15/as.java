package com.method.override15;


class SuperClass
{
    Object superClassMethod()
    {
    	System.out.println("super");
        return new Object();
    }
}

class subClass extends SuperClass
{
	@Override
    Object superClassMethod()
    {
		System.out.println("sub");
        return new Object();
    }
}

public class as {
	public static void main(String[] args) {
		SuperClass superClass=new subClass();
		superClass.superClassMethod();
	}
}
