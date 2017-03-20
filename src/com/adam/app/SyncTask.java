package com.adam.app;

public class SyncTask implements Runnable {

	private Object mObject1;
	private Object mObject2;
	
	public SyncTask(Object obj1, Object obj2) {
		
		this.mObject1 = obj1;
		this.mObject2 = obj2;
	}
	
	@Override
	public void run() {
		
		// Get the current thread name
		String name = Thread.currentThread().getName();
		
		System.out.println("[" + name + "]: " + "aquire lock on " + this.mObject1.toString());
		// Lock first object
		synchronized(this.mObject1) {
			System.out.println("[" + name + "]: " + "locked on " + this.mObject1.toString());
			doLongTask();
			System.out.println("[" + name + "]: " + "aquire lock on " + this.mObject2.toString());
			//Lock second object
			synchronized (this.mObject2) {
				System.out.println("[" + name + "]: " + "locked on " + this.mObject2.toString());
				doLongTask();
			}
			System.out.println("[" + name + "]: " + "release lock on " + this.mObject2.toString());
		}
// Dead lock solution		
//		System.out.println("[" + name + "]: " + "aquire lock on " + this.mObject2.toString());
//		//Lock second object
//		synchronized (this.mObject2) {
//			System.out.println("[" + name + "]: " + "locked on " + this.mObject2.toString());
//			doLongTask();
//		}
//		System.out.println("[" + name + "]: " + "release lock on " + this.mObject2.toString());
//		
		System.out.println("[" + name + "]: " + "release lock on " + this.mObject1.toString());
		System.out.println("Finish...");
	}
	
	/**
	 * 
	 * To do the long work
	 *
	 */
	private void doLongTask() {
		
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

/*
 * ===========================================================================
 * 
 * Revision history
 * 
 * ===========================================================================
 */
