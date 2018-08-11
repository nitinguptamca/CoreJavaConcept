package com;

public class Singleton {

	private volatile static Singleton _instance;

	/**
	 * On surface this method looks perfect, as you only need to pay price for
	 * synchronized block one time, but it still broken, until you make _instance
	 * variable volatile. Without volatile modifier it's possible for another thread
	 * in Java to see half initialized state of _instance variable, but with
	 * volatile variable guaranteeing happens-before relationship, all the write
	 * will happen on volatile _instance before any read of _instance variable.
	 */

	private Singleton() {
	}

	public static Singleton getInstanceDC() {
		if (_instance == null) {//{1}//It may possible two thread come same time inside check block.
			// Single check Thread object level
			synchronized (Singleton.class) {
				if (_instance == null) {// double check class level
					_instance = new Singleton();
				}
			}
		}
		return _instance;
	}
	/**
	 * Thread 1 calls the getInstance() method and determines that instance is null at //1.
	Thread 1 enters the if block, but is preempted by thread 2 before executing the line at //2.
	Thread 2 calls the getInstance() method and determines that instance is null at //1.
	Thread 2 enters the if block and creates a new Singleton object and assigns the variable instance to this new object at //2.
	Thread 2 returns the Singleton object reference at //3.
	Thread 2 is preempted by thread 1.
	Thread 1 starts where it left off and executes line //2 which results in another Singleton object being created.
	Thread 1 returns this object at //3.
	 */

}
