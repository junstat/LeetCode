package CodingInterviews.Q25MergeSortedLinkedList;

import DataStructure.ListNode;

public class Solution1 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return list1 != null ? list1 : list2;
        ListNode head = new ListNode(0);  // 头节点
        ListNode p = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        p.next = list1 != null ? list1 : list2;
        return head.next;
    }
}
