package com.method.override2123;

class A{
	 A a1=a1 = new A();
   private void printName(){
          System.out.println("Value-A");
          
          a1.display();
    }
   public void display() {
   a1.printName();
   }
}
class B extends A{
    public void printName(){
          System.out.println("Name-B");
    }
}
public class Test{
    public static void main (String[] args){
          B b = new B();
          b.display();
          
         
    }
}
