/*
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package solution;

import java.util.*;

/**
 * @author zhangchao
 * @since 2020/5/31 19:46
 */
public class Test40Th {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1 || target <= 0){
            return null;
        }
        Arrays.sort(candidates);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < candidates.length; i++){
            int j = i + 1;
            for (; j < candidates.length && candidates[j] == candidates[i]; j++){}
            int count = Math.min(j - i, target/candidates[i]);
            if (count > 0){
                map.put(candidates[i], count);
            }
            i = j - 1;
        }
        candidates = new int[map.size()];
        Iterator<Integer> integerIterator = map.keySet().iterator();
        int index = 0;
        while (integerIterator.hasNext()){
            candidates[index++] = integerIterator.next();
        }
        Arrays.sort(candidates);
        return combinationSum2(candidates, map, target);
    }
    private List<List<Integer>> combinationSum2(int[] candidates, Map<Integer, Integer> map, int target){
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length < 1 || target <= 0){
            return result;
        }
        int arrLen = candidates.length;
        int candidate = candidates[0];
        if (arrLen == 1){
            int div = Math.min(map.get(candidate), target/candidate);
            if (div * candidate == target){
                List<Integer> list = new ArrayList<>();
                while (div != 0){
                    list.add(candidate);
                    div--;
                }
                result.add(list);
            }
        }else {
            int div = Math.min(map.get(candidate), target/candidate);
            for (; div >= 0; div--){
                int[] subCandidates = Arrays.copyOfRange(candidates, 1, arrLen);
                int res = target - div * candidate;
                if (res != 0){
                    List<List<Integer>> subResult = combinationSum2(subCandidates, map, res);
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
        Test40Th test40Th = new Test40Th();
        System.out.println(test40Th.combinationSum2(new int[]{1}, 2));
    }


}
