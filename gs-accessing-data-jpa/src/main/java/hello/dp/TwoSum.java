package hello.dp;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	
	
	public static  void main(String s[]) {
		
		int nums [] = {2, 7, 11, 15};
		int target = 9;
		TwoSum ts = new TwoSum();
		System.out.println(Arrays.toString(ts.twoSum(nums, target)));
		//Map<Integer, Integer> sum = new HashMap<>();
        //for (int i = 0; i < nums.length; i++) {
        	//int temp = target - nums[i];
        	//if(sum.containsKey(temp)) {
        		//int subtarget [] = {nums[i], temp};
        		//System.out.println(Arrays.toString(subtarget));
        		//break;
        	//}
            //sum.put(nums[i], i);
            //System.out.println(sum);
        //}
        //System.out.println(sum);
        
        // x+y = 9;
        // if x = 9-y
        //List<String> sums = new ArrayList<>();
        //for(int i = 0; i < nums.length; i++) {
        	//int subTarget = target - sum.get(nums[i]);
        	//if(sum.containsKey(subTarget)) {
        		//System.out.println("done");
        		//break;
        	//}
        //}
	}

	
	public int[] twoSum(int[] nums, int target) {
		//int nums [] = {2, 7, 11, 15};
		//int target = 9;
		//int subtarget[] = { 0, 0 };
		//Map<Integer, Integer> sum = new HashMap<>();
		//for (int i = 0; i < nums.length; i++) {
			//int temp = target - nums[i];
			//if (sum.containsKey(temp)) {
				// subtarget[i] = temp;
				// System.out.println(Arrays.toString(subtarget));
				//return new int[] { sum.get(nums[i]), i };
				// break;
			//}
			//sum.put(nums[i], i);

		//}
		//return subtarget;
        
		if (nums == null || nums.length < 2)
			return new int[] { 0, 0 };

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			
			int temp = target - nums[i];
			
			if (map.containsKey(nums[i])) {
				return new int[] { map.get(nums[i]), i };
			} else {
				map.put(temp, i);
			}
		}
     
        return new int[]{0,0};
	}
}
