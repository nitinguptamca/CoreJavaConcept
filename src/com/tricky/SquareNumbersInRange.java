package com.tricky;

//Finding perfect square numbers in a range using Java
import java.io.IOException;

public class SquareNumbersInRange {

 public static void main(String[] args) throws IOException {
     int starting_number = 1;
     int ending_number = 1000;
     System.out.println("Perfect Numbers between "+starting_number+ " and "+ending_number);
     for (int i = starting_number; i <= ending_number; i++) {

         int number = i;

         int sqrt = (int) Math.sqrt(number);
         if (sqrt * sqrt == number) {
             System.out.println(number+ " = "+sqrt+"*"+sqrt);
         } 
     }
 }
}
