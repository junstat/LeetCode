package Q200.Q160IntersectionofTwoLinkedLists;

import DataStructure.ListNode;

public class Solution {
    /*
         设len(A) = m, len(B) = n; A与B共同的部分len = s;
          m1 = m - s; n1 = n - s;
          本题的关键是如何 处理 一般情况下: m1 != n1
       方法一: 方案： 求和
       鉴于 (m1 + s) + n1 = m + n1 =
            m1 + ( s + n1) = m1 + n
        于是，以headA为出发点的pA走过 m + n1, 以headB为出发点的pB走过 n + m1，pA与pB即可在交叉点相遇
      */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }

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
