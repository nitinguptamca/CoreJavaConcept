package core.java.concept.constructor.c2;

class A {
	A() {
		greeting();
		prints();
	}

	void greeting() {
		System.out.println("instance method from A");
	}

	static void prints() {
		System.out.println("Static method from A");
	}
}

class B extends A {
	B() {
		greeting();
		prints();
	}

	void greeting() {
		System.out.println("instance method from B");
	}

	static void prints() {
		System.out.println("Static method from B");
	}
}


public class ConstructorConcept {
	public static void main(String[] args) {
		new B();
	}
}
