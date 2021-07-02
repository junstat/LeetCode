package Q0299.Q0206ReverseLinkedList;

import DataStructure.ListNode;

/*
   method 3: recursive solution
 */
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        return helper(head, null);
    }

    private ListNode helper(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        var next = head.next;
        head.next = newHead;
        return helper(next, head);
    }
}
