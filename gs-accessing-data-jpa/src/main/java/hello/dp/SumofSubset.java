package hello.dp;

import java.util.Arrays;

public class SumofSubset {

	
	
	
	public static void main(String s[]) {

		int [] input = {2, 3, 7, 8};
		int sum = 3;
		
		boolean subSetSum[][] = new boolean[sum+1][input.length+1];
		
		// If sum is 0, then answer is true 
        for (int i = 0; i <= input.length; i++) 
        	subSetSum[0][i] = true; 
      
        // If sum is not 0 and set is empty, 
        // then answer is false 
        //for (int i = 1; i <= sum; i++) 
        	//subSetSum[i][0] = false; 
		
		
		//System.out.println(Arrays.deepToString(subSetSum));
		
		/**
		 * if(j < input[j])
		 * 		t[i][j] = t[i-1][j]
		 * else
		 * 		t[i][j] = t[i-1][j] || t[i-1][j-input[j]]
		 * 
		 * declare 2 dimensional array and fill 1st column as T
		 * temp[i][j] = 
		 * 
		 * 5
			| 0 | 1 | 2 | 3 | 4 | 5 | 6 |
			|---|---|---|---|---|---|---|
			| 2 | T | T | T | F | T |   |
			| 3 | T | T | T | F | T |   |
			| 7 | T | F | F | F | F |   |
			| 8 | T |   | T | F | T |   |
			| 0 | T |   |   | F | F |   |
			| 0 | T |   |   |   |   | F |

		 */
		
		//for(int i =1; i <= sum; i++) {
			//for(int j = 0; j < input.length; j++) {
				/*
				 * if(j < input[j]) { 
				 * 		subSetSum[i][j] = subSetSum[i-1][j]; 
				 * } else {
				 * 		subSetSum[i][j] = subSetSum[i][j] || subSetSum[i-1][j-input[j]]; //||
				 * 		subSetSum[i-1][j-input[j]] 
				 * }
				 */
				
				//subSetSum[i][j] = subSetSum[i][j-1]; 
               // if (i >= input[j-1]) 
                	//subSetSum[i][j] = (subSetSum[i][j]) || (subSetSum[i - input[j-1]][j-1]); 
			//}
		//}
		
		// Fill the subset table in botton 
        // up manner 
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= input.length; j++) {
				
				subSetSum[i][j] = subSetSum[i][j - 1];
				//System.out.println(subSetSum[i][j - 1]);

				if (i >= input[j - 1]) {
					subSetSum[i][j] = subSetSum[i][j] || subSetSum[i - input[j - 1]][j - 1];

					//if (subSetSum[i][j]) {
						//System.out.println(subSetSum[i][j]);
					//}
				}
			}
		}
        System.out.println(Arrays.deepToString(subSetSum));
	}

}
