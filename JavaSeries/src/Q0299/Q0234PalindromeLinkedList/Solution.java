package Q0299.Q0234PalindromeLinkedList;

import DataStructure.ListNode;

public class Solution {
    /*
       方法一:
       1. 找中点
       2. 反转后半部分
       3. 遍历两部分，不等则false，否则true.
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre, p = head, r = p.next;
        p.next = null;
        while (r != null) {
            pre = p;
            p = r;
            r = r.next;
            p.next = pre;
        }
        return p;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // if fast != null, list has odd numbers
        if (fast != null) slow = slow.next;
        slow = reverseList(slow);
        while (slow != null) {
            if (slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}
