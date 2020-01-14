package hello.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SockMerchant {

	public static void main(String[] args) {
		SockMerchant sm = new SockMerchant();
		int length = 10;
		int[] socksPairs = /*
							 * {44,55,11,15,4,72,26,91,80,14,43,78,70,75,36,83,78,
							 * 91,17,17,54,65,60,21,58,98,87,45,75,97,81,18,51,43,84,54,66,10,
							 * 44,45,23,38,22,44,65,9,78,42,100,94,58,5,11,69,26,20,19,64,64,
							 * 93,60,96,10,10,39,94,15,4,3,10,1,77,48,74,20,12,83,97,5,82,43,15,
							 * 86,5,35,63,24,53,27,87,45,38,34,7,48,24,100,14,80,54};
							 */
			//{10, 20, 20, 10, 10, 30, 50, 10, 20};
				{ 1, 1, 3, 1, 2, 1, 3, 3, 3, 3 };
			//{ 1, 2, 1, 2, 3, 2 };
		sm.getValidPairsCount(length, socksPairs);

	}

	public int getValidPairsCount(int length, int inputArray[]) {

		ArrayList values = new ArrayList();
		if(length == 0) {
			return 0;
		}
		Arrays.sort(inputArray);
		System.out.println("inputArray -->"+Arrays.toString(inputArray));
		/*Set<Integer> colors = new HashSet<>();
	    int pairs = 0;

	    for (int i = 0; i < length; i++) {
	        if (!colors.contains(inputArray[i])) {
	            colors.add(inputArray[i]);
	        } else {
	            pairs++;
	            colors.remove(inputArray[i]);
	        }
	    }

	    System.out.println(pairs);
		*/
		int count = 0;
		for (int i = 0; i < length-1;) {
			System.out.print(i+",");
			if (inputArray[i] == inputArray[i + 1]) {
				count = count + 1;
				values.add(inputArray[i]);
				i+= 2;
				//System.out.println("i --> "+i+" <-- inputArray[i] -->"+inputArray[i]+" inputArray[i+1] "+inputArray[i+1]);
				
			} else {
				i+= 1;
			}
		}
		System.out.println(values);
		System.out.println("count -->"+count);
		return count;
		
	}
}
