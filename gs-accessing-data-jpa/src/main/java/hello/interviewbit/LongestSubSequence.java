package hello.interviewbit;

import java.util.Arrays;

public class LongestSubSequence {

	public static void main(String s[]) {

		int numbers[] = { 1, 11, 2, 10, 4, 5, 2, 1 };

		LongestSubSequence subsequence = new LongestSubSequence();

		subsequence.longestSubsequenceLength(numbers);
	}

	public int longestSubsequenceLength(int A[]) {
		int n = A.length;
		int lis[] = new int[n];
		int lds[] = new int[n];
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			lds[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (A[i] > A[j] && lds[i] < lds[j] + 1)
					lds[i] = lds[j] + 1;
			}
		}
		System.out.println(" lis[i] " + Arrays.toString(lis) + " lds[i] " + Arrays.toString(lds));
		int ans = 0;
		for (int i = 0; i < n; i++)
			ans = max(ans, lis[i] + lds[i] - 1);
		System.out.println("ans -->"+ans);
		return ans;
	}

	private int max(int ans, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
