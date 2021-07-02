package Q0399.Q0328OddEvenLinkedList;

import DataStructure.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        int len = 1;
        ListNode right = new ListNode(0);
        ListNode left = new ListNode(0);
        ListNode l = left;
        ListNode r = right;
        while (head != null) {
            if (len % 2 == 1) {
                l.next = head;
                l = l.next;
            } else {
                r.next = head;
                r = r.next;
            }
            head = head.next;
            len++;
        }
        r.next = null;
        l.next = right.next;
        return left.next;
    }
}
