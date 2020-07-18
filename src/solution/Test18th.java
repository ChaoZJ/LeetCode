package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注：不可存在相同四元组
 * @author zhangchao
 *
 */
public class Test18th {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int len = nums.length;
		if (len == 3) {
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				sum+=nums[i];
			}
			if (sum == target) {
				List<Integer> list = new ArrayList<>();
				Arrays.stream(nums)
				.forEach(list::add);
				result.add(list);
			}
		}else if (len > 3) {
			Arrays.sort(nums);
			for (int j = 0; j < len-2; j++) {
				int b = nums[j];
				int m = j+1, n = len-1;
				while (m < n) {
					int c = nums[m];
					int d = nums[n];
					int sum = b+c+d;
					if (sum == target) {
						List<Integer> list = Arrays.asList(b, c, d);
						if (!contains(result, list)) {
							result.add(list);
						}
						m++;
						n--;
					}else if (sum > target) {
						n--;
					}else {
						m++;
					}
				}
			}
		}
		return result;
	}
	
	private boolean contains(List<List<Integer>> bigList, List<Integer> list) {
		boolean contains = false;
		if (!bigList.isEmpty()) {
			for (List<Integer> cList : bigList) {
				boolean eq = cList.get(0).equals(list.get(0));
				if (eq) {
					eq = cList.get(1).equals(list.get(1));
				}
				if (eq) {
					eq = cList.get(2).equals(list.get(2));
				}
				if (eq) {
					eq = cList.get(3).equals(list.get(3));
				}
				
				if (eq) {
					contains = true;
					break;
				}
			}
		}
		return contains;
	}

	public static void main(String[] args) {
		Test18th test18th = new Test18th();
		List<List<Integer>> result = test18th.fourSum(new int[] {-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492}, 1682);//
		System.out.println(result);
		/**
		 * [-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492]
1682
		 */
	}


}
