package hello.dp;

import java.util.Arrays;

public class CoinChangeWays {
	
	
	/**
	
	Coins --> 1, 2, 3
	Total --> 5
	
		|   | 0 | 1 | 2 | 3 | 4 | 5 |
		|---|---|---|---|---|---|---|
[1]		| 1 | 1 | 1 | 1 | 1 | 1 | 1 |
[1,2]	| 2 | 1 | 1 | 2 | 2 | 3 | 3 | --> 1,1,1,1,1 1,1,1,2 2,1,1,1
[1,2,3]	| 3 | 1 | 1 | 2 | 3 | 4 | 5 |
	
	*/

	
	public static void main(String s[]) {
		
		int input[] = {1, 2, 3};
		
		int total = 5;
		
		
		CoinChangeWays ccw = new CoinChangeWays();
		int numOfWays = ccw.getCoinChangeWays(input, total);
		
		System.out.println(numOfWays);
		
		System.out.println("Efficient Way -->"+ccw.numberOfSolutionsOnSpace(total, input));
	}

	public int getCoinChangeWays(int coins[], int total) {
		
		/**
		 * if(j >= coins[i])
		 * t[i][j] = t[i-1][j] + t[i][j-coins[i]]
		 * else
		 * t[i][j] = t[i-1][j]
		 */
		int temp[][] = new int[coins.length + 1][total + 1];
		for (int i = 0; i <= coins.length; i++) {
			temp[i][0] = 1;
		}
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (coins[i - 1] > j) {
					temp[i][j] = temp[i - 1][j];
				} else {
					temp[i][j] = temp[i][j - coins[i - 1]] + temp[i - 1][j];
				}
			}
		}
		System.out.println(Arrays.deepToString(temp));
        return temp[coins.length][total];
	}
	
	/**
     * Space efficient DP solution
     */
    public int numberOfSolutionsOnSpace(int total, int coins[]){

        int temp[] = new int[total+1];

		temp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j >= coins[i]) {
					temp[j] += temp[j - coins[i]];
				}
			}
		}
		System.out.println(Arrays.toString(temp));
        return temp[total];
    }

}


