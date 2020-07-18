package solution;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @author ZhangChao
 * @since 2020/7/7
 */
public class Test43th {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        char[] num1CharArray = num1.toCharArray();
        char[] num2CharArray = num2.toCharArray();
        int len2 = num2CharArray.length;
        char[] chars = {'0'};
        for (int j = len2 - 1; j > -1; j--){
            chars = multiply(num1CharArray, num2CharArray[j], chars, builder);
        }
        for (int i = chars.length - 1; i > -1; i--){
            builder.append(chars[i]);
        }
        builder.reverse();
        return builder.toString();
    }

    private char[] multiply(char[] a, char b, char[] c, StringBuilder builder){
        int len = a.length;
        char cc = '0';
        StringBuilder temp = new StringBuilder();
        for (int i = len - 1; i > -1; i--){
            char ci = a[i];
            char[] res = singleMul(ci, b, cc);
            temp.append(res[1]);
            cc = res[0];
        }
        if (cc != '0'){
            temp.append(cc);
        }
        char[] tempChar = temp.reverse().toString().toCharArray();
        temp = new StringBuilder();
        int i = tempChar.length - 1, j = c.length - 1;
        cc = '0';
        for (; i > -1 && j > -1; i--, j--){
            char ci = tempChar[i];
            char cj = c[j];
            char[] res = charAdd(ci, cj, cc);
            temp.append(res[1]);
            cc = res[0];
        }
        if (i > -1){
            for (; i > -1; i--){
                char ci = tempChar[i];
                char[] res = charAdd(ci, cc, '0');
                temp.append(res[1]);
                cc = res[0];
            }
        }else if (j > -1){
            for (; j > -1; j--){
                char cj = c[j];
                char[] res = charAdd(cj, cc, '0');
                temp.append(res[1]);
                cc = res[0];
            }
        }
        if (cc != '0'){
            temp.append(cc);
        }
        builder.append(temp.charAt(0));
        temp.deleteCharAt(0);
        temp.reverse();
        return temp.toString().toCharArray();
    }

    private char[] singleMul(char a, char b, char c){
        char[] chars = new char[2];
        int aInt = a - '0';
        int bInt = b - '0';
        int cInt = c - '0';
        int mul = aInt * bInt + cInt;
        chars[0] = (char)(mul/10 + '0');
        chars[1] = (char)(mul%10 + '0');
        return chars;
    }

    private char[] charAdd(char a, char b, char c){
        char[] chars = new char[2];
        int aInt = a - '0';
        int bInt = b - '0';
        int cInt = c - '0';
        int sum = aInt + bInt + cInt;
        chars[0] = (char)(sum/10 + '0');
        chars[1] = (char)(sum%10 + '0');
        return chars;
    }


    public static void main(String[] args) {
        Test43th test43th = new Test43th();
        String s = test43th.multiply("748274892749271497294729374982342342134234234", "356235324523542353263255235432452362353245423523");
        System.out.println(s);
    }
}
