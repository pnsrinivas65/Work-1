package hello.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String s[]) {

		int numbers[] = { 1, 0, -1, 0, -2, 2 };
		int target = 0;

		System.out.println(new FourSum().fourSum(numbers, target));
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length < 4) {
			return result;
		}

		Arrays.sort(nums);
		int size = nums.length;

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				int left = j + 1;
				int right = size - 1;

				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];

					if (sum == target) {
						List<Integer> res = new ArrayList<Integer>();
						res.add(nums[i]);
						res.add(nums[j]);
						res.add(nums[left]);
						res.add(nums[right]);
						result.add(res);
						
						int leftValue = nums[left];
						while (left < size && nums[left] == leftValue) {
							left++;

						}
						int rightValue = nums[right];
						while (right > left && nums[right] == rightValue) {

							right--;
						}
					} else if (sum < target) {
						left++;
					} else {
						right--;
					}
				}
				while (j + 1 < size && nums[j + 1] == nums[j]) {
					j++;
				}
			}
			while (i + 1 < size && nums[i + 1] == nums[i]) {
				i++;
			}
		}

		return result;
	}
}
