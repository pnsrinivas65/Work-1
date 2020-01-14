package hello.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintNumber {
	
	
	public static void main(String s[]) {
		
		AtomicInteger atint = new AtomicInteger();
		
		int noOfThreads = 2;
		
		final Thread[] workers = new Thread[noOfThreads];
		
		for(int i = 0; i<noOfThreads; i++) {
			workers[i] = new Thread(new PrintingTask(System.out, i+1, 5, noOfThreads));
		}
		
		for (final Thread thread : workers) {
			thread.start();
		}
		
		for (final Thread thread : workers) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
				Thread.currentThread().interrupt();
			}
		}
		
		PrintSequenceRunnable runnable1=new PrintSequenceRunnable(1);
		PrintSequenceRunnable runnable2=new PrintSequenceRunnable(2);
		PrintSequenceRunnable runnable3=new PrintSequenceRunnable(0);
		
		Thread t1=new Thread(runnable1,"T1");
		Thread t2=new Thread(runnable2,"T2");
		Thread t3=new Thread(runnable3,"T3");
		
		t1.start();
		t2.start();
		t3.start();	  
	}

}
