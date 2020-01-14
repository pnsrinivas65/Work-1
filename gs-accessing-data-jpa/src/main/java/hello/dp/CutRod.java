package hello.dp;

import java.util.Arrays;

class CutRod
{
	// Function to find best way to cut a rod of length n
	// where rod of length i has a cost price[i-1]
	public static int rodCut(int[] price, int n)
	{
		// base case
		if (n == 0) {
			return 0;
		}

		int maxValue = Integer.MIN_VALUE;

		// one by one partition the given rod of length n into
		//  two parts of length (1, n-1), (2, n-2), (3, n-3), ....
		// (n-1 , 1), (n, 0) and take maximum
		for (int i = 1; i <= n; i++)
		{
			// rod of length i has a cost price[i-1]
			int cost = price[i - 1] + rodCut(price, n - i);

			if (cost > maxValue) {
				maxValue = cost;
			}
		}

		return maxValue;
	}
	
	
	public int rodCutting(int n, int value[]) {
		int i, j;

		// we will calculate the maximum attainable value of rod in a bottom up fashion
		// by first calculating for smaller value of n and then using these values to
		// calculate higher values of n

		// create an array to store the results
		int result[] = new int[n + 1];

		// result[i]=maximum attainable value of rod of size i

		// initialization
		result[0] = 0;

		// in every iteration, find the result for rod of size i
		for (i = 1; i <= n; i++) {
			result[i] = Integer.MIN_VALUE;

			// try to cut the rod of length i into various values of j and select the one
			// which gives the maximum value
			for (j = 0; j < i; j++) {
				result[i] = Math.max(result[i], value[j] + result[i - (j + 1)]);
				System.out.println("result -->"+Arrays.toString(result));
			}
		}

		return result[n];
	}

	// main function
	public static void main(String[] args)
	{
		// length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		//int price [] = { 1, 5, 8, 9, 10, 17, 17, 20 }; //{2, 5, 7, 8};

		// rod length
		//int n = 8;
		
		

		//System.out.println("Profit is " + rodCut(price, n));
		
		int prices[] = {2, 3, 7, 8, 10};
		int length = 5;
		
		CutRod cr = new CutRod();
		System.out.println(cr.rodCutting(length, prices));
		
		
		int[] price = {1, 5, 8, 9, 10, 22, 17, 20, 24, 30};
		int N = price.length;
		int K = 3;
		int[][] D = new int[N+1][K+1];

		for (int n = 1; n <= N; n++)
		    D[n][0] = price[n-1];

		for (int k = 1; k <= K; k++)
		for (int n = 0; n <= N; n++)
		for (int i = 0; i <= n-1; i++) {
		    D[n][k] = Math.max(D[n][k], price[i] + D[n-i-1][k-1]);
		    //System.out.println(Arrays.deepToString(D));
		}

		int best = 0;
		for (int k = 0; k <= K; k++)
		    best = Math.max(best, D[N][k]);

		System.out.println(best);
	}
}