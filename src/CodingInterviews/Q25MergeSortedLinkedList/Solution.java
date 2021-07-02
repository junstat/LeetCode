package CodingInterviews.Q25MergeSortedLinkedList;

/*
   面试题25: 合并两个排序的链表
       输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */

import DataStructure.ListNode;

/*
   方法一: 递归
       设f(l1, l2)为递归功能函数
       递归终止条件:
            f(l1, l2) = l2;  若 l1 == null
            f(l1, l2) = l1;  若 l2 == null
        递归主体:
            f(l1, l2) = l1 + f(l1->next, l2);  若 l1的结点值 小于 l2的结点值
            f(l1, l2) = l2 + f(l1, l2-> next); else
 */
public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return list1 != null ? list1 : list2;
        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
