package Q0199.Q0160IntersectionofTwoLinkedLists;

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }
}
