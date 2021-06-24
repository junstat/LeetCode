package Q0199.Q0143ReorderList;

import DataStructure.ListNode;

public class Solution {
    /*
      方法一:
          1、找中点，把链表断成前后2部分
          2、后半部分reverse
          3、同步遍历，把后半部分结点插入到前半部分
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        // step 1.
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        // step 2.
        ListNode last = mid, pre = null;
        while (last != null) {
            ListNode next = last.next;
            last.next = pre;
            pre = last;
            last = next;
        }
        // step 3.
        while (head != null && pre != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = pre.next;
            head.next.next = next;
            head = next;
        }
    }
}
