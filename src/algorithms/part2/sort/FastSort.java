package algorithms.part2.sort;

/**
 * 快速排序
 * @author zhangchao
 * @since 2020/6/22 22:07
 */
public class FastSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Integer[] arr, int start, int end){
        if (start >= end){
            return;
        }
        int pos = position(arr, start, end);
        sort(arr, start, pos - 1);
        sort(arr, pos + 1, end);
    }

    private int position(Integer[] arr, int low, int high){
        int v = arr[low];
        int i = low + 1, j = high;
        while (true){
            while (arr[i++] < v){
                if (i == high){
                    break;
                }
            }
            while (arr[j--] > v){
                if (low == j){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            exch(arr, i, j);
        }
        exch(arr, low, j);
        return j;
    }
}
