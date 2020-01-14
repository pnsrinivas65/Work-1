package hello.threads;

import java.util.Queue;

public class Consumer extends Thread {

	private Queue<Integer> resource;
	private int maxSize;

	public Consumer(Queue<Integer> resource, int maxSize, String queueName) {

		super(queueName);
		this.resource = resource;
		this.maxSize = maxSize;

	}

	public void run() {

		while (true) {

			synchronized (resource) {
				System.out.println("Consumer sycn");

				while (resource.isEmpty()) {

					System.out.println("Queue is empty," + "Consumer thread is waiting"
							+ " for producer thread to put something in queue");
					try {
						resource.wait();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				
				System.out.println("Consumer"+ resource.remove());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
				resource.notifyAll();
			}

		}

	}

}
