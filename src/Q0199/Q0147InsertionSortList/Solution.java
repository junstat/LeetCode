package Q0199.Q0147InsertionSortList;

import DataStructure.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head); // 头结点，统一插入操作
        ListNode last = head;       // 第一个元素默认有序
        ListNode next = head.next;  // 保存有序部分的最后一个结点

        while (next != null) {
            if (last.val <= next.val) { // 已经有序
                last = next;
            } else {
                ListNode prev = dummy;      // 插入，必须先找前驱结点
                while (prev.next.val < next.val) prev = prev.next;
                last.next = next.next;  // 链表不断
                next.next = prev.next;  // 将next接入prev之后
                prev.next = next;
            }
            next = last.next;
        }
        return dummy.next;
    }
}
