package com.method.overriding;

public class X
{
	int method (short i ,short b) {
		return i+b;
	}
    int method(int i, int d)
    {
        return i+d;
    }
     
    static int method(int i, double d)
    {
        return (int)(i+d);
    }
     
    double method(double i, int d)
    {
        return i+d;
    }
     
    static double method(double i, double d)
    {
        return i+d;
    }
    
    public static void main(String[] args) {
		X x=new X();
		System.out.println(x.method(2, 3));
		short shortNum = 50;
		short shortNum2 = 50;
		System.out.println(x.method(shortNum, shortNum2));
	}
    
}