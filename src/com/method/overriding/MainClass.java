package com.method.overriding;

class A
{
     
}
 
class B extends A
{
     
}
 
class C extends B
{
     
}

class D extends A{
	
}
 
public class MainClass 
{
    static void overloadedMethod(A a)
    {
        System.out.println("ONE");
    }
     
    static void overloadedMethod(B b)
    {
        System.out.println("TWO");
    }
    
   /* static void overloadedMethod(C c)
    {
        System.out.println("C");
    }*/
    
    static void overloadedMethod(D d)
    {
        System.out.println("D");
    }
     
    static void overloadedMethod(Object obj)
    {
        System.out.println("THREE");
    }
     
    public static void main(String[] args)
    {
        C c = new C();
         
        overloadedMethod(c);
        
        A a=new C();
        overloadedMethod(a);
        
        A b=new B();
        overloadedMethod(b);
        
        Object a11=(Object)new C();
        overloadedMethod(a11);
        
        
    }
}