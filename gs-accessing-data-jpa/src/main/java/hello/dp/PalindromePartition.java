package hello.dp;

import java.util.Arrays;

public class PalindromePartition {

	public static void main(String[] args) {
		
		String input = "aab";
		
		PalindromePartition pp = new PalindromePartition();
		pp.minCut(input);

	}

	/*
	 * Given a string s, partition s such that every substring of the partition is a
	 * palindrome. Return the minimum cuts needed for a palindrome partitioning of
	 * s. https://leetcode.com/problems/palindrome-partitioning-ii/
	 */
	public int minCut(String str) {
		if (str.length() == 0) {
			return 0;
		}

		int[] cut = new int[str.length()];
		boolean isPal[][] = new boolean[str.length()][str.length()];
		for (int i = 1; i < str.length(); i++) {
			int min = i;
			for (int j = 0; j <= i; j++) {
				if (str.charAt(i) == str.charAt(j) && (i <= j + 1 || isPal[i - 1][j + 1])) {
					isPal[i][j] = true;
					min = Math.min(min, j == 0 ? 0 : 1 + cut[j - 1]);
				}
			}
			cut[i] = min;
		}
		System.out.println("Temp Array Print -->"+Arrays.deepToString(isPal) );
		System.out.println("Minimum Cut -->"+Arrays.toString(cut));
		return cut[str.length() - 1];
	}

}
