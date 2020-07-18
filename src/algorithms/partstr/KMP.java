package algorithms.partstr;

/**
 * KMP算法实现
 * @author ZhangChao
 * @since 2020/7/6
 */
public class KMP {
    public static int findSubString(String str, String subStr){
        if (null == subStr || subStr.length() == 0){
            return -1;
        }
        if (subStr.length() == 1){
            char c = subStr.charAt(0);
            char[] cArr = str.toCharArray();
            for (int i = 0; i < cArr.length; i++){
                if (c == cArr[i]){
                    return i;
                }
            }
            return -1;
        }else {
            int[] next = findNext(subStr);
            int  i = 0, j = 0;
            for (; i < str.length() && j < subStr.length();){
                char ci = str.charAt(i);
                char cj = subStr.charAt(j);
                if (ci != cj){
                    j = next[j];
                    if (j == -1){
                        i++;
                        j = 0;
                    }
                    continue;
                }
                i++;
                j++;
            }
            if (j == subStr.length()){
                return i - j;
            }else {
                return -1;
            }
        }
    }
    private static int[] findNext(String str) {
        int len = str.length();
        int[] next = new int[len];
        next[0] = -1;
        next[1] = 0;
        for (int i = 2; i < len; i++) {
            int prefixEnd = i - 1;
            int suffixStart = 1;
            String prefix = str.substring(0, prefixEnd);
            String suffix = str.substring(suffixStart, i);
            while (!prefix.equals(suffix) && prefixEnd != 0 && suffixStart != i) {
                prefixEnd--;
                suffixStart++;
                prefix = str.substring(0, prefixEnd);
                suffix = str.substring(suffixStart, i);
            }
            next[i] = prefixEnd;
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "barfoofoobarthefoobarman";
        String sub = "foobarthe";
        System.out.println(findSubString(str, sub));
        System.out.println(str.indexOf(sub));
    }
}
