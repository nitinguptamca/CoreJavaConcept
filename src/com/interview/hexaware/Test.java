package com.interview.hexaware;

class BadNumberException extends Exception {
	BadNumberException(String e) {
		System.out.println(e);
	}

	BadNumberException(Throwable e) {
		System.out.println(e.getMessage());
	}

	BadNumberException(Exception e) {
		System.out.println(e.getMessage());
	}
}

public class Test {
	public  double divide(int numberToDivide, int numberToDivideBy) throws BadNumberException {
		if (numberToDivideBy == 0) {
			throw new BadNumberException("Cannot divide by 0");
		}
		return numberToDivide / numberToDivideBy;
	}
	
	 public void callDivide() throws BadNumberException{
		 double result = divide(2,1);
	        System.out.println(result);
	    }
	public static void main(String[] args) throws BadNumberException {
		Test test=new Test();
		//test.divide(0, 1);
		test.callDivide();
	}
}