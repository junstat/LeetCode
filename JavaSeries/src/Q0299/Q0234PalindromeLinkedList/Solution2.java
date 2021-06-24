package Q0299.Q0234PalindromeLinkedList;

import DataStructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution2 {
    /*
   方法二: 用栈
  */
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> S = new ArrayDeque<>();
        ListNode p = head, q;
        while (p != null) {
            S.push(p);
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
