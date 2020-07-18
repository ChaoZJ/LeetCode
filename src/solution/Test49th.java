package solution;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author ZhangChao
 * @since 2020/7/8
 */
public class Test49th {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs != null && strs.length > 0){
            if (strs.length == 1){
                List<String> sub = new ArrayList<>();
                sub.add(strs[0]);
                res.add(sub);
            }else {
                Map<String, Integer> map = new HashMap<>();
                for (String str : strs){
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    String index = new String(chars);
                    if (map.containsKey(index)){
                       int i = map.get(index);
                       List<String> sub = res.get(i);
                       sub.add(str);
                    }else {
                        List<String> sub = new ArrayList<>();
                        sub.add(strs[0]);
                        map.put(index, res.size());
                        res.add(sub);
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Test49th test49th = new Test49th();
        System.out.println(test49th.groupAnagrams(new String[]{"", ""}));
    }
}
