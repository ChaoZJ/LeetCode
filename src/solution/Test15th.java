package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *	 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * @author zhangchao
 *
 */
public class Test15th {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> positiveNums = new ArrayList<>();
		List<Integer> negativeNums = new ArrayList<>();
		List<Integer> zeros = new ArrayList<>();
		for (int num : nums) {
			if (num > 0) {
				positiveNums.add(num);
			}else if (num < 0) {
				negativeNums.add(num*-1);
			}else {
				zeros.add(num);
			}
		}
		boolean hasZoro = !zeros.isEmpty();
		if (hasZoro) {
			if (zeros.size() > 2) {
				result.add(Arrays.asList(0, 0, 0));
			}
		}
		Collections.sort(positiveNums);
		Collections.sort(negativeNums);
		
		int positiveNumsLen = positiveNums.size();
		int negativeNumsLen = negativeNums.size();
		
		if (positiveNumsLen > 0 && negativeNumsLen > 0) {
			int index = -1;
			for (int i = positiveNumsLen-1; i > 0; i--) {
				int a = positiveNums.get(i);
				if (a + positiveNums.get(0) > negativeNums.get(negativeNumsLen-1)) {
					continue;
				}
				for (int j = i-1; j >= 0; j--) {
					int b = positiveNums.get(j);
					int sum = a + b;
					if (index == -1) {
						index = searchInsert(negativeNums, sum);
					}
					if (index >= negativeNumsLen) {
						index = negativeNumsLen-1;
					}
					int res = negativeNums.get(index);
					if (sum < res) {
						index--;
						if (index == -1) {
							break;
						}
						j++;
					}else if (sum == res) {
						List<Integer> tempList = Arrays.asList(-res, b, a);
						Collections.sort(tempList);
						if (!contains(result, tempList)) {
							result.add(tempList);
						}
					}
				}
				index = -1;
			}
			index = -1;
			for (int i = negativeNumsLen-1; i > 0; i--) {
				int a = negativeNums.get(i);
				if (a + negativeNums.get(0) > positiveNums.get(positiveNumsLen-1)) {
					continue;
				}
				for (int j = i-1; j >= 0; j--) {
					int b = negativeNums.get(j);
					int sum = a + b;
					if (index == -1) {
						index = searchInsert(positiveNums, sum);
					}
					if (index >= positiveNumsLen) {
						index = positiveNumsLen-1;
					}
					int res = positiveNums.get(index);
					if (sum < res) {
						index--;
						if (index == -1) {
							break;
						}
						j++;
					}else if (sum == res) {
						List<Integer> tempList = Arrays.asList(-a, -b, res);
						Collections.sort(tempList);
						if (!contains(result, tempList)) {
							result.add(tempList);
						}
					}
				}
				index = -1;
			}
			if (hasZoro) {
				for (int i = 0, j = 0; i < positiveNumsLen && j < negativeNumsLen ; ) {
					int a = positiveNums.get(i);
					int b = negativeNums.get(j);
					if (a == b) {
						List<Integer> tempList = Arrays.asList(-a, 0, a);
						if (!contains(result, tempList)) {
							result.add(tempList);
						}
						i++;
						j++;
					}else if (a > b) {
						j++;
					}else {
						i++;
					}
				}
			}
			
		}
		
		return result;
	}

	
	private int searchInsert(List<Integer> numsList, int target) {
		int len = numsList.size();
		if (len == 0) {
			return 0;
		}else {
			Integer[] nums = new Integer[len];
			numsList.toArray(nums);
			int h = 0, e = len, m = (h+e)/2;
			do {
				int temp = nums[m];
				if (temp == target) {
					break;
				}else if (temp < target) {
					h = m+1;
				}else {
					e = m;
				}
				m = (h+e)/2;
			} while (h != e);
			return m;
		}
    }
	
	private boolean contains(List<List<Integer>> bigList, List<Integer> list) {
		boolean flag = false;
		for (List<Integer> subList : bigList) {
			boolean eq = list.get(0) == subList.get(0);
			if (eq) {
				eq = list.get(1) == subList.get(1);
			}
			if (eq) {
				eq = list.get(2) == subList.get(2);
			}
			if (eq) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) throws Exception{
		Test15th test15th = new Test15th();
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(Test15th.class.getResourceAsStream("input.txt")));
		String temp = reader.readLine();
		while (temp != null) {
			builder.append(temp);
			temp = reader.readLine();
		}
		reader.close();
		String input = builder.toString();
		String[] strs = input.split(",");
		int[] in = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			in[i] = Integer.parseInt(strs[i]);
		}
		System.out.println(test15th.threeSum(in).size());

	}

}
