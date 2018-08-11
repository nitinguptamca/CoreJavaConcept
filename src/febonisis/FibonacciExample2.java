package febonisis;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.IntStream;

import org.omg.CORBA.portable.Streamable;

public class FibonacciExample2 {
	static int n1 = 0, n2 = 1, n3 = 0;
	
	Set<String>  strl=new HashSet<>();
	

	static void printFibonacci(int count) {
		if (count > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			printFibonacci(count - 1);
		}
	}

	public static void main12(String args[]) {
		int count = 10;
		System.out.print(n1 + " " + n2);// printing 0 and 1
		printFibonacci(count - 2);// n-2 because 2 numbers are already printed
		
	}
	
	public static void main(String[] args) {
		Fibonacci2 fibonacci2 = new Fibonacci2();
		IntStream.range(0,8).forEach(value -> System.out.print(fibonacci2.fib(value) +"  "));
	}
}

class Fibonacci2 {
	private ConcurrentMap<Integer, Long> cache = new ConcurrentHashMap<>(10);

	public Fibonacci2() {
		cache.put(0, 0L);
		cache.put(1, 1L);
	}

	public long fib(int n) {
		return cache.computeIfAbsent(n, x -> Math.addExact(fib(x - 1), fib(x - 2)));
		// Math.addExact throws ArithmeticException - if the result overflows a long
	}

	
}
