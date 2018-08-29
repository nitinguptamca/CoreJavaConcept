package concerrent.Hash.map.Concept;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap is non-Synchronized in nature i.e. HashMap is not Thread-safe whereas
 * ConcurrentHashMap is Thread-safe in nature.
 *
 * HashMap performance is relatively high because it is non-synchronized in
 * nature and any number of threads can perform simultaneously. But
 * ConcurrentHashMap performance is low sometimes because sometimes Threads are
 * required to wait on ConcurrentHashMap.
 * 
 * While one thread is Iterating the HashMap object, if other thread try to
 * add/modify the contents of Object then we will get Run-time exception saying
 * ConcurrentModificationException.Whereas In ConcurrentHashMap we wont get any
 * exception while performing any modification at the time of Iteration.
 * 
 * In HashMap, null values are allowed for key and values, whereas in
 * ConcurrentHashMap null value is not allowed for key and value, otherwise we
 * will get Run-time exception saying NullPointerException.
 */

public class HashMapDemo extends Thread {
	/* static HashMap<Integer, String> l = new HashMap<Integer, String>(); */

	static ConcurrentHashMap<Integer, String> l = new ConcurrentHashMap<Integer, String>();

	public void run() {
		// Child thread trying to add
		// new element in the object
		l.put(103, "D");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Child Thread going to add element");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		/*l.put(100, "A");
		l.put(101, "B");
		l.put(102, "C");
		HashMapDemo t = new HashMapDemo();
		t.start();
		for (Object o : l.entrySet()) {
			Object s = o;
			System.out.println(s);
			Thread.sleep(1000);
		}
		System.out.println(l);*/
		
		
		/* HashMap m=new HashMap();
	        m.put(100,"Hello");
	        m.put(101,"Geeks");
	        m.put(102,"Geeks");
	        m.put(null,"Wo44rld");
	        m.put(null,"W22orlddd");
	        m.put(null,"Worlddd");
	        m.put(null,"Wo22rld");
	        System.out.println(m);*/
	        
	        
	        ConcurrentHashMap m=new ConcurrentHashMap();
	        m.put(100,"Hello");
	        m.put(101,"Geeks");
	        m.put(102,"Geeks");
	        m.put(null,"World");
	        System.out.println(m);
		
		
	}
}