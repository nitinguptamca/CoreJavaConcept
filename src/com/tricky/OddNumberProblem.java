package com.tricky;

public class OddNumberProblem {
	private int[] array = { 1, 1, 2, 3, 4, 5, 2, 3, 4 };

	public int findSingleOdd() {
		int result = 0;
		for (int i : array) {
			result = result ^ i;
		}
		return result;
	}
	
	static int isPowerOfTwo (int x)
	{
	return (x & (x - 1));
	}

	public static void main(String[] args) {
		OddNumberProblem test = new OddNumberProblem();
		int singleOdd = test.findSingleOdd();
		System.out.println("singleOdd = " + singleOdd);
		System.out.println(isPowerOfTwo(128));
	}
}