package com.thread.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

interface DeadlockHandler {
	void handleDeadlock(final ThreadInfo[] deadlockedThreads);
}

class DeadlockDetector {

	private final DeadlockHandler deadlockHandler;
	private final long period;
	private final TimeUnit unit;
	private final ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	final Runnable deadlockCheck = new Runnable() {
		@Override
		public void run() {
			long[] deadlockedThreadIds = DeadlockDetector.this.mbean.findDeadlockedThreads();

			if (deadlockedThreadIds != null) {
				ThreadInfo[] threadInfos = DeadlockDetector.this.mbean.getThreadInfo(deadlockedThreadIds);

				DeadlockDetector.this.deadlockHandler.handleDeadlock(threadInfos);
			}
		}
	};

	public DeadlockDetector(final DeadlockHandler deadlockHandler, final long period, final TimeUnit unit) {
		this.deadlockHandler = deadlockHandler;
		this.period = period;
		this.unit = unit;
	}

	public void start() {
		this.scheduler.scheduleAtFixedRate(this.deadlockCheck, this.period, this.period, this.unit);
	}
}

class DeadlockConsoleHandler implements DeadlockHandler {

	@Override
	public void handleDeadlock(final ThreadInfo[] deadlockedThreads) {
		if (deadlockedThreads != null) {
			System.err.println("Deadlock detected!");

			Map<Thread, StackTraceElement[]> stackTraceMap = Thread.getAllStackTraces();
			for (ThreadInfo threadInfo : deadlockedThreads) {

				if (threadInfo != null) {

					for (Thread thread : Thread.getAllStackTraces().keySet()) {

						if (thread.getId() == threadInfo.getThreadId()) {
							System.err.println(threadInfo.toString().trim());

							for (StackTraceElement ste : thread.getStackTrace()) {
								System.err.println("\t" + ste.toString().trim());
							}
						}
					}
				}
			}
		}
	}
}

public class a {
	
	private void detectDeadlocks() {
		System.err.println("Checking for deadlocks.");
	    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

	    long[] threadIds = threadMXBean.findDeadlockedThreads();

	    if (threadIds == null || threadIds.length == 0) {
	    	System.err.println("No deadlocks found.");
	    } else {
	        StringBuilder sb = new StringBuilder();

	        for (long threadId : threadIds) {
	            ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadId);

	            if (sb.length() > 0) {
	                sb.append(", ");
	            }

	            sb.append(threadInfo.getThreadName()).append(" (ID: ").append(threadId).append(')');
	        }

	        System.err.println("Blocked Threads: " + sb);
	        // Raise alert here, etc.
	    }
	}
	public static void main(String[] args) {
		DeadlockDetector deadlockDetector = new DeadlockDetector(new DeadlockConsoleHandler(), 5, TimeUnit.SECONDS);
		deadlockDetector.start();

		final Object lock1 = new Object();
		final Object lock2 = new Object();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock1) {
					System.out.println("Thread1 acquired lock1");
					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException ignore) {
					}
					synchronized (lock2) {
						System.out.println("Thread1 acquired lock2");
					}
				}
			}

		});
		thread1.start();

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock2) {
					System.out.println("Thread2 acquired lock2");
					synchronized (lock1) {
						System.out.println("Thread2 acquired lock1");
					}
				}
			}
		});
		thread2.start();
	}
}
