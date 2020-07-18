package algorithms.part2.sort;

/**
 * 选择排序
 * @author zhangchao
 * @since 2020/6/21 13:10
 */
public class SelectSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        if (arr == null){
            return;
        }
        int len = arr.length;
        if (len <= 1){
            return;
        }
        for (int i = 0; i < len; i++){
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < len; j++){
                int temp = arr[j];
                if (temp < min){
                    min = temp;
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }
    }
}
