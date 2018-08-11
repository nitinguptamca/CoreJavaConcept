package core.java.concept.constructor.c1;


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

 public class B extends A {
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
	
	public static void main(String[] args) {
		new B();
	}
}
