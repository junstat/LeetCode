package Q100.Q021MergeTwoSortedLists;

import DataStructure.ListNode;

public class Solution {
    /*
       递归
       设f(l1, l2)为递归功能函数
       递归终止条件:
            f(l1, l2) = l2;  若 l1 == null
            f(l1, l2) = l1;  若 l2 == null
        递归主体:
            f(l1, l2) = l1 + f(l1->next, l2);  若 l1的结点值 小于 l2的结点值
            f(l1, l2) = l2 + f(l1, l2-> next); else
      */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    /*
       非递归
      */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;
        ListNode head = new ListNode(0); // 头结点
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
