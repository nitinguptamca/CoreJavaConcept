package threadLocal;

/**
 * 
 * @author nitin Java.lang.ThreadLocal class in Java This class provides thread
 *         local variable. These variables differ from their normal counterparts
 *         in that each thread that accesses one (via its get or set method) has
 *         its own, independently initialized copy of the variable.
 * 
 *         Basically it is an another way to achieve thread safety apart from
 *         writing immutable classes. Since Object is no more shared there is no
 *         requirement of Synchronization which can improve scalability and
 *         performance of application. It extends class Object. ThreadLocal
 *         provides thread restriction which is extension of local variable.
 *         ThreadLocal are visible only in single thread. No two thread can see
 *         each others thread local variable. These variable are generally
 *         private static field in classes and maintain its state inside thread.
 *
 */
public class ThreadLocalDemo {

	public static void main(String[] args) {

		ThreadLocal<Number> gfg_local = new ThreadLocal<Number>();

		ThreadLocal<String> gfg = new ThreadLocal<String>();
		// setting the value
		gfg_local.set(100);

		// returns the current thread's value
		System.out.println("value = " + gfg_local.get());

		// setting the value
		gfg_local.set(90);

		// returns the current thread's value of
		System.out.println("value = " + gfg_local.get());

		// setting the value
		gfg_local.set(88.45);

		// returns the current thread's value of
		System.out.println("value = " + gfg_local.get());

		// setting the value
		gfg.set("GeeksforGeeks");

		// returns the current thread's value of
		System.out.println("value = " + gfg.get());
	}

}
