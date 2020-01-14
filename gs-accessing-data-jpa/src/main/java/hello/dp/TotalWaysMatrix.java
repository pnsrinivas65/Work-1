package hello.dp;

import java.util.Arrays;

public class TotalWaysMatrix {

	/*
	 * 
	 *
	 * 
	 * 
	 * | 1 | 2 | 3 | 4 | --> 
	 * | 5 | 6 | 7 | 8 | --> 
	 * | 9 |10 |11 |12 | --> 
	 * |13 |14 |15 |16 | -->
	 * 
	 * 
	 * | 1 | 1 |1 | 1 | 
	 * | 1 | 2 |3 | 4 | 
	 * | 1 | 3 |6 |10 | 
	 * | 1 | 4 |10|20 |
	 * 
	 * T[i][j] = T[i-i][j] + T[i][j-1]
	 * 
	 * 
	 */

	public static void main(String s[]) {

		int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		TotalWaysMatrix twm = new TotalWaysMatrix();
		System.out.println(twm.getNoOfMatrixWays(input));
		
		System.out.println("recursive -->"+twm.countPathsRecursive(input.length, input[0].length));

	}

	public int getNoOfMatrixWays(int[][] input) {

		int[][] temp = input;
		int rows = input.length;
		int column = input[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column; j++) {
				
				if (i == 0) {
					temp[i][j] = 1;
				
				} else if (j == 0) {
					temp[i][j] = 1;
				
				} else {
					temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
				
				}
			}
		}
		System.out.println(Arrays.deepToString(input));
		return temp[rows - 1][column - 1];
	}
	
	public int countPathsRecursive(int n, int m){
        if(n == 1 || m == 1){
            return 1;
        }
        return countPathsRecursive(n-1, m) + countPathsRecursive(n, m-1);
    }

}
