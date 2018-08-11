package com.method.override1;

public class hh{
    public static void printValue(int i, int j, int k){
          System.out.println("int");
    }

    public static void printValue(byte...b){
          System.out.println("long");
    }

    public static void main(String... args){
          byte b = 9;
          byte[] sssarr= {9,9,9,9};
          printValue(b,b,b);
          printValue(sssarr);
          
          
    }
}
