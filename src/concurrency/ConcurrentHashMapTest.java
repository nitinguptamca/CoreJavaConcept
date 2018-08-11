package concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	public static void main(String[] args) {
		ConcurrentHashMap<String, String>  concurrentHashMap=new ConcurrentHashMap<>();
		//concurrentHashMap.put(null, null);
		concurrentHashMap.put("nitin","nitin");
		//concurrentHashMap.put(null, "nitin");
		//concurrentHashMap.put( "nitin",null);
		concurrentHashMap.forEach((k,v) -> System.out.println( k+","+ v));
		
	}
}
