package hello.hackerrank;

import java.util.Arrays;

public class RotateArray {

	
	public static void main(String s[]) {
		
		int input[] = {1, 2, 3, 4, 5};
		int length = input.length;
		int rotateBy = 4;
		rotate(input, length, rotateBy);
	}
	
	public static void rotate(int[] input, int length, int rotateBy) {
        int mod = rotateBy % length;
        System.out.println("mod -->"+mod+" <-- rotateBy % length -->"+rotateBy % length);
        // Prints the rotated array from 
        // start position
        for(int i = 0; i < length; ++i) {
        	System.out.println(Arrays.toString(input));
            System.out.print(input[(i + mod) % length]+ " "); 
        }
         
        //System.out.println();
        System.out.println(Arrays.toString(input));
    }
}
