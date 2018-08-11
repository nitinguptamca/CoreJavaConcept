package comstream;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

public class TimedExecution {
	private ExecutorService executorService = Executors.newCachedThreadPool();

	public void timedRun(Runnable runnable, long timeout, TimeUnit unit)
			throws InterruptedException, ExecutionException {
		StampedLock lock= new StampedLock();
		Future<?> task = executorService.submit(runnable);
		try {
			task.get(timeout, unit);
		} catch (TimeoutException e) {
			System.err.println("Timeout occurred.");
		} finally {
			System.out.println("cancel............");
			task.cancel(true);
		}
	}

	public void stop() {
		executorService.shutdown();
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		TimedExecution timedExecution = new TimedExecution();
		timedExecution.timedRun(new Runnable() {
			@Override
			public void run() {
				while (!Thread.interrupted()) {
					System.out.println("Test me..");
				}
			}
		}, 100, TimeUnit.MICROSECONDS);
		timedExecution.stop();
	}
}