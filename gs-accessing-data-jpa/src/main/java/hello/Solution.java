package hello;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		// strings.add("Hello, World!");
		// strings.add("Welcome to CoderPad.");
		// strings.add("This pad is running Java " + Runtime.version().feature());

		int input[][] = { { 1, 1, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 1 }, 
				{ 1, 0, 0, 1, 1 }, 
				{ 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };

//Problem Statement --> 
//Find out Uniquie Ones
//Adjacent 1's to be counted as 1
//Zeros' can be ignored
//If row has full zero we can skip that row

//definition of array is input[][] = a and b;
		int onesCount = 0;
// define one array where flag them not to come back
		
		
// 
		for (int i = 0; i < input.length; i++) {

			for (int j = 0; j < i; j++) {

				if ((input[i][j] == 1 || input[i][j + 1] == 1) || (input[i + 1][j] == 1 || input[i + 1][j + 1] == 1)) {
					onesCount++;

				} /*
					 * else if() { //skip that row } else { // Skip that zero row }
					 */

			}
		}
		System.out.println("Count of Ones -->" + onesCount);
		
		double[][] array= {
				{1, 5},
				{13, 1.55},
				{12, 100.6},
				{12.1, .85}, {1,5} };


		Arrays.sort(array, (a, b) -> Double.compare(a[0], b[0]));
		System.out.println(Arrays.deepToString(array));

	}
}