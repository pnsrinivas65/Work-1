package hello.onlinetest.test1;

class s1 extends Thread {

	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("A");
			System.out.println("B");
		}
	}
}

public class Test120 extends Thread {

	//private synchronized int e;

	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("C");
			System.out.println("D");
		}
	}

	public static void main(String args[]) {
		s1 t1 = new s1();
		Test120 t2 = new Test120();
		t1.start();
		t2.start();

		double d = Math.round(2.5 + Math.random());

		System.out.println("d -->" + d);

	}
}