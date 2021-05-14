package Q0199.Q0143ReorderList;

import DataStructure.ListNode;

import java.util.Stack;

public class Solution2 {
    /*
   方法二: 空间换时间，把方法一中， step 2. 反转的活交给 Stack
  */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        Stack<ListNode> S = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            S.add(cur);
            cur = cur.next;
        }
        int cnt = (S.size() - 1) / 2;
        cur = head;
        while (cnt-- > 0) {
            ListNode t = S.pop();
            ListNode next = cur.next;
            cur.next = t;
            t.next = next;
            cur = next;
        }
        S.peek().next = null;
    }
}
