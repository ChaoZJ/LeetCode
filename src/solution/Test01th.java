package solution;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * @author ZhangChao
 * @date 2019/11/2622:31
 */
public class Test01th {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean flag = false;
        for(int i=0; i<nums.length-1 && !flag;i++){
            int a = nums[i];
            int j = i+1;
            for(; j<nums.length; j++){
                int b = nums[j];
                int c = a + b;
                if(c == target){
                    result[0] = i;
                    result[1] = j;
                    flag = true;
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
