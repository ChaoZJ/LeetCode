package solution;
/**
 * 最长回文子串，动态规划法
 * @author zhangchao
 *
 */
public class Test05th {
	public String longestPalindrome(String s) {
		String result = "";
		int len = s.length();
		if (len <= 1) {
			result = s;
		}else {
			char[] chars = s.toCharArray();
			StringBuilder str = new StringBuilder("#");
			for (int i = 0; i<len*2; i++) {
				if (i%2==0) {
					str.append(chars[i/2]);
				}else {
					str.append("#");
				}
			}
			String string = str.toString();
			boolean flag = true;
			for(int i=1; i<string.length(); i++) {
				int j = i;
				String temp = "";
				if (string.charAt(i) != '#') {
					temp = temp+string.charAt(i);
				}
				int x = 1;
				while (flag) {
					int q = j+x, p = j-x;
					if (q == string.length() || p == -1) {
						flag = false;
					}else {
						char qq = string.charAt(q);
						char pp = string.charAt(p);
						if (qq != pp) {
							flag = false;
						}else {
							if (qq != '#') {
								temp = pp+temp+qq;
							}
							x++;
						}
					}
				}
				if (temp.length() > result.length()) {
					result = temp;
				}
				flag = true;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Test05th test5th = new Test05th();
		String result = test5th.longestPalindrome("asabssbakasjfklsagasjhklsadhgslkhglshgslaksags");
		System.out.println(result);
	}

}
