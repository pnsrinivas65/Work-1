package hello.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String s[]) {
		List<String> dict = new ArrayList<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		List<String> dict1 = Arrays.asList("able", "ale", "apple", "bale", "kangaroo");

		WordBreak wb = new WordBreak();
		// wb.wordBreak("", dict);
		System.out.println(wb.wordBreak("catsanddog", dict));
		System.out.println(wb.wordBreak("abppplee", dict1));

	}

	public boolean wordBreak(String s, List<String> wordDict) {
		List<String> words = new ArrayList<String>();
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				
				String word = s.substring(j, i);
				
				if (f[j] && wordDict.contains(word)) {
					System.out.println("J -->"+j+"<-- i -->"+i+"<-- word -->"+word+"f[i]"+Arrays.toString(f));
					f[i] = true;
					words.add(word);
					break;
				}
			}
		}
		System.out.println(words);
		System.out.println("words -->" + words);
		return f[s.length()];
	}

}
