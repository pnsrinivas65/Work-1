package hello.dp;

import java.util.Arrays;

public class MaximumSumIncreasingOrder {

	public static void main(String s[]) {

		int input[] = {3, 5, -7, 8, 10};
			//{ 4, 6, 1, 3, 8, 4, 6 };
		int size = input.length;
		int maxValue = 0;
		int[] temp = new int[size];
		
		temp = Arrays.copyOf(input, size);
		
		int indexOf [] = new int[size];
		for (int i = 0; i < size; i++) {
			indexOf[i] = i;
		}
		
		
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (input[j] < input[i]) {
					int tempVal = temp[i];
					
					temp[i] = Math.max(temp[i], (temp[j] + input[i]));
					if(maxValue < temp[i]) {
						maxValue = temp[i];
					}
					if(tempVal != temp[i]) {
						indexOf[i] = j;
					}
					System.out.println(Arrays.toString(temp));
				}
			}
		}
		System.out.println(Arrays.toString(indexOf));
		System.out.println(Arrays.toString(temp)+" <-- maxValue --> "+maxValue);
		
		/*
		 * List<Integer> intArr = Arrays.asList(temp); IntStream.range(0, intArr.size())
		 * .reduce((a,b)->intArr.get(a)<intArr.get(b)? b: a)
		 * .ifPresent(ix->System.out.println("Index "+ix+", value "+intArr.get(ix)));
		 */
	}
}
