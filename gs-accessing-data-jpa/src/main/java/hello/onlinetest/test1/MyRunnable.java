package hello.onlinetest.test1;

public class MyRunnable implements Runnable {
	public void run() {
		new Thread(new MyRunnable1()).start();

	}
}