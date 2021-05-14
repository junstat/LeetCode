package Q0099.Q0061RotateList;

import DataStructure.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k %= len;
        if (k == 0) return head;

        ListNode pre = head;
        while (--len > k) pre = pre.next;  // 找到倒数第k个结点的前驱
        ListNode newHead = pre.next;
        tail.next = head;
        pre.next = null;
        return newHead;
    }
}
