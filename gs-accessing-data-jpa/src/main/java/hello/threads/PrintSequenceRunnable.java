package hello.threads;

public class PrintSequenceRunnable implements Runnable {

	int threadNumber;
	static int printNumber = 1;
	public int PRINT_NUMBERS_UPTO = 10;
	static Object lock = new Object();

	public PrintSequenceRunnable(int threadNumber) {
		this.threadNumber = threadNumber;
	}

	@Override
	public void run() {

		while (printNumber < 100) {
			synchronized (lock) {

				while (printNumber % 3 != threadNumber) { // wait for numbers other than remainder
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
				}

				System.out.println(Thread.currentThread().getName() + " " + printNumber);
				printNumber++;
				lock.notifyAll();

			}
		}
	}
}
