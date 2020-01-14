package hello.dp;

public class RodCutting {

	/*
	 * Returns the best obtainable price for a rod of length n and price[] as prices
	 * of different pieces
	 */
	private int cutRod(int price[], int n) {
		if (n <= 0)
			return 0;
		int max_val = Integer.MIN_VALUE;

		// Recursively cut the rod in different pieces and
		// compare different configurations
		for (int i = 0; i < n; i++) {
			int intrimValue = price[i] + cutRod(price, n - i - 1);
			max_val = Math.max(max_val, intrimValue);
			System.out.println("int i "+ i +" <-- price[i] --> "+price[i] + " < -- intrimValue -->"+intrimValue+" <-- max_val -->"+max_val);
		}

		return max_val;
		
		// base case
		/*		if (n == 0) {
					return 0;
				}

				int maxValue = Integer.MIN_VALUE;

				// one by one partition the given rod of length n into
				//  two parts of length (1, n-1), (2, n-2), (3, n-3), ....
				// (n-1 , 1), (n, 0) and take maximum
				for (int i = 1; i <= n; i++)
				{
					// rod of length i has a cost price[i-1]
					int cost = price[i - 1] + cutRod(price, n - i);

					if (cost > maxValue) {
						maxValue = cost;
					}
				}

				return maxValue;*/
	}

	public static void main(String s[]) {
		
		RodCutting rc = new RodCutting();
		
		int prices[] = {2, 5, 7, 8};//{1, 5, 8, 9, 10, 17, 17, 20};
		
		System.out.println(rc.cutRod(prices, 4));
	}
}
