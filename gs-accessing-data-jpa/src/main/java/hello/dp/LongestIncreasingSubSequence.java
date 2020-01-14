package hello.dp;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

	public static void main(String s[]) {

		LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
		int numbers[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		// {2,6,3,4,1,2,9,5,8};
		// { 10, 22, 9, 33, 21, 50, 41, 0 };
		int maxLength = lis.longestSubSequence(numbers);
		System.out.println("maxLength -->" + maxLength);
		
		lis.findSubsequence(numbers);

	}

	public void findSubsequence(int[] arrA) {
		
		// temporary array
		int[] LIS = new int[arrA.length];
		
		for (int i = 0; i < arrA.length; i++) {
			
			int max = -1;
			for (int j = 0; j < i; j++) {
				
				// check if previous elements > current element
				if (arrA[i] > arrA[j]) {
					
					// update the max from the previous entries
					if (max == -1 || max < LIS[j] + 1) {
						
						max = 1 + LIS[j];
					}
				}
			}
			if (max == -1) {
				// means none of the previous element has smaller than arrA[i]
				max = 1;
			}
			LIS[i] = max;
		}
		
		// find the max in the LIS[]
		int result = -1;
		int index = -1;
		for (int i = 0; i < LIS.length; i++) {
			
			if (result < LIS[i]) {
				
				result = LIS[i];
				index = i;
			}
		}
		
		// Print the result
		// Start moving backwards from the end and
		String path = arrA[index] + " ";
		int res = result - 1;
		for (int i = index - 1; i >= 0; i--) {
			
			if (LIS[i] == res) {
				
				path = arrA[i] + " " + path;
				res--;
			}
		}
		System.out.println("Longest Increasing subsequence: " + result);
		System.out.println("Actual Elements: " + path);
	}

	public int longestSubSequence(int nums[]) {

		/**
		 * 
		 * if arr[j]<arr[i] { T[i]=max(T[i], (T[j]+1)) }
		 */

		int n = nums.length;
		int temp[] = new int[n];
		int i, j, max = 0;

		int loops = 0;
		/*
		 * Initialize LIS values for all indexes minimum length least is 1
		 */
		for (i = 0; i < n; i++) {

			temp[i] = 1;
		}

		/* Compute optimized LIS values in bottom up manner */
		for (i = 1; i < n; i++) {
			loops++;
			for (j = 0; j < i; j++) {

				if (nums[i] > nums[j]  && temp[i] < temp[j] + 1 ) {

					temp[i] = temp[j] + 1;//Math.max(temp[i], (temp[j] + 1));
				}
			}
			System.out.println("lis -->" + Arrays.toString(temp)+"loops -->"+loops);
		}

		/* Pick maximum of all LIS values */
		for (i = 0; i < n; i++) {

			if (max < temp[i]) {

				max = temp[i];
			}
		}

		return max;
	}
}
