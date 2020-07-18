package solution;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。
 * @author zhangchao
 *
 */
public class Test23th {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		} else if (lists.length == 1) {
			return lists[0];
		} else {
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] == null) {
					lists[i] = new ListNode(Integer.MAX_VALUE);
				}
			}
		}
		ListNode head;
		int index = min(lists);
		head = new ListNode(lists[index].val);
		ListNode tempNode = head;
		do {
			ListNode listNode = lists[index];
			if (listNode.next == null) {
				ListNode listNode2 = new ListNode(Integer.MAX_VALUE);
				listNode.next = listNode2;
				lists[index] = listNode2;
			} else {
				lists[index] = listNode.next;
			}
			index = min(lists);
			if (lists[0].val < Integer.MAX_VALUE) {
				tempNode.next = new ListNode(lists[0].val);
				tempNode = tempNode.next;
			}
		} while (!end(lists));
		if (head.val == Integer.MAX_VALUE) {
			head = null;
		}
		return head;
	}
	
	private boolean end(ListNode[] lists) {
		boolean flag = true;
		for (int i = 0; i < lists.length && flag; i++) {
			ListNode listNode = lists[i];
			if (listNode.val < Integer.MAX_VALUE) {
				flag = false;
			}
		}
		return flag;
	}
	private int min(ListNode[] listNodes) {
		int index = 0;
		ListNode minNode = listNodes[index];
		for (int i = 0; i < listNodes.length; i++) {
			if (listNodes[i].val < minNode.val) {
				index = i;
				minNode = listNodes[i];
			}
		}
		return index;
	}
	public static void main(String[] args) {
		Test23th test23th = new Test23th();
		ListNode[] lists = {test23th.new ListNode(2), null, test23th.new ListNode(-1)};
		ListNode listNode = test23th.mergeKLists(lists);

	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	
	
}
