package threadLocal;

/**
 * 
 * @author nitin Java.lang.ThreadGroup class in Java ThreadGroup creates a group
 *         of threads. It offers a convenient way to manage groups of threads as
 *         a unit. This is particularly valuable in situation in which you want
 *         to suspend and resume a number of related threads.
 * 
 *         The thread group form a tree in which every thread group except the
 *         initial thread group has a parent. A thread is allowed to access
 *         information about its own thread group but not to access information
 *         about its thread group’s parent thread group or any other thread
 *         group. Constructors: public ThreadGroup(String name): Constructs a
 *         new thread group. The parent of this new group is the thread group of
 *         the currently running thread. Throws: SecurityException - if the
 *         current thread cannot create a thread in the specified thread group.
 *         public ThreadGroup(ThreadGroup parent, String name): Creates a new
 *         thread group. The parent of this new group is the specified thread
 *         group. Throws: NullPointerException - if the thread group argument is
 *         null. SecurityException - if the current thread cannot create a
 *         thread in the specified thread group.
 */

class NewThread extends Thread {
	NewThread(String threadname, ThreadGroup tgob) {
		super(tgob, threadname);
		start();
	}

	public void run() {

		for (int i = 0; i < 100; i++) {
			try {
				System.out.println("thread name"+Thread.currentThread());
				Thread.sleep(10);
			} catch (InterruptedException ex) {
				System.out.println("Exception encounterted");
			}
		}
	}
}

public class ThreadGroupDemo {
	public static void main(String arg[]) {
		// creating the thread group
		ThreadGroup gfg = new ThreadGroup("parent thread group");

		NewThread t1 = new NewThread("one", gfg);
		System.out.println("Starting one");
		NewThread t2 = new NewThread("two", gfg);
		System.out.println("Starting two");

		// checking the number of active thread
		System.out.println("number of active thread: " + gfg.activeCount());
	}
}