package com.method.override17;

class Base {
	int value = 0;

	Base() {
		System.out.println(value);
		addValue();
		printValue();
		printValue11();
	}

	void printValue() {
		System.out.println(value);
		value += 100;

	}

	void printValue11() {
		System.out.println(value);
		value += 160;

	}

	void addValue() {
		System.out.println(value);
		value += 10;
	}

	int getValue() {
		System.out.println(value);
		return value;
	}
}

class Derived extends Base {
	Derived() {
		System.out.println(value);
		addValue();
		printValue();
	}

	@Override
	void addValue() {
		System.out.println(value);
		value += 20;
	}

	@Override
	void printValue() {
		System.out.println(value);
		value += 200;

	}

}

public class aaa {
	public static void main(String[] args) {
		Base b = new Derived();
		System.out.println(b.getValue());
	}
}
