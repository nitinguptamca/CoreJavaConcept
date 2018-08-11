package com.method.override32;

public class MainClass 
{    
    static void method(Integer i)
    {
        System.out.println(1);
    }
     
    static void method(Double d)
    {
        System.out.println(2);
    }
       
    static void method(Number n)
    {
        System.out.println(4);
    }
     
    static void method(Object o)
    {
        System.out.println(5);
    }
     
    public static void main(String[] args)
    {
        method((short)12);
        method((byte)12);
        method((float)12);
        method((String)"12");
    }
}