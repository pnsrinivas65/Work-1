package hello.interviewbit;

public class LongestCommonSubSequence {

	private int lcs(char[] firstChars, char[] secondChars, int m, int n) {

		// if last characters match
		// --> lcs[i][j] = lcs[i-1][j-1]+1
		// if last characters not match
		// --> lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1)

		if (m == 0 || n == 0) {
			return 0;
		}
		if (firstChars[m - 1] == secondChars[n - 1]) {
			return (lcs(firstChars, secondChars, m - 1, n - 1) + 1);
		} else {
			return max(lcs(firstChars, secondChars, m - 1, n), lcs(firstChars, secondChars, m, n - 1));
		}
	}

	private int max(int i, int j) {
		return (i > j) ? i : j;

	}

	private int lcs_loop(char[] firstChars, char[] secondChars, int m, int n) {

		// if last characters match
		// --> lcs[i][j] = lcs[i-1][j-1]+1
		// if last characters not match
		// --> lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1)

		int[][] initilise = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					initilise[i][j] = 0;
				} else if (firstChars[i - 1] == secondChars[j - 1]) {
					initilise[i][j] = initilise[i - 1][j - 1] + 1;
				} else {
					initilise[i][j] = Math.max(initilise[i - 1][j], initilise[i][j - 1]);
				}
			}
		}

		return initilise[m][n];
	}

	public static void main(String s[]) {
		
		String s1 = "ABCDAF";
		String s2 = "ACBCF";

		char[] firstChars = s1.toCharArray();
		char[] secondChars = s2.toCharArray();
		int m = firstChars.length;
		int n = secondChars.length;

		String flag = "NO";
		for(char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			if(s1.toLowerCase().indexOf(c) > -1 && s2.toLowerCase().indexOf(c) > -1) {
		        flag = "YES";
			}
		}
		System.out.println(flag);
		
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		int recuriseCommSequence = lcs.lcs(firstChars, secondChars, m, n);
		int loopCommSequence = lcs.lcs_loop(firstChars, secondChars, m, n);

		System.out.println(" Longest Common Sub sequence recurrsive " + recuriseCommSequence);
		System.out.println(" Longest Common Sub sequence Loop " + loopCommSequence);
	}

}
