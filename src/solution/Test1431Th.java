package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchao
 * @description 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 *
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @since 2020/5/24 17:34
 */
public class Test1431Th {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for(int i = 1; i < candies.length; i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }
        List<Boolean> list = new ArrayList();
        for(int i = 0; i < candies.length; i++){
            int temp = candies[i] + extraCandies;
            list.add((temp >= max));
        }
        return list;
    }

    public static void main(String[] args) {
        Test1431Th test1431Th = new Test1431Th();
        System.out.println(test1431Th.kidsWithCandies(new int[]{2,3,5,1,3}, 3));
    }
}
