package hello.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	/**
	 * Given an array nums of n integers, are there elements a, b, c in nums such
	 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Note:
	 * 
	 * The solution set must not contain duplicate triplets.
	 * 
	 * Given array nums = [-1, 0, 1, 2, -1, -4],
	 * 
	 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
	 */
	
	public static void main(String s[]) {
		int nums[] = {-1, 0, 1, 2, -1, -4};
		int sum = 0;
		//for (int k = 0; k < input.length; k++) {
			//for (int i = k; i < input.length - 2; i++) {
				//System.out.println(i);
				//int zero = input[i] + input[i + 1] + input[i + 2];
				//if (zero == 0)
					//System.out.println(zero);
			//}
		//}
		
		// sort the array
		// iterate over for loop, define two pointers low, high
		// while(high < low) 
		// iterate over elements using low++ and high--
		Arrays.sort(nums);
		/**
		for(int i = 0; i < input.length; i++) {
			
			int low = i;
			int high = input.length-1;
			
			if (i > 0 && input[i] == input[i - 1]) {
	            continue;
	        }
			
			int k = sum - input[i];
			// increment low index if total is less than the remaining sum
			if (input[low] + input[high] < k) {
				low++;
			}

			// decrement high index is total is more than the remaining sum
			else if (input[low] + input[high] > k) {
				high--;
			}

			// triplet with given sum found
			else {
				// print the triplet
				System.out.println("(" + input[i] + " " + input[low] + " " + input[high] + ")");

				// increment low index and decrement high index
				low++;
				high--;
			}
			
		}*/
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
	        int j = i + 1;
	        int k = nums.length - 1;
	 
	        if (i > 0 && nums[i] == nums[i - 1]) {
	            continue;
	        }
	 
	        while (j < k) {
	            if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
	                k--;
	                continue;
	            }
	 
	            if (nums[i] + nums[j] + nums[k] > 0) {
	                k--;
	            } else if (nums[i] + nums[j] + nums[k] < 0) {
	                j++;
	            } else {
	                List<Integer> l = new ArrayList<>();
	                l.add(nums[i]);
	                l.add(nums[j]);
	                l.add(nums[k]);
	                result.add(l);
	                j++;
	                k--;
	            }
	        }
	    }
		//System.out.println(result);
	}
}
