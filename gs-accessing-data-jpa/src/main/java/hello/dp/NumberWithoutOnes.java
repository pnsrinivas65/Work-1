package hello.dp;

import java.util.Arrays;

public class NumberWithoutOnes {
	
	/*
	 * when n == 1 --> 0, 1 								--> 2
	 * when n == 2 --> 00, 01, 10							--> 3
	 * When n == 3 --> 000, 001, 010, 011, 100, 101, 110	--> 5
	 * 
	 */
	
	public static void main(String s[]) {
		
		NumberWithoutOnes nw = new NumberWithoutOnes();
		nw.getNumbersWithoutConsecutiveOnes(5);
		
	}
	
	public int getNumbersWithoutConsecutiveOnes(int number) {
		
		int numberOfNonConsecutiveOnes[] = new int[number];
		
		
		numberOfNonConsecutiveOnes[0] = 1;
		numberOfNonConsecutiveOnes[1] = 2;
		
		if(number == 0) {
			return numberOfNonConsecutiveOnes[number];
		} else {
			for(int i = 2; i < number; i++ )
			numberOfNonConsecutiveOnes[i] =  numberOfNonConsecutiveOnes[i-1] + numberOfNonConsecutiveOnes[i-2];
		}
		
		
		System.out.println("numberOfNonConsecutiveOnes --> "+Arrays.toString(numberOfNonConsecutiveOnes));
		
		return numberOfNonConsecutiveOnes[number-1];
		
	}

}
