package Q0099.Q0082RemoveDuplicatesfromSortedListII;

import DataStructure.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MAX_VALUE, head);
        ListNode prev = dummy;
        while (prev != null && prev.next != null) {
            ListNode cur = prev.next;
            if (cur.next == null || cur.next.val != cur.val) prev = cur;
            else {
                while (cur.next != null && cur.next.val == cur.val) cur = cur.next;  // 找到重复值的最后一个结点
                prev.next = cur.next;  // 删除重复结点
            }
        }
        return dummy.next;
    }
}
