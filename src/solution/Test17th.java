package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import solution.Test22th.TreeNode;

/**
 *	 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *	 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @author zhangchao
 *
 */
public class Test17th {
	private static Map<Integer, String> map = new HashMap<>();
	static {
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
	}
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits.length() != 0) {
		    TreeNode headNode = buildTree(digits);
		    while (headNode != null) {
			    result.add(headNode.val);
			    headNode = headNode.next;
            }	
		}
		return result;
	}

	private TreeNode buildTree(String digits) {
		String[] nums = digits.split("");
		int index = 0;
		int num = Integer.parseInt(nums[index++]);
		TreeNode root = new TreeNode(num, "");
		TreeNode tempNode = root;
		TreeNode head = null, leaf = null;
		while (true) {
			if (tempNode.hasEnoughChild()) {
				if (tempNode == root) {
					break;
				}else {
					if (tempNode.childCount != 0) {
						index--;
					}
					tempNode = tempNode.parent;
				}
			}else {
				String letter = tempNode.letters[tempNode.index++];
				String val = tempNode.val + letter;
				TreeNode cNode = null;
				if (index == nums.length) {
					cNode = new TreeNode(-1, val);
					tempNode.childs.add(cNode);
					cNode.parent = tempNode;
					tempNode = cNode;
					if (leaf == null) {
						head = tempNode;
						leaf = head;
					}else {
						leaf.next = tempNode;
						leaf = leaf.next;
					}
				}else {
					num = Integer.parseInt(nums[index++]);
					cNode = new TreeNode(num, val);
					tempNode.childs.add(cNode);
					cNode.parent = tempNode;
					tempNode = cNode;
				}
			}
		
		}
		return head;
	}
	
	private class TreeNode{
		int id;
		String[] letters;
		int index = 0;
		List<TreeNode> childs;
		int childCount;
		TreeNode next;
		TreeNode parent;
		String val;
		TreeNode(int id, String val){
			this.id = id;
			if (id == -1) {
				letters = new String[0];
			}else {
				letters = map.get(id).split(""); 
			}
			this.val = val;
			childCount = letters.length;
			childs = new ArrayList<>(childCount);
		}
		boolean hasEnoughChild() {
			return index == childCount;
		}
	
	}
	
	public static void main(String[] args) {
		Test17th test17th = new Test17th();
		System.out.println(test17th.letterCombinations("23"));
	}

}
