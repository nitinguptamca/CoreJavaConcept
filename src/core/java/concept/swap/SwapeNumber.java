package core.java.concept.swap;

import java.util.LinkedList;

public class SwapeNumber {

	public void swap(Integer x, Integer y) {
		Integer tmp = x;
		x = y;
		y = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=10,b=20;
		SwapeNumber swapeNumber=new SwapeNumber();
		swapeNumber.swap(a, b);
		
		System.out.println(a+""+b);
		
		
	}

}
