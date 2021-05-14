package Q0199.Q0160IntersectionofTwoLinkedLists;

import DataStructure.ListNode;

public class Solution2 {
    /*
   方法二: 方案: 作差
   设 L = max(m, n), S = min(m, n) -> d = L - S
    长度为L的链表先走d步，然后与长度为S的链表齐步走，即可相遇
  */
    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            ++len;
            head = head.next;
        }
        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int m = getLength(headA), n = getLength(headB);
        ListNode p, q;
        for (p = headA; m > n; m--) p = p.next;
        for (q = headB; m < n; n--) q = q.next;
        while (p != null && q != null && p != q) {
            p = p.next;
            q = q.next;
        }
        return (p != null && q != null) ? p : null;
    }
}
