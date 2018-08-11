package core.java.concept.constructor.c3;

class A {
	void add() {
		System.out.println("Add A");
	}
}

class B extends A {
	void add() {
		System.out.println("Add B");
	}
}

class C extends B {
	void add() {
		System.out.println("Add C" );
		super.add();
	}
}

public class TestConstructor {
	public static void main(String[] args) {
		C foo = new C();
		foo.add();
	}
}
