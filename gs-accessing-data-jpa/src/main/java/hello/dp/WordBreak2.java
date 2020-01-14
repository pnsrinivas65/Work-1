package hello.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

	public static void main(String s[]) {

		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		WordBreak2 wb2 = new WordBreak2();
		Set<String> dict1 = new HashSet<String>(Arrays.asList("able", "ale", "apple", "bale", "kangaroo"));

		System.out.println(wb2.wordBreak("catsanddog", dict));
		System.out.println(wb2.wordBreak("abppplee", dict1));

		/**
		 * Given a dictionary of the words(strings) which contains different words & you
		 * are given an input string e.g. “abd”. You need to find the largest word
		 * available in the supplied dictionary which can be made using the letters of
		 * input string. The returned word can contain only the same no of occurrences
		 * of the letters as given in the input string i.e. if a letter is given once
		 * then in the output it should be existed only once. Examples: Dictionary
		 * {“to”, “banana”, “toe”, “dogs”, “ababcd”, “elephant”} and input string is
		 * “eot”. Output should be “toe” Dictionary is same as specified in example a
		 * but the input string is “ogtdes” and the output is “dogs” and “toes”
		 * 
		 */

	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		LinkedList<Integer>[] cache = new LinkedList[s.length() + 1];

		cache[0] = new LinkedList<Integer>();
		cache[0].add(-1);
		int maxLen = getMaxLength(wordDict);
		for (int i = 1; i <= s.length(); i++) {
			for (int len = maxLen; len >= 1; len--) {
				if (i - len >= 0 && cache[i - len] != null && wordDict.contains(s.substring(i - len, i))) {
					if (cache[i] == null) {
						cache[i] = new LinkedList<Integer>();
					}
					cache[i].add(i - len);
				}
			}
		}
		LinkedList<String> res = new LinkedList<>();
		if (cache[s.length()] == null) { // note that it could be null
			return res;
		}
		for (int n : cache[s.length()]) {
			dfs(n, s.length(), "", s, cache, res);
		}
		return res;
	}

	private int getMaxLength(Set<String> wordDict) {
		int ans = 0;
		for (String str : wordDict) {
			ans = Math.max(ans, str.length());
		}
		return ans;
	}

	// use DFS (backtracking) to get the result
	private void dfs(int start, int end, String str, String s, List<Integer>[] cache, LinkedList<String> res) {
		if (start == -1) {
			res.add(str.substring(1));
		} else {
			for (int n : cache[start]) {
				dfs(n, start, " " + s.substring(start, end) + str, s, cache, res);
			}
		}
	}
}
