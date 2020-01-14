package hello.threads;

import java.util.Queue;

public class Producer extends Thread {
	private Queue<Integer> resource;
	private int maxSize;
	private int counter;

	public Producer(Queue<Integer> resource, int maxSize, String queueName) {
		super(queueName);
		this.resource = resource;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {

		while (true) {

			synchronized (resource) {
				System.out.println("Producer sycn");

				while (resource.size() == maxSize) {
					try {

						System.out.println("Queue is full, " + "Producer thread waiting for "
								+ "consumer to take something from queue");

						resource.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("Producer"+ counter);
				resource.add(counter);
				counter++;
				
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
