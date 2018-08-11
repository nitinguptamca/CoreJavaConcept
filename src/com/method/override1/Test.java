package com.method.override1;

class Rectangle{
    public int area(int length, int width){
          return  length*width;
    }
}
class Square extends Rectangle{
    public int area(long length, long width){
          return  (int) Math.pow(length, 2);
    }
}
public class Test{
    public static void main(String args[]){
          Square r = new Square();
          System.out.println(r.area(5 , 4));
          System.out.println(r.area(5 , 4));
          System.out.println(r.area(5 , 4l));
          System.out.println(r.area(5l , 4l));
          short s1=8,s2=7;
          System.out.println(r.area(s1 , s2));
    }
}