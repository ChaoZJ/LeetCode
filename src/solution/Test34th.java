package solution;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @author ZhangChao
 * @since 2020/7/8
 */
public class Test34th {
    public int[] searchRange(int[] nums, int target) {
        int[] indexes = new int[2];
        indexes[0] = -1;
        indexes[1] = -1;
        if (nums != null){
            int len = nums.length;
            if (len > 0){
                if (target >= nums[0] && target <= nums[len - 1]){
                    indexes[0] = findStart(nums, target, 0, len - 1);
                    indexes[1] = findEnd(nums, target, 0, len - 1);
                }
            }
        }
        return indexes;
    }

    private int findStart(int[] nums, int target, int start, int end){
        if (start == end){
            if(nums[start] == target){
                return start;
            }else{
                return -1;
            }
        }
        int mid = (start + end)/2;
        int temp = nums[mid];
        if (temp > target){
            return findStart(nums, target, start, mid - 1);
        }else if (temp < target){
            return findStart(nums, target, mid + 1, end);
        }else {
            return findStart(nums, target, start, mid);
        }
    }

    private int findEnd(int[] nums, int target, int start, int end){
        if (start == end){
            if(nums[start] == target){
                return start;
            }else{
                return -1;
            }
        }
        int mid = (start + 1 + end)/2;
        int temp = nums[mid];
        if (temp > target){
            return findEnd(nums, target, start, mid - 1);
        }else if (temp < target){
            return findEnd(nums, target, mid + 1, end);
        }else {
            return findEnd(nums, target, mid, end);
        }
    }

    public static void main(String[] args) {
        Test34th test34th = new Test34th();
        int[] ints = {1, 2, 2, 4};
        int[] res = test34th.searchRange(ints, 2);
        System.out.printf("0=%d,1=%d", res[0], res[1]);
    }

}
