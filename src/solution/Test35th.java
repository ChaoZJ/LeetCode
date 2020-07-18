package solution;
/**
 * 折半查找
 * @author zhangchao
 *
 */
public class Test35th {
	public int searchInsert(int[] nums, int target) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}else {
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
	public static void main(String[] args) {
		Test35th test35th = new Test35th();
		int[] arr = {1};
		System.out.println(test35th.searchInsert(arr, 0));//[1,3,5,6]
	

	}

}
