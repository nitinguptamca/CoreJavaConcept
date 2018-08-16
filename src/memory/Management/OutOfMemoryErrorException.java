package memory.Management;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author nitin Exception in thread "main" java.lang.OutOfMemoryError: Java
 *         heap space
 *
 *         Usually, this error is thrown when the Java Virtual Machine cannot
 *         allocate an object because it is out of memory, and no more memory
 *         could be made available by the garbage collector.
 * 
 *         OutOfMemoryError usually means that you’re doing something wrong,
 *         either holding onto objects too long, or trying to process too much
 *         data at a time. Sometimes, it indicates a problem that’s out of your
 *         control, such as a third-party library that caches strings, or an
 *         application server that doesn’t clean up after deploys. And
 *         sometimes, it has nothing to do with objects on the heap.
 * 
 *         Error 1 – Java heap space : This error arises due to the applications
 *         that make excessive use of finalizers. If a class has a finalize
 *         method, then objects of that type do not have their space reclaimed
 *         at garbage collection time. Instead, after garbage collection, the
 *         objects are queued for finalization, which occurs at a later time.
 *         Implementation: finalizers are executed by a daemon thread that
 *         services the finalization queue.
 * 
 *         If the finalizer thread cannot keep up, with the finalization queue,
 *         then the Java heap could fill up and this type of OutOfMemoryError
 *         exception would be thrown. The problem can also be as simple as a
 *         configuration issue, where the specified heap size (or the default
 *         size, if it is not specified) is insufficient for the application.
 */

public class OutOfMemoryErrorException {

	static List<String> list = new ArrayList<String>();

	/*
	 * public static void main(String args[]) throws Exception { Integer[] array =
	 * new Integer[1000000 * 10000]; System.out.println("Hello"); }
	 */
	/**
	 * 
	 * @param args
	 * @throws Exception
	 *             Error 2 – GC Overhead limit exceeded : This error indicates that
	 *             the garbage collector is running all the time and Java program is
	 *             making very slow progress. After a garbage collection, if the
	 *             Java process is spending more than approximately 98% of its time
	 *             doing garbage collection and if it is recovering less than 2% of
	 *             the heap and has been doing so far the last 5 (compile time
	 *             constant) consecutive garbage collections, then a
	 *             java.lang.OutOfMemoryError is thrown.
	 * 
	 *             This exception is typically thrown because the amount of live
	 *             data barely fits into the Java heap having little free space for
	 *             new allocations.
	 * 
	 */
	/*public static void main(String args[]) throws Exception {
		Map m = new HashMap();
		m = System.getProperties();
		Random r = new Random();
		while (true) {
			m.put(r.nextInt(), "randomValue");
		}
	}*/
	
	
}
