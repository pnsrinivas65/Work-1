package hello.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DictonaryWordMatches {
	
	List <String> wordDict = new ArrayList<String>();
	
	/**
	 * @return the wordDict
	 */
	public List<String> getWordDict() {
		return wordDict;
	}

	/**
	 * @param wordDict the wordDict to set
	 */
	public void setWordDict(List<String> wordDict) {
		this.wordDict = wordDict;
	}

	public DictonaryWordMatches() {
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		//wordDict.add("leet");
		//wordDict.add("code");
	}
	
	
	//public static void main(String s[]) {
		
		/*
		 * if input(i....j) is in dictionary
		 * a[i][j]=T
		 * else a[i][j]=T if
		 * a[i][k] && a[k+1][j] is in dictionary 
		 */
		
	//}

	
	// set to hold dictionary values
	private static Set<String> dictionary = new HashSet<>();

	public static void main(String[] args) {

		// array of strings to be added in dictionary set.
		//String temp_dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i",
			//	"like", "ice", "cream", "k" };

		// loop to add all strings in dictionary set
		//for (String temp : temp_dictionary) {
			//dictionary.add(temp);
		//}

		String words = "catsanddog";
		
		DictonaryWordMatches wordDictionary  = new DictonaryWordMatches();
		// sample input cases
		System.out.println(wordDictionary.wordBreak1(words));
		System.out.println("WordBreak Iterative Loop"+ wordDictionary.isWordBreak(words));
		System.out.println("WordBreak Iterative Loop 2"+ wordDictionary.wordBreak(words, wordDictionary.getWordDict()));
		//System.out.println(wordBreak("iiiiiiii"));
		//System.out.println(wordBreak(""));
		//System.out.println(wordBreak("ilikelikeimangoiii"));
		//System.out.println(wordBreak("samsungandmango"));
		//System.out.println(wordBreak("samsungandmangok"));

	}

	// returns true if the word can be segmented into parts such
	// that each part is contained in dictionary
	public  boolean wordBreak1(String s) {
		List<String> words = new ArrayList<String>();
		int size = s.length();

		// base case
		if (size == 0)
			return true;

		// else check for all words
		for (int i = 1; i <= size; i++) {
			// Now we will first divide the word into two parts ,
			// the prefix will have a length of i and check if it is
			// present in dictionary ,if yes then we will check for
			// suffix of length size-i recursively. if both prefix and
			// suffix are present the word is found in dictionary.

			String subString1 = s.substring(0, i);
			String subString2 = s.substring(i, size);
			//System.out.println("word --> " + s + " <-- subString1 -->" + subString1 + "< -- subString2 -->"
				//	+ subString2 + " <-- dictionary.contains(subString1) && wordBreak(subString2) -->"
					///+ " <-- (dictionary.contains(subString1) --> "+ (dictionary.contains(subString1)) 
						//	);
			boolean value = wordDict.contains(subString1) && wordBreak1(subString2);
			
			if (value) {
				words.add(subString1);
				System.out.println("words"+words);
				return value;
			}
			
		}
		
		// if all cases failed then return false
		return false;
	}
	
	
	public List<String> isWordBreak(String s) {
		
		
		List<String> words = new ArrayList<String>();
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				String word = s.substring(j, i);
				if (f[j] && wordDict.contains(word)) {
					f[i] = true;
					words.add(word);
					break;
				}
			}
		}
		System.out.println("isWordStateVariable -->" + words);
		return words;
		
	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
	       
        int size = s.length();

		if (size == 0)
			return true;

		for (int i = 1; i <= size; i++) {

			String subString1 = s.substring(0, i);
			String subString2 = s.substring(i, size);
			boolean value = wordDict.contains(subString1) && wordBreak(subString2, getWordDict());
			if (value) {
				return value;
			}
		}

		return false;

    }
}


/**
 * IAMACE
 * Start with Length 1 and check the word/s in Dictionary
 * Start with Length 2 and check the word/s in Dictionary
 * 		With length = 2, spilt the words and cross check
 	https://www.tablesgenerator.com/markdown_tables#
 

| 0 | 1 | 2 | 3 | 4 | 5 | 6 |
|---|---|---|---|---|---|---|
| 1 | T | T | T | F | T |   |
| 2 |   | T | T | F | T |   |
| 3 |   | F | F | F | F |   |
| 4 |   |   | T | F | T |   |
| 5 |   |   |   | F | F |   |
| 6 |   |   |   |   |   | F |


*/