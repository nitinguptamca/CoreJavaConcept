package comstream;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int sum = IntStream.of(1, 2, 3, 4, 5).peek(e -> System.out.println("Taking integer: " + e))
				.filter(n -> n % 2 == 1).peek(e -> System.out.println("Filtered integer: " + e)).map(n -> n * n)
				.peek(e -> System.out.println("Mapped integer: " + e)).reduce(0, Integer::sum);
		System.out.println("sum = " + sum);

		System.out.println("*********************************88");
		IntStream.rangeClosed(1, 5).map(n -> n * n).forEach(System.out::println);

		ForkJoinPool forkJoinPool = new ForkJoinPool(1);
		List<Integer> primeList =  forkJoinPool.submit(() -> new Test().collectPrimes(10000000))
				.get();
		System.out.println("primeList = " + primeList);
		forkJoinPool.shutdown();
		long t2 = System.currentTimeMillis();
	}

	private List<Integer> collectPrimes(int max) {
		return IntStream.range(1, max).parallel().filter(this::isPrime).boxed().collect(Collectors.toList());
	}

	private long countPrimes(int max) {
		return IntStream.range(1, max).parallel().filter(this::isPrime).count();
	}

	private boolean isPrime(long n) {
		return n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);
	}
}
