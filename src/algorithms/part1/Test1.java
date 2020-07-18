package algorithms.part1;

/**
 * NO.35
 * T1.1.24
 * @author zhangchao
 * @since 2020/5/29 23:36
 */
public class Test1 {
    public static int euclid(int a, int b){
        System.out.println("a=" + a + ", b=" + b);
        if (b == 0){
            return a;
        }
        int res = a%b;
        return euclid(b, res);
    }

    public static void main(String[] args) {
        System.out.println(Test1.euclid(32, 24));
    }
}
