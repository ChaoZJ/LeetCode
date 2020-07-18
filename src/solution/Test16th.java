package solution;

import java.util.Arrays;

/**
 *	给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 	返回这三个数的和。假定每组输入只存在唯一答案。
 * @author zhangchao
 *
 */
public class Test16th {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int len = nums.length;
		int result = nums[0]+nums[1]+nums[2];
		if (target <= result) {
			return result;
		}
		result = nums[len-3]+nums[len-2]+nums[len-1];
		if (target >= result) {
			return result;
		}
		boolean find = false;
		int x = Math.abs(target - result); 
		for (int i = 0; i < len-2 && !find; i++) {
			int a = nums[i];
			for (int j = i+1; j < len-1 && !find; j++) {
				int b = nums[j];
				for (int k = j+1; k < len && !find; k++) {
					int c = nums[k];
				    int sum = a + b + c;
				    int tempx = Math.abs(sum - target);
				    if (tempx < x) {
				    	x = tempx;
						result = sum;
						if (x == 0) {
							find = true;
						}
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Test16th test16th = new Test16th();
		System.out.println(test16th.threeSumClosest(new int[] {0,2,1,-3}, 1));//[0,2,1,-3]
	}

}
