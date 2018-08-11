package com.method.overriding;

class X1
{
    void calculate(int a, int b)
    {
        System.out.println("Class X");
    }
}
 
class Y1 extends X1
{
    @Override
    void calculate(int a, int b)
    {
        System.out.println("Class Y");
    }
}
 
class Z1 extends Y1
{
    @Override
    void calculate(int a, int b) 
    {
        System.out.println("Class Z");
    }
}
 
public class MainClass88 
{    
    public static void main(String[] args)
    {
        X1 x = new Y1();
         
        x.calculate(10, 20);
         
        Y1 y = (Y1) x;
         
        y.calculate(50, 100);
         
        Z1 z = (Z1) y;
         
        z.calculate(100, 200);
    }
}
