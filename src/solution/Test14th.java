package solution;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @author ZhangChao
 * @date 2019/11/2822:22
 */
public class Test14th {
    public String longestCommonPrefix(String[] strs) {
        String maxPre = "";
        int minLen = strs[0].length();
        for (String str:strs){
            if (str.length() < minLen){
                minLen = str.length();
            }
        }
        int publicIndix = 0;
        boolean isContinue = true;
        while (publicIndix < minLen && isContinue){
            char temp = strs[0].charAt(publicIndix);
            for (String str : strs){
                char first = str.charAt(publicIndix);
                if (first != temp){
                    isContinue = false;
                }
            }
            if (isContinue){
                maxPre += String.valueOf(temp);
                publicIndix++;
            }
        }
        return maxPre;
    }

    public static void main(String[] args) {
        Test14th test = new Test14th();
        System.out.println(test.longestCommonPrefix(new String[]{"aa"}));
    }
}
