package com.method.override2;

class A31{
    int i = 10;
    public void printValue(){
          System.out.print("Value-A");
    }
}

class B extends A31{
    int i = 12;
    public void printValue(){
          System.out.print("Value-B");
    }
}

public class Test{
    public static void main(String args[]){
          A31 a = new B();
          a.printValue();
          System.out.print(a.i);
    }
}
