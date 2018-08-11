package com.method.overriding;

class X111
{
    void method(int a)
    {
        System.out.println("ONE");
    }
     
    void method(double d)
    {
        System.out.println("TWO");
    }
}
 
class Y extends X111
{
    @Override
    void method(double d)
    {
        System.out.println("THREE");
    }
}
 
public class MainClass111
{    
    public static void main(String[] args)
    {
        new Y().method(100);
        new Y().method(100d);
        
        
    }
}
