package hello.dp;

import java.util.Arrays;

public class MinNoJumps {

	public static void main(String s[]) {

		int input[] = // {2, 3, 1, 1, 2,4,2, 0,1,1};
				 { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
				//{ 0, 0, 1, 0, 0, 1, 0 };

		MinNoJumps mnj = new MinNoJumps();
		System.out.println(mnj.getMinimumNumberOfJumps(input));
		System.out.println("Min jumps recursive" + mnj.minJumps(input, 0, input.length - 1));
		System.out.println("DP Min number of Jumps" + mnj.getMinJumpsDP(input));
		mnj.minOfCloudJumps(input, input.length);

	}

	// Returns minimum number of
	// jumps to reach arr[h] from arr[l]
	public int minJumps(int input[], int length, int height) {
		// Base case: when source
		// and destination are same
		if (height == length)
			return 0;

		// When nothing is reachable
		// from the given source
		if (input[length] == 0)
			return Integer.MAX_VALUE;

		// Traverse through all the points
		// reachable from arr[l]. Recursively
		// get the minimum number of jumps
		// needed to reach arr[h] from these
		// reachable points.
		int min = Integer.MAX_VALUE;
		for (int i = length + 1; i <= height && i <= length + input[length]; i++) {
			int jumps = minJumps(input, i, height);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
				min = jumps + 1;
		}
		return min;
	}

	public int getMinimumNumberOfJumps(int nums[]) {

		if (nums.length <= 0) {
			return 0;
		}

		int maxReach = nums[0];
		int step = nums[0];
		int jump = 1;

		// Start traversing array
		for (int i = 1; i < nums.length; i++) {
			// Check if we have reached the end of the array
			if (i == nums.length - 1)
				return jump;
			System.out.println("jumps so far --> " + jump);
			// updating maxReach
			maxReach = Math.max(maxReach, i + nums[i]);

			// we use a step to get to the current index
			step--;

			// If no further steps left
			if (step == 0) {
				// we must have used a jump
				jump++;

				// Check if the current index/position or lesser index
				// is the maximum reach point from the previous indexes
				if (i >= maxReach)
					return -1;

				// re-initialize the steps to the amount
				// of steps to reach maxReach from position i.
				step = maxReach - i;
			}
		}
		return jump;
	}

	public int getMinJumpsDP(int nums[]) {

		int temp[] = new int[nums.length];
		int jumpIndex[] = new int[nums.length];

		int loopCounter=1;
		temp[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			temp[i] = Integer.MAX_VALUE - 1;
		}

		for (int i = 1; i < nums.length; i++) {

			for (int j = 0; j < i; j++) {
				// System.out.println("i-->" + i + " <-- j -->" + j);
				
				if (i <= j + nums[j]) {

					if (temp[i] > temp[j] + 1) {
						jumpIndex[i] = j;
						temp[i] = temp[j] + 1;
						loopCounter++;
					}

					// temp[i] = Math.min(temp[i], temp[j] + 1);

				}
			}
		}
		System.out.println("jumpIndex" + Arrays.toString(jumpIndex)+" <-- loopCounter -->"+loopCounter);
		return temp[nums.length - 1];
	}

	public int getMinNumofJumpsLeetCode(int nums[]) {

		if (nums.length == 1) {
			return 0;
		}

		int count = 0;
		int i = 0;

		while (i + nums[i] < nums.length - 1) {
			int maxVal = 0;
			int maxValIndex = 0;
			for (int j = 1; j <= nums[i]; j++) {
				if (nums[j + i] + j > maxVal) {
					maxVal = nums[j + i] + j;
					maxValIndex = i + j;
				}
			}
			i = maxValIndex;
			count++;
		}
		return count + 1;
	}

	public int minOfCloudJumps(int c[], int n) {

		int jumps = 0;

		int i = 0;
		while (i < n - 3) {
			// goes through all clouds up until the last jump
			System.out.println("I-->"+i+"n-->"+n);
			i += (c[i + 2] == 0) ? 2 : 1;
			jumps++;
		}

		jumps++;// This is the last jump that will be either a 1 or 2

		System.out.println("jumps -->" + jumps);
		return jumps;
	}
}
