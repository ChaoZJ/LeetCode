package solution;

/**
 * 罗马数字转整数
 * @author ZhangChao
 * @date 2019/11/2821:43
 */
public class Test13th {
    /*
        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
         X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
         C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     */
    private final String[] NUMBER_NAME = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private final int[] NUMBER_VALUE = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    public int romanToInt(String s) {
        int len = NUMBER_NAME.length;
        if (s.length() == 1){
            for (int i=0; i < len; i++){
                String name = NUMBER_NAME[i];
                if (s.equals(name)){
                    return NUMBER_VALUE[i];
                }
            }
        }
        int slen = s.length();
        int result = 0;
        for (int i=0; i<slen; i++){
            char first = s.charAt(i);
            boolean isContinue = true;
            if (i < slen-1){
                char second = s.charAt(i+1);
                String tar = String.valueOf(new char[]{first, second});
                for (int j=0; j < len; j++){
                    String name = NUMBER_NAME[j];
                    if (tar.equals(name)){
                        result += NUMBER_VALUE[j];
                        isContinue = false;
                        i++;
                        break;
                    }
                }
            }
            if (isContinue){
                for (int j=0; j < len; j++){
                    String name = NUMBER_NAME[j];
                    if (String.valueOf(first).equals(name)){
                        result += NUMBER_VALUE[j];
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test13th test = new Test13th();
        System.out.println(test.romanToInt("MCMXCIV"));
    }
}
