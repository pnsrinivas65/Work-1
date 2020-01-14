package hello;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsExample2 {

	public static void main(String[] args) {
		// Calculating square root of even numbers from 1 to N
		int min = 1;
		int max = 1000000;

		List<Integer> sourceList = new ArrayList<>();
		for (int i = min; i < max; i++) {
			sourceList.add(i);
		}

		List<Double> result = new LinkedList<>();

		// Collections approach
		long t0 = System.nanoTime();
		long elapsed = 0;
		for (Integer i : sourceList) {
			if (i % 2 == 0) {
				result.add(Math.sqrt(i));
			}
		}
		elapsed = System.nanoTime() - t0;
		System.out.printf("Collections: Elapsed time:\t %d ns \t(%f seconds)%n", 
				elapsed, elapsed / Math.pow(10, 9));

		// Stream approach
		Stream<Integer> stream = sourceList.stream();
		t0 = System.nanoTime();
		result = stream.filter(i -> i % 2 == 0)
				.map(i -> Math.sqrt(i))
				.collect(Collectors.toList());
		elapsed = System.nanoTime() - t0;
		System.out.printf("Streams: Elapsed time:\t\t %d ns \t(%f seconds)%n", 
				elapsed, elapsed / Math.pow(10, 9));

		// Parallel stream approach
		stream = sourceList.stream().parallel();
		
		
		/*
		 * List<String> resultList = configMap.values() .parallelStream()
		 * .filter(Objects::nonNull) .filter(r -> ((Predicate<String>) "0010"::equals)
		 * .or("0111"::equals) // null-save equivalent to "0111".equals(value)
		 * .or("0011"::equals) .test(r.getVisibleTo()) ) .map(Config::getName)
		 * .collect(Collectors.toList());
		 * 
		 * Iterator itr = configMap.entrySet().iterator(); List<String> resultList = new
		 * ArrayList<String>(); while(itr.hasNext()){ Entry e = (Entry)itr.next();
		 * Config rc = (Config)e.getValue();
		 * 
		 * if (rc != null && rc.getVisibleTo() != null &&
		 * (rc.getVisibleTo().equalsIgnoreCase("0010") ||
		 * rc.getVisibleTo().equalsIgnoreCase("0111") ||
		 * rc.getVisibleTo().equalsIgnoreCase("0011"))){ resultList .add(rc.getName());
		 * } }
		 */
	}

}
