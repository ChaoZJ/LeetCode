package solution;


/**
 * 简易正则表达式
 * 说明
 * .匹配任一字符
 * 待验证字符串的字符属于[a-z]
 * 模式串中的任意字符后加“*”表示该字符可以出现[0-n]次
 * @author zhangchao 
 *
 */
public class Test10th {
	public boolean isMatch(String s, String p) {
		boolean result = true;
		//TODO
		return result;
	}

	public static void main(String[] args) {
		Test10th test10th = new Test10th();
		System.out.println(test10th.isMatch("aaasabdasdabc", ".*b*c"));
	}

}
