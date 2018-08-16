package garbage.collector.concept;

/**
 * 
 * @author nitin There are generally four different ways to make an object
 *         eligible for garbage collection.
 * 
 *         Nullifying the reference variable
 * 
 *         Re-assigning the reference variable
 * 
 *         Object created inside method
 * 
 *         Island of Isolation
 *
 */

class Test {
	/**
	 * Just before destroying an object, Garbage Collector calls finalize() method
	 * on the object to perform cleanup activities. Once finalize() method
	 * completes, Garbage Collector destroys that object. finalize() method is
	 * present in Object class with following prototype. protected void finalize()
	 * throws Throwable
	 */
	private Test x;
	// to store object name
	String obj_name;
	// static int count = 0;

	int count = 0;

	@Override
	public String toString() {
		return "Test [obj_name=" + obj_name + ", count=" + count + ", toString()=" + super.toString() + "]";
	}

	public Test() {
		super();
		System.out.println("object initialize" + count++);
		
	}

	public Test(String obj_name) {
		this.obj_name = obj_name;
		System.out.println(" obj_name " + obj_name + "   " + count++);
	}

	@Override
	// finalize method is called on object once
	// before garbage collecting it
	protected void finalize() throws Throwable {
		count++;
		System.out.println("Garbage collector called");
		System.out.println("Object garbage collected : " + this);
		System.out.println("Count    :" + count);
	}
	/**
	 * Note :
	 * 
	 * The finalize() method called by Garbage Collector not JVM. Although Garbage
	 * Collector is one of the module of JVM.
	 * 
	 * Object class finalize() method has empty implementation, thus it is
	 * recommended to override finalize() method to dispose of system resources or
	 * to perform other cleanup.
	 * 
	 * The finalize() method is never invoked more than once for any given object.
	 * 
	 * If an uncaught exception is thrown by the finalize() method, the exception is
	 * ignored and finalization of that object terminates.
	 */
}

public class GarbageCollectorDemo {
	
	

	static void show() {
		// object t1 inside method becomes unreachable when show() removed
		Test t1 = new Test("t1");
		display();

	}

	static void display() {
		// object t2 inside method becomes unreachable when display() removed
		Test t2 = new Test("t2");
	}

	public static void main1(String[] args) throws InterruptedException {
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		Test t4 = new Test();

		// Nullifying the reference variable
		t1 = null;

		// requesting JVM for running Garbage Collector
		System.gc();

		// Nullifying the reference variable
		t2 = null;

		// requesting JVM for running Garbage Collector
		Runtime.getRuntime().gc();

		// Nullifying the reference variable
		t3 = null;

		// requesting JVM for running Garbage Collector
		System.gc();

		// Nullifying the reference variable
		t4 = null;

		// requesting JVM for running Garbage Collector
		Runtime.getRuntime().gc();

	}

	public static void main2(String[] args) {
		// calling show()
		/**
		 * Object created inside a method : When a method is called it goes inside the
		 * stack frame. When the method is popped from the stack, all its members dies
		 * and if some objects were created inside it then these objects becomes
		 * unreachable or anonymous after method execution and thus becomes eligible for
		 * garbage collection
		 */
		show();
		// calling garbage collector
		System.gc();
	}

	@Override
	public String toString() {
		return "GarbageCollectorDemo [toString()=" + super.toString() + "]";
	}

	public static void main3(String[] args) {
		/**
		 * Reassigning the reference variable: When reference id of one object is
		 * referenced to reference id of some other object then the previous object has
		 * no any longer reference to it and becomes unreachable and thus becomes
		 * eligible for garbage collection.Example:
		 */

		Test t1 = new Test("t1");
		Test t2 = new Test("t2");

		// t1 now referred to t2
		t1 = t2;

		// calling garbage collector
		System.gc();
	}

	public static void main4(String[] args) {
		/**
		 * Nullifying the reference variable : When all the reference variables of an
		 * object are changed to NULL, it becomes unreachable and thus becomes eligible
		 * for garbage collection.Example:
		 */
		Test t1 = new Test("t1");

		/* t1 being used for some purpose in program */

		/*
		 * When there is no more use of t1, make the object referred by t1 eligible for
		 * garbage collection
		 */
		t1 = null;

		Test t2 = new Test("t2");
		Test t23 = new Test("t23");
		Test t24 = new Test("t24");
		Test t25 = new Test("t25");
		Test t26 = new Test("t26");
		t25 = null;
		// calling garbage collector
		System.gc();
	}

	public static void main5(String[] args) {
		/**
		 * Anonymous object : The reference id of an anonymous object is not stored
		 * anywhere. Hence, it becomes unreachable.
		 */
		// anonymous object without reference id
		new Test("t1");

		// calling garbage collector
		System.gc();
	}

	public static void main6(String[] args) throws InterruptedException {
		/**
		 * Output: end of main
		 * 
		 * Explanation : We know that finalize() method is called by Garbage Collector
		 * on an object before destroying it. But here, the trick is that the str is
		 * String class object, not the Test class. Therefore, finalize() method of
		 * String class(if overridden in String class) is called on str. If a class
		 * doesn’t override finalize method, then by default Object class finalize()
		 * method is called.
		 */
		String str = new String("GeeksForGeeks");

		// making str eligible for gc
		str = null;

		// calling garbage collector
		System.gc();

		// waiting for gc to complete
		Thread.sleep(1000);

		System.out.println("end of main");
	}

	public static void main33(String[] args) throws InterruptedException {
		/**
		 * Output:finalize method called end main Explanation :
		 * 
		 * When Garbage Collector calls finalize() method on an object, it ignores all
		 * the exceptions raised in the method and program will terminate normally.
		 */
		Test t = new Test();

		// making t eligible for garbage collection
		t = null;

		// calling garbage collector
		System.gc();

		// waiting for gc to complete
		Thread.sleep(1000);

		System.out.println("end main");
	}

	static Test t;
	static int count = 0;

	public static void main11(String[] args) throws InterruptedException {
		Test t1 = new Test();

		// making t1 eligible for garbage collection
		t1 = null; // line 12

		// calling garbage collector
		System.gc(); // line 15

		// waiting for gc to complete
		Thread.sleep(1000);

		// making t eligible for garbage collection,
		t = null; // line 21

		// calling garbage collector
		System.gc(); // line 24

		// waiting for gc to complete
		Thread.sleep(1000);

		System.out.println("finalize method called " + count + " times");
	}

	public static void main222(String[] args) {
		// How many objects are eligible for
		// garbage collection after this line?
		m1(); // Line 5
		GarbageCollectorDemo garbageCollectorDemo = new GarbageCollectorDemo();
		garbageCollectorDemo.m2();
		System.gc();
	}

	static void m1() {
		Test t1 = new Test("nitin");
		Test t2 = new Test("Gupta");
	}

	void m2() {
		Test t1 = new Test("nitin1");
		Test t2 = new Test("Gupta1");
	}

	public static void main444(String[] args) {
		Test t1 = new Test();
		Test t2 = m1(t1); // line 6
		Test t3 = new Test();
		t2 = t3; // line 8
		System.gc();
		/**
		 * By the time line 8 has executed, the only object without a reference is the
		 * one generated i.e as a result of line 6. Remember that “Java is strictly pass
		 * by value” so the reference variable t1 is not affected by the m1() method. We
		 * can check it using finalize() method. The statement
		 * “System.out.println(this.hashcode())” in finalize() method print the object
		 * hashcode value on which finalize() method is called,and then just compare the
		 * value with other objects hashcode values created in main method.
		 */
	}

	static Test m1(Test temp) {
		temp = new Test();
		return temp;
	}

}
