package hello.dp;

import java.util.Arrays;

public class CoinChangingDP {

	public static void main(String[] args) {

		int coins[] = { 7, 2, 3, 6 };

		CoinChangingDP coin = new CoinChangingDP();
		coin.numberofCoins(13, coins);
		
		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		int n = 4;
		coin.count(arr, m, n);
		System.out.println(" Coins -->" + coin.count1(arr, m, 4));

		long Coins[] = { 1, 5, 10 };

		System.out.println("The Coins Array:");
		coin.printArray(Coins);

		System.out.println("Solution:");
		System.out.println(coin.getNumberOfWays(12, Coins));

	}

	private long getNumberOfWays(long N, long[] coins) {
		// Create the ways array to 1 plus the amount
		// to stop overflow
		long[] ways = new long[(int) N + 1];

		// Set the first way to 1 because its 0 and
		// there is 1 way to make 0 with 0 coins
		ways[0] = 1;

		// Go through all of the coins
		for (int i = 0; i < coins.length; i++) {

			// Make a comparison to each index value
			// of ways with the coin value.
			for (int j = 0; j < ways.length; j++) {
				if (coins[i] <= j) {

					// Update the ways array
					ways[j] += ways[(int) (j - coins[i])];
				}
			}
			System.out.println("ways -->" + Arrays.toString(ways));
		}

		// return the value at the Nth position
		// of the ways array.
		return ways[(int) N];
	}

	private void printArray(long[] coins) {
		for (long i : coins)
			System.out.println(i);
	}

	public int count(int S[], int m, int n) {
		// table[i] will be storing the number of solutions for
		// value i. We need n+1 rows as the table is constructed
		// in bottom up manner using the base case (n = 0)
		int table[] = new int[n + 1];

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[] values
		// after the index greater than or equal to the value of the
		// picked coin
		for (int i = 0; i < m; i++)
			for (int j = S[i]; j <= n; j++)
				table[j] += table[j - S[i]];
		System.out.println("table" + Arrays.toString(table));
		return table[n];
	}

	// Returns the count of ways we can
	// sum S[0...m-1] coins to get sum n
	private int count1(int S[], int m, int n) {
		// If n is 0 then there is 1 solution
		// (do not include any coin)
		if (n == 0)
			return 1;

		// If n is less than 0 then no
		// solution exists
		if (n < 0)
			return 0;

		// If there are no coins and n
		// is greater than 0, then no
		// solution exist
		if (m <= 0 && n >= 1)
			return 0;

		// count is sum of solutions (i)
		// including S[m-1] (ii) excluding S[m-1]
		return count(S, m - 1, n) + count(S, m, n - S[m - 1]);
	}

	/**
	 * T[i] = min(T[j], 1+(i-min(j));
	 */

	public int numberofCoins(int total, int[] coins) {

		int temp[] = new int[total];
		int max[] = new int[total];
		for (int i = 0; i < total; i++) {
			//System.out.println(i);
			temp[i] = 0;
			max[i] = 0;
		}
		// System.out.println("coins before 1--> " + Arrays.toString(temp));
		// System.out.println("coins before 2--> " + Arrays.toString(max));
		// System.out.println("coins before 3--> " + Arrays.toString(coins)); for (int
		for (int i = 0; i < total; i++) {

			for (int j = 0; j <= coins.length; j++) {
				if (i == temp[j] && i >= j) {
					temp[i] = Math.min(temp[i], (1 + temp[i - j]));
					max[i] = temp[i];
				}
			}
		}
		System.out.println("coins before 3--> " + Arrays.toString(temp));

		return 0;
	}
}
