package hello.threads;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	public static void main(String s[]) {

		int maxSize = 1;
		Queue<Integer> sharedResource = new LinkedList<Integer>();
		Producer prod = new Producer(sharedResource, maxSize, "Producer");
		Consumer cons = new Consumer(sharedResource, maxSize, "Consumer");

		prod.start();
		cons.start();

	}

}
