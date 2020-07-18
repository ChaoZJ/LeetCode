package algorithms.part2.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 希尔排序
 * @author zhangchao
 * @since 2020/6/21 13:54
 */
public class ShellSort implements Sort<Integer>{
    @Override
    public void sort(Integer[] arr) {
        if (arr == null){
            return;
        }
        int len = arr.length;
        if (len <= 1){
            return;
        }
        int h = 1;
        while (h < len/3){
            h = h * 3 + 1;
        }
        while (h >= 1){
            for (int i = h; i < len; i++){
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h){
                    int temp = arr[j];
                    arr[j] = arr[j - h];
                    arr[j - h] = temp;
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {9, 8, 7, 6, 4, 3, 2, 12, 234, 233, 11, 456, 55};
        new ShellSort().sort(arr);
        String s = Arrays.stream(arr)
                .map(String::valueOf)
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(s);
    }
}
