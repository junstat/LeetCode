package Q300.Q234PalindromeLinkedList;

import DataStructure.ListNode;

import java.util.Stack;

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

    public boolean isPalindrome1(ListNode head) {
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

    /*
       方法二: 用栈
      */
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> S = new Stack<>();
        ListNode p = head, q;
        while (p != null) {
            S.add(p);
            p = p.next;
        }
        for (p = head; p != null; p = p.next) {
            q = S.peek();
            if (q.val != p.val) return false;
            S.pop();
        }
        return true;
    }
}
