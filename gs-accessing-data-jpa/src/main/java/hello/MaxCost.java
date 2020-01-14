package hello;

import java.util.Arrays;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class MaxCost<T> {
	public Queue queue;
	static int noOfLoops;
	Optional<T> option;

	int max_cost(int wine[], int cost, int counter, int i, int j) {
		noOfLoops++;
		// Here `counter` keeps track of the number of years
		// `i` is the left indices of the shelf
		// `j` is the right indices of the shelf
		// `cost` is the maximum cost that we have to find

		if (i > j)
			return cost;
		else if (i == j) {
			cost += counter * wine[i];
			return cost;
		} else {
			int cost1 = counter * wine[i] + max_cost(wine, 0, counter + 1, i + 1, j);
			int cost2 = counter * wine[j] + max_cost(wine, 0, counter + 1, i, j - 1);
			cost += Math.max(cost1, cost2);
			return cost;
		}
	}
	
	public static void main(String s[]) {
		
		MaxCost mc = new MaxCost();
		String winearray [] = {"1", "3", "1", "5", "2","1"};
		int[] array = Arrays.asList(winearray).stream().mapToInt(Integer::parseInt).toArray();
		System.out.println("Cost -->"+mc.max_cost(array, 0, 1, 0, (array.length-1)));
		
		System.out.println("noOfLoops -->"+noOfLoops);
		
		Predicate<String> predicate = str->{return str.equals("Hello");};
		
		Predicate<String> predicateAnd=predicate.and(str->str.length()>4);
		System.out.println(predicateAnd.test("Hello"));
		
		
	}

}
