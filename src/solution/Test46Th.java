/*
 *
 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangChao
 * @since 2020/5/26
 */
public class Test46Th {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        int sum = 1;
        while (len != 0){
            sum = sum * len;
            len--;
        }
        List<List<Integer>> lists = new ArrayList<>(sum);
        order(nums, 0, 0);
        List<Integer> sub = new ArrayList<>();
        for (int i : nums){
            sub.add(i);
        }
        lists.add(sub);
        for (int i = 0; i < sum - 1; i++){
            nums = nextPermutation(nums);
            sub = new ArrayList<>();
            for (int j : nums){
                sub.add(j);
            }
            lists.add(sub);
        }
        return lists;
    }
    private int[] nextPermutation(int[] arr) {
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            nums[i] = arr[i];
        }
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
        return nums;
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
        Test46Th test46Th = new Test46Th();
        List<List<Integer>> list = test46Th.permute(new int[]{1, 2, 3, 4, 5, 5});
        System.out.println(list.size());
        for (List<Integer> sub : list){
            System.out.println(sub);
        }
    }
}
