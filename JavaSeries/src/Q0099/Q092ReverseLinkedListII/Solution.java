package Q0099.Q092ReverseLinkedListII;

import DataStructure.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0, head); // 挂头结点
        ListNode p = dummy;
        // Find the m-1 th node
        for (int i = 0; i < m - 1; i++) p = p.next;
        ListNode prev = p;
        ListNode cur = p.next;
        ListNode tail = cur;
        // Reverse from m to n
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // Connect three parts
        p.next = prev;
        tail.next = cur;
        return dummy.next;
    }
}
