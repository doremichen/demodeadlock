/**
 * This is demo dead lock pattern
 */
package com.adam.app;

public class TestDeadLock {

	public static void main(String[] args) throws InterruptedException {
		
		// Prepare the lock
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		
		Thread t1 = new Thread(new SyncTask(obj1, obj2), "t1");
		Thread t2 = new Thread(new SyncTask(obj2, obj3), "t2");
		Thread t3 = new Thread(new SyncTask(obj3, obj1), "t3");
		
		t1.start();
		Thread.sleep(500L);
		
		t2.start();
		Thread.sleep(500L);
		
		t3.start();

	}

}
