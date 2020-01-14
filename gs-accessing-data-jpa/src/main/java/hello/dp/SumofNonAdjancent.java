package hello.dp;

public class SumofNonAdjancent {

	public static void main(String s[]) {
		// inclusive and exclusive
		// declare temp to hold inclusive
		// inclusive = max(inclusive, exclusive+input[i])
		// exclusive = temp
		
		// 4, 1, 1, 4, 2, 1
		int [] inputValues = {3, 5, -7, 8, 10};
			//{1, 20, 3};
			//{4, 1, 1, 4, 2, 1};
		
		// [4,1,1,4,2,1]
		// i = 0; inclusive: 4; exclusive: 0;
		// i = 1; inclusive: Max(exclusive + 1, inclusive) = 4; exclusive = 4; 
		// i = 2; inclusive: Max(4 + 1, inclusive) = 5;  exclusive = 4;
		// i = 3; inclusive: Max(4 + 4, 5) = 8; exclusive = 5;
		// i = 4; inclusive: Max(5 + 2, 8) = 8; exclusive = 8;
		// i = 5; inclusive: Max(8 + 1, 8) = 9; exclusive = 8;
		
		int inclusive = 0;
		int exclusive = 0;
		
		for (int i = 0; i < inputValues.length; i++) {
			
			int current = inputValues[i];
			int temp = inclusive;
			
			inclusive = Math.max(inclusive, exclusive + current);
			exclusive = temp;
			
			System.out.println("inclusive -->"+inclusive);
		}
	}
}
