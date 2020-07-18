package algorithms.part2.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhangchao
 * @since 2020/6/21 14:02
 */
public class Main {
    public static void main(String[] args) {
        int len = 1000;
        Integer[] arr = new Integer[len];
        Random random = new Random(47);
        for (int i = 0; i < len; i++){
            arr[i] = random.nextInt(10000);
        }
        Integer[] iArr = Arrays.copyOf(arr, len);
        Integer[] sArr = Arrays.copyOf(arr, len);
        Integer[] shellArr = Arrays.copyOf(arr, len);
        long start = System.nanoTime();
        new InsertSort().sort(iArr);
        long end = System.nanoTime();
        System.out.println("插排耗时：" + (end - start)/1000 + "微秒");
        start = System.nanoTime();
        new SelectSort().sort(sArr);
        end = System.nanoTime();
        System.out.println("选排耗时：" + (end - start)/1000 + "微秒");
        start = System.nanoTime();
        new ShellSort().sort(shellArr);
        end = System.nanoTime();
        System.out.println("Shell耗时：" + (end - start)/1000 + "微秒");
    }
}
