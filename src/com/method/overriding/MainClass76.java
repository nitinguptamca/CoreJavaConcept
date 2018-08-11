package com.method.overriding;

public class MainClass76
{
    double overloadedMethod(double d)
    {
        return d *= d;
    }
     
    int overloadedMethod(int i)
    {
        return overloadedMethod(i *= i);
    }
     
    float overloadedMethod(float f)
    {
        return overloadedMethod(f *= f);
    }
     
    public static void main(String[] args)
    {
    	MainClass76 main = new MainClass76();
         
        System.out.println(main.overloadedMethod(100));
    }
}