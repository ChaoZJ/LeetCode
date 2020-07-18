/*
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *  
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package solution;

import java.util.List;

/**
 * @author ZhangChao
 * @since 2020/5/26
 */
public class Test25Th {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1){
            return head;
        }
        ListNode headPre = new ListNode(0);
        ListNode tempPre = headPre;
        headPre.next = head;
        ListNode tailNext = headPre.next;
        while (tempPre != null){
            boolean reverse = true;
            for (int i = 0; i < k; i++){
                if (tailNext != null){
                    tailNext = tailNext.next;
                }else {
                    reverse = false;
                    break;
                }
            }
            if (!reverse){
                break;
            }
            reverse(tempPre, tailNext);
            for (int i = 0; i < k; i++){
                tempPre = tempPre.next;
            }
        }
        return headPre.next;
    }

    private void reverse(ListNode startPre, ListNode tailNext){
        ListNode start = startPre.next;
        ListNode startNext = start.next;

        ListNode endPre = null;
        ListNode end = null;
        ListNode endNext = tailNext;

        for (;;){
            ListNode temp = start;
            while (temp.next.next != endNext){
                temp = temp.next;
            }
            endPre = temp;
            end = temp.next;
            if (startNext == end){
                startPre.next = end;
                end.next = start;
                start.next = endNext;
                break;
            }else if (start == end){
                break;
            }
            startPre.next = end;
            end.next = startNext;
            endPre.next = start;
            start.next = endNext;
            temp = end;
            end = start;
            start = temp;
            startPre = start;
            start = startPre.next;
            startNext = start.next;
            endNext = end;
            if (startNext == endNext){
                break;
            }
        }
    }

    public static void main(String[] args) {//0,1,2,3,4,5,6,7,8,9,10
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 1; i <= 10; i++){
            ListNode next = new ListNode(i);
            temp.next = next;
            temp = next;
        }
        Test25Th test25Th = new Test25Th();
        ListNode newHead = test25Th.reverseKGroup(head, 11);
        while (newHead != null){
            System.out.print(String.valueOf(newHead.val) + ',');
            newHead = newHead.next;
        }

    }
}

