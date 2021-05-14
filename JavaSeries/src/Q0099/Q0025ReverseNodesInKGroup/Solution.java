package Q0099.Q0025ReverseNodesInKGroup;

import DataStructure.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 1;
        while (head.next != null) {  // 求链表长
            head = head.next;
            len++;
        }

        ListNode pre = dummy;
        for (int l = 0; l + k <= len; l += k) { // 按k个元素给链表分组
            ListNode cur = pre.next;
            ListNode nxt = cur.next;
            for (int i = 1; i < k; i++) {   // 组内元素反转
                cur.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = cur.next;
            }
            pre = cur;
        }
        return dummy.next;
    }
}
