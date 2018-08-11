package com.journaldev.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcards {
	
	

	int a;
	int b;
	private final int aaa=8;
	
	public GenericsWildcards(int a, int b) {
		super();
		this.a = a;
		this.b = b;

	}

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>();
		ints.add(3); ints.add(5); ints.add(10);
		double sum = sum(ints);
		System.out.println("Sum of ints="+sum);
	}

	public static double sum(List<? extends Integer> list){
		double sum = 0;
		for(Number n : list){
			sum += n.doubleValue();
		}
		return sum;
	}
}