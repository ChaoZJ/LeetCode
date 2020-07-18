/*
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package solution;

import java.util.*;

/**
 * @author ZhangChao
 * @since 2020/5/29
 */
public class Test39Th {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1 || target <= 0){
            return null;
        }
        int arrLen = candidates.length;
        int candidate = candidates[0];
        List<List<Integer>> result = new ArrayList<>();
        if (arrLen == 1){
            if (target % candidate == 0){
                int div = target / candidate;
                List<Integer> list = new ArrayList<>();
                while (div != 0){
                    list.add(candidate);
                    div--;
                }
                result.add(list);
            }
        }else {
            for (int div = target/candidate; div >= 0; div--){
                int[] subCandidates = Arrays.copyOfRange(candidates, 1, arrLen);
                int res = target - div * candidate;
                if (res != 0){
                    List<List<Integer>> subResult = combinationSum(subCandidates, res);
                    if (!subResult.isEmpty()){
                        for(List<Integer> sub : subResult){
                            int temp = div;
                            while (temp != 0) {
                                sub.add(0, candidate);
                                temp--;
                            }
                        }
                        result.addAll(subResult);
                    }
                }else {
                    List<Integer> list = new ArrayList<>();
                    int temp = div;
                    while (temp != 0){
                        list.add(candidate);
                        temp--;
                    }
                    result.add(list);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Test39Th test39Th = new Test39Th();
        System.out.println(test39Th.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
