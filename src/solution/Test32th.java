package solution;

import java.util.Stack;

public class Test32th {
	public int longestValidParentheses(String s) {
		if (s.length() < 2){
			return 0;
		}
		int result = 0;
		Stack<Character> characters = new Stack<>();
		int index = 0;
		int temp = 0;
		boolean stack = false;
		while (index < s.length()) {
			char c = s.charAt(index);
			if (stack){
				if (c == ')'){
					characters.pop();
					temp += 2;
				}
			}
			index++;
		}
		return result;
	}

	public static void main(String[] args) {
		Test32th test32th = new Test32th();
		System.out.println(test32th.longestValidParentheses(")()()"));//")()())()()("
	}

}
