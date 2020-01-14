package hello.leetcode;

import java.util.Arrays;

//https://leetcode.com/explore/featured/card/recursion-i/250/principle-of-recursion/1440/
/**
 * 
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 * 
 * @author Nagasrinivas_Pothula
 *
 */

public class StringReverse {

	
	int count = 0;
	char[] value = new char[50];

	// check if string is empty
	// if null return
	// else add the characters in one array in reverese using recursion
	public static void printReverse(char[] str) {
		helper(0, str);
	}

	public static char[] helper(int index, char[] str) {
		if (str == null || index >= str.length) {
			return str;
		}
		helper(index + 1, str);
		System.out.print(str[index]);
		return str;
	}

	public static void main(String s[]) {
		
		String helloworld = "Hello World";

		printReverse(helloworld.toCharArray());

		double[] d = { 8, 7, -6, 5, -4 };
		d = Arrays.stream(d).filter(x -> x > 0).sorted().toArray();

		System.out.println(Arrays.toString(d));

		StringReverse reverse = new StringReverse();
		reverse.reverseString("Hello".toCharArray());

		String reversedString = reverse.reverse(helloworld.toCharArray(), 0, (helloworld.toCharArray().length-1));
		System.out.println("reversedString"+reversedString);
		
	}
	
	public String reverse(char str[], int start, int end) { 
		// Iterate loop upto start not equal to end 
		while (start < end) { 
			// XOR for swapping the variable 
			str[start] ^= str[end]; 
			str[end] ^= str[start]; 
			str[start] ^= str[end]; 
			System.out.println("str -->"+Arrays.toString(str));
			++start; 
			--end; 
		} 
		return new String(str); 
	}

	public void reverse() {
		boolean hasSurrogates = false;

		int n = count - 1;
		for (int j = (n - 1) >> 1; j >= 0; j--) {
			int k = n - j;
			char cj = value[j];
			char ck = value[k];
			value[j] = ck;
			value[k] = cj;
			if (Character.isSurrogate(cj) || Character.isSurrogate(ck)) {
				hasSurrogates = true;
			}
		}
		if (hasSurrogates) {
			reverseAllValidSurrogatePairs();
		}

	}

	/** Outlined helper method for reverse() */
	private void reverseAllValidSurrogatePairs() {
		for (int i = 0; i < count - 1; i++) {
			char c2 = value[i];
			if (Character.isLowSurrogate(c2)) {
				char c1 = value[i + 1];
				if (Character.isHighSurrogate(c1)) {
					value[i++] = c1;
					value[i] = c2;
				}
			}
		}
	}

	public void reverseString(char[] s) {
		reverse(0, s);

	}

	public char[] reverse(int index, char[] s) {

		if (s == null || index >= s.length) {
			return s;
		}

		reverse(index + 1, s);
		System.out.print(s[index]);
		return s;
	}
}
