package algorithms.part2.sort;

/**
 * 插入排序
 * @author zhangchao
 * @since 2020/6/21 13:40
 */
public class InsertSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        if (arr == null){
            return;
        }
        int len = arr.length;
        if (len <= 1){
            return;
        }
        for (int i = 1; i < len; i++){
            int temp = arr[i];
            for (int j = i; j >= -1; j--){
                if (j == -1 || arr[j] < temp){
                    for (int k = i; k > j + 1; k--){
                        arr[k] = arr[k - 1];
                    }
                    arr[j + 1] = temp;
                    break;
                }
            }
        }
    }
}
