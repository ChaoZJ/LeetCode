/*
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package solution;

/**
 * @author ZhangChao
 * @since 2020/5/25
 */
public class Test33Th {
    /**
     * 题解：
     * 先判断数组是否自旋
     * 否，进入折半查找
     * 是，找到target所在的有序区间，即先找到数组最大值、最小值及最小值下标，判断折半查找区间（[0, i-1], [i, length]）
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }else if (len == 1){
            if (nums[0] == target){
                return 0;
            }else {
                return -1;
            }
        }else if (len == 2){
            if (nums[0] == target){
                return 0;
            }else if (nums[1] == target){
                return 1;
            }
            return -1;
        }
        if (nums[0] < nums[len - 1]){
            if (nums[0] > target || nums[len - 1] < target){
                return -1;
            }
            return findInPart(nums, target, 0, len);
        }else {
            int middle = len / 2, head = 0, tail = len;
            int max = 0, min = 0, i = 0;
            while (head < tail){
                if (nums[middle] < nums[middle-1] && nums[middle] < nums[middle+1]) {
                    min = nums[middle];
                    max = nums[middle - 1];
                    i = middle;
                    break;
                }else if (nums[middle] > nums[middle-1] && nums[middle] > nums[middle+1]){
                    max = nums[middle];
                    min = nums[middle + 1];
                    i = middle + 1;
                    break;
                }else {
                    if (nums[0] > nums[middle]){
                        tail = middle + 1;
                    }else {
                        head = middle;
                    }
                    middle = (head + tail) / 2;
                }
            }
            if (target >= nums[0] && target <= max){
                return findInPart(nums, target,0, i - 1);
            }else if (target <= nums[len - 1] && target >= min){
                return findInPart(nums, target, i, len);
            }
            return -1;
        }
    }

    private int findInPart(int[] arr, int target, int start, int end){
        int index = -1;
        int middle;
        while (start <= end){
            middle = (start + end) / 2;
            if (arr[middle] == target){
                index = middle;
                break;
            }else if (arr[middle] > target){
                end = middle - 1;
            }else {
                start = middle + 1;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        Test33Th test33Th = new Test33Th();
        int[] arr = {3, 5, 1};
        System.out.println(test33Th.search(arr, 1));
    }
}
