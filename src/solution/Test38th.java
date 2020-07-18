package solution;

public class Test38th {
	 public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		} else {
			String str = countAndSay(n - 1);
			int len = str.length();
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < len; ) {
				char ci = str.charAt(i);
				if (i < len-1) {
					int j = i+1;
					StringBuilder builder = new StringBuilder();
					builder.append(ci);
					for (;  j< len; j++) {
						char cj = str.charAt(j);
						if (cj == ci) {
							builder.append(cj);
						}else {
							break;
						}
					}
					i = j;
					temp.append(getStr(builder.toString()));
				}else {
					temp.append(getStr(String.valueOf(ci)));
					i++;
				}
			}
			return temp.toString();
		}
	}

	private String getStr(String str) {
		StringBuilder builder = new StringBuilder();
		int len = str.length();
		if (len == 1) {
			builder.append(1);
			builder.append(str);
		} else if (len > 1) {
			builder.append(len);
			builder.append(str.charAt(0));
		}
	
		return builder.toString();
	}

	public static void main(String[] args) {
		Test38th test38th = new Test38th();
		String string = test38th.countAndSay(6);
		System.out.println(string);
	}

}
