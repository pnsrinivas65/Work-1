package hello.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * @author Nagasrinivas_Pothula
 *
 */

// 27. Remove Element 
// https://leetcode.com/articles/remove-element/#approach-1-two-pointers
public class RemoveElement {

	/**
	 * Given an array nums and a value val, remove all instances of that value
	 * in-place and return the new length. Do not allocate extra space for another
	 * array, you must do this by modifying the input array in-place with O(1) extra
	 * memory. The order of elements can be changed. It doesn't matter what you
	 * leave beyond the new length.
	 * 
	 * Example 1:
	 * 
	 * Given nums = [3,2,2,3], val = 3, Your function should return length = 2, with
	 * the first two elements of nums being 2.
	 * 
	 * It doesn't matter what you leave beyond the returned length. Example 2: Given
	 * nums = [0,1,2,2,3,0,4,2], val = 2, Your function should return length = 5,
	 * with the first five elements of nums containing 0, 1, 3, 0, and 4. Note that
	 * the order of those five elements can be arbitrary. It doesn't matter what
	 * values are set beyond the returned length.
	 */

	/**
	 * Clarification:
	 * 
	 * Confused why the returned value is an integer but your answer is an array?
	 * 
	 * Note that the input array is passed in by reference, which means modification
	 * to the input array will be known to the caller as well.
	 * 
	 * Internally you can think of this:
	 * 
	 * // nums is passed in by reference. (i.e., without making a copy) int len =
	 * removeElement(nums, val);
	 * 
	 * // any modification to nums in your function would be known by the caller. //
	 * using the length returned by your function, it prints the first len elements.
	 * for (int i = 0; i < len; i++) { print(nums[i]); }
	 */

	/**
	 * 
	 * Summary This is a pretty easy problem, but one may get confused by the term
	 * "in-place" and think it is impossible to remove an element from the array
	 * without making a copy of the array.
	 * 
	 * Hints Try two pointers. Did you use the fact that the order of elements can
	 * be changed? What happens when the elements to remove are rare?
	 * 
	 */

	/**
	 * Complexity analysis Time complexity : O(n)O(n). Assume the array has a total
	 * of nn elements, both ii and jj traverse at most 2n2n steps.
	 * Space complexity : O(1)O(1).
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		int loop = 0;
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			loop++;
			if (nums[j] != val) {
				nums[i] = nums[j];
				System.out.println("nums[i]"+nums[i]);
				i++;
			}
		}
		System.out.println("For loop -->"+loop+"nums"+Arrays.toString(nums));
		return i;
	}

	public int removeElementWhile(int[] nums, int value) {
	    int i = 0;
	    int size = nums.length;
	    int loop = 0;
	    while (i < size) {
	    	loop++;
			/*
			 * When we encounter nums[i] = valnums[i]=val, we can swap the current element
			 * out with the last element and dispose the last one. This essentially reduces
			 * the array's size by 1. Note that the last element that was swapped in could
			 * be the value you want to remove itself. But don't worry, in the next
			 * iteration we will still check this element.
			 * 
			 */
	        if (nums[i] == value) {
	            nums[i] = nums[size - 1];
	            // reduce array size by one
	            size--;
	        } else {
	            i++;
	        }
	    }
	    
	    
	    
	    int streamArray [] = Arrays.stream(nums).filter(val -> val != value).toArray();
	    
	    int removedindex[] = IntStream.range(0, nums.length) 
        .filter(val -> val != value) 
        .map(val -> nums[val]) 
        .toArray();
	    
	    System.out.println("While loop"+loop+"nums"+Arrays.toString(nums));
	    System.out.println("streamArray"+Arrays.toString(streamArray));
	    System.out.println("removedindex"+Arrays.toString(removedindex));
	    return size;
	}

	public static void main(String s[]) {

		int[] nums = {0,1,2,2,3,0,4,2};
			//{ 1, 3, 5, 6, 4, 4, 4, 3 };
		RemoveElement rm = new RemoveElement();
		int size = rm.removeElement(nums, 4);
		System.out.println("Size in For loop element removed 4 -->" + size);
		size = rm.removeElementWhile(nums, 4);
		System.out.println("Size in While loop element removed 4 -->" + size);
		
	}
}
