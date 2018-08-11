package com.method.override1;

class SuperClass
{
    void superClassMethod(Number n)
    {
        System.out.println("From Super Class");
    }
}
 
class SubClass extends SuperClass
{
    void superClassMethod(Double d)
    {
        System.out.println("From Sub Class");
    }
}

class SubClass11 extends SubClass
{
    void superClassMethod(Integer d)
    {
        System.out.println("From Sub Class int");
    }
}
 
public class MainClass 
{    
    public static void main(String[] args)
    {
    	SubClass11 sub = new SubClass11();
         Short ss=12;
        sub.superClassMethod(ss);
    }
}
