package com.method.override323;

public class Test{
    public double  display(int x, double y){
            return x*y;
    } 
    public double display(double p, double q){
            return (p+q);
    }
    public static void main(String args[]){
            Test test = new Test();
          System.out.println(  test.display(4, 5.0));
            System.out.println(test.display(4.0, 5.0));
    }
}