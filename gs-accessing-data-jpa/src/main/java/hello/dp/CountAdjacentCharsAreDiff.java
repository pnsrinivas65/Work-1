package hello.dp;

/**
 * 
 * countAdjacent(n)
    dp[i][j] finally stores count of strings
             of length i and starting with 
             character j.

    Initialize dp[n+1][27] as 0
    Initialize dp[1][j] = 1 where j = 0 to 25
    for i = 2 to n
      for j = 0 to 25
         if (j = 0)
           dp[i][j] = dp[i-1][j+1];
         else
           dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
    Sum of n-th row from 0 to 25 is the result.
 * 
 * 
 */

public class CountAdjacentCharsAreDiff {

	static long countStrs(int n) {
		long[][] dp = new long[n + 1][27];

		// Initializing arr[n+1][27] to 0
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < 27; j++) {
				dp[i][j] = 0;
			}
		}

		// Initialing 1st row all 1 from 0 to 25
		for (int i = 0; i <= 25; i++) {
			dp[1][i] = 1;
		}

		// Begin evaluating from i=2
		// since 1st row is set
		for (int i = 2; i <= n; i++) {

			// j=0 is 'A' which can make strings
			for (int j = 0; j <= 25; j++)

			// of length i using strings of length
			// i-1 and starting with 'B'
			{
				if (j == 0) {
					dp[i][j] = dp[i - 1][j + 1];
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]);
				}
			}
		}

		// Our result is sum of last row.
		long sum = 0;
		for (int i = 0; i <= 25; i++) {
			sum = (sum + dp[n][i]);
		}
		return sum;
	}

	// Driver Code
	public static void main(String[] args) {
		int n = 4;
		System.out.println("Total strings are : " + countStrs(n));
	}
}
