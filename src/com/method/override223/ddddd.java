package com.method.override223;

class A{
    public void printName(){
          System.out.println("Value-A");
    }
}
class B extends A{
	@Override
    public void printName(){
          System.out.println("Name-B");
    }
}
class C extends A{
	@Override
    public void printName(){
          System.out.println("Name-C");
    }
}

 public class ddddd{
       public static void main (String[] args){
             B b = new B();
             C c = new C();
            newPrint(b);
             newPrint(c);
       }
      public static void newPrint(A a){
            a.printName();
      }
 }