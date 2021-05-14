package Q0299.Q0203RemoveLinkedListElements;

import DataStructure.ListNode;

public class Solution {
    /*
       删除，找前驱咯~
      */
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            if (cur.val != val) {
                pre = cur;
            } else {
                if (cur == head) head = cur.next;  // 删除头结点
                else pre.next = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
