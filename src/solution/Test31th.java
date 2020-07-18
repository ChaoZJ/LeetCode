/*
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package solution;

/**
 * @author ZhangChao
 * @since 2020/5/25
 */
public class Test31th {
    /**
     * 题解：
     * 判断子数组是否逆序，是直接升序排列，把当前元素和子数组中的第一个大于它的元素互换位置
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length > 1){
            int start = nums.length - 2;
            if (nums[start] < nums[start + 1]){
                int temp = nums[start];
                nums[start] = nums[start + 1];
                nums[start + 1] = temp;
            }else {
                start--;
                while (start != -1){
                    if (nums[start] >= nums[start + 1]){
                        start--;
                    }else {
                        int index = order(nums, start + 1, nums[start]);
                        int temp = nums[index];
                        nums[index] = nums[start];
                        nums[start] = temp;
                        break;
                    }
                }
            }
            if (start == -1){
                order(nums, 0, 0);
            }
        }
        System.out.print('[');
        for (int i = 0; i < nums.length - 1; i++){
            System.out.print(String.valueOf(nums[i]) + ',');
        }
        System.out.print(nums[nums.length - 1]);
        System.out.print(']');
    }

    private int order(int[] nums, int start, int target){
        int targetIndex = nums.length - 1;
        int end = nums.length - 1;
        boolean order;
        int temp;
        do {
            order = false;
            for (int i = start; i < end; i++){
                if (nums[i] > nums[i + 1]){
                    temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    order = true;
                }
            }
            end--;
        }while (end != start && order);
        for (int i = start; i < nums.length; i++){
            if (nums[i] > target){
                targetIndex = i;
                break;
            }
        }
        return targetIndex;
    }

    public static void main(String[] args) {
        Test31th test31th = new Test31th();
        int[] arr = {1, 2, 2};
        test31th.nextPermutation(arr);
    }
}
