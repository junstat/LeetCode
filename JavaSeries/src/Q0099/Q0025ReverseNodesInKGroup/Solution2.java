package Q0099.Q0025ReverseNodesInKGroup;

import DataStructure.ListNode;

public class Solution2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        if (k == 1)
            return head;
        ListNode ans = head;
        ListNode pre = head;
        ListNode qhead = head;
        ListNode tail = head;
        int kk;
        boolean flag = false;
        while (true) {
            kk = k;
            while (qhead != null && kk != 0) {
                qhead = qhead.next;
                kk--;
                if (kk == 1 && flag) {
                    tail.next = qhead;
                }
            }
            if (kk != 0)
                break;
            tail = pre;
            pre = reverseList(pre, qhead);
            if (!flag) {
                ans = pre;
                tail.next = null;
            }
            pre = qhead;
            flag = true;
        }
        if (flag)
            tail.next = pre;
        return ans;

    }

    public ListNode reverseList(ListNode pre, ListNode qhead) {
        if (pre == null || pre.next == null)
            return pre;
        ListNode temp1 = pre;
        ListNode temp2 = pre.next;
        while (temp2 != qhead) {
            pre = temp2;
            temp2 = pre.next;
            pre.next = temp1;
            temp1 = pre;
        }
        return pre;
    }
}
