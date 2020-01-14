package hello.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {

	public static void main(String s[]) {
		
		int [] input = {3, 30, 34, 5, 9};
		
		LargestNumber ln = new LargestNumber();
		ln.largestNumber(input);
		int [] input1 = {3,2,1,5,6,4};
		ln.findKthLargest(input1, 2);
	}

	public String largestNumber(int[] nums) {
				
		String[] arr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = String.valueOf(nums[i]);
		}
				
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (String s : arr) {
			sb.append(s);
		}
		
		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}
	
	public int findKthLargest(int[] nums, int k) {
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
	    for(int i: nums){
	        q.offer(i);
	        System.out.println(q);
	        if(q.size()>k){
	            q.poll();
	        }
	    }
	 
	    return q.peek();
	}

}
