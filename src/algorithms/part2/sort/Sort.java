package algorithms.part2.sort;

/**
 * @author zhangchao
 * @since 2020/6/21 13:05
 */
public interface Sort<T> {
    void sort(T[] arr);
    default void exch(T[] arr, int l, int r){
        T temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
